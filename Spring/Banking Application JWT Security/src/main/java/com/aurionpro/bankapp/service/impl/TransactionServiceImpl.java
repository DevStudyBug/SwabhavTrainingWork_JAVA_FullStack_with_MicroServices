package com.aurionpro.bankapp.service.impl;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.core.io.ByteArrayResource;

import com.aurionpro.bankapp.dto.PassbookResponse;
import com.aurionpro.bankapp.dto.TransactionRequest;
import com.aurionpro.bankapp.dto.TransactionResponse;
import com.aurionpro.bankapp.dto.TransferTransactionResponse;
import com.aurionpro.bankapp.entity.Account;
import com.aurionpro.bankapp.entity.Transaction;
import com.aurionpro.bankapp.exception.ResourceNotFoundException;
import com.aurionpro.bankapp.repository.AccountRepository;
import com.aurionpro.bankapp.repository.TransactionRepository;
import com.aurionpro.bankapp.service.EmailService;
import com.aurionpro.bankapp.service.TransactionService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import jakarta.mail.MessagingException;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository txnRepo;
    private final AccountRepository accountRepo;
    private final EmailService emailService;

    public TransactionServiceImpl(TransactionRepository txnRepo, AccountRepository accountRepo,
                                  EmailService emailService) {
        this.txnRepo = txnRepo;
        this.accountRepo = accountRepo;
        this.emailService = emailService;
    }

    @Override
    @Transactional
    public Transaction create(Long accountId, TransactionRequest req) {
        String type = req.getTranstype().toLowerCase();
        Account account = getAccount(accountId);
        validateAmount(account, req.getAmount());

        switch (type) {
            case "debit":
            case "withdraw":
                return processDebit(account, req.getAmount(), req.getRemarks());
            case "credit":
            case "deposit":
                return processCredit(account, req.getAmount(), req.getRemarks());
            case "transfer":
                TransferTransactionResponse transferResponse = transfer(accountId, req);
                return txnRepo.findById(transferResponse.getDebitTransaction().getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Transfer debit transaction not found"));
            default:
                throw new IllegalArgumentException("Unsupported transaction type: " + req.getTranstype());
        }
    }

    @Override
    @Transactional
    public TransferTransactionResponse transfer(Long accountId, TransactionRequest req) {
        Account source = getAccount(accountId);
        Account dest = getAccount(req.getDestinationAccountId());

        validateAmount(source, req.getAmount());
        checkTransferConditions(source, dest, req.getAmount());

        source.setBalance(source.getBalance().subtract(req.getAmount()));
        dest.setBalance(dest.getBalance().add(req.getAmount()));

        Transaction debitTx = createTransaction(source, "transfer-debit", req.getAmount(),
                "Transfer to account " + dest.getAccountNumber());
        Transaction creditTx = createTransaction(dest, "transfer-credit", req.getAmount(),
                "Transfer from account " + source.getAccountNumber());

        accountRepo.save(source);
        accountRepo.save(dest);

        sendTransactionEmail(debitTx);
        sendTransactionEmail(creditTx);

        return new TransferTransactionResponse(mapToResponse(debitTx), mapToResponse(creditTx));
    }

    private void validateAmount(Account account, BigDecimal amount) {
        if (!account.isActive()) throw new IllegalArgumentException("Account is deactivated");
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Amount must be greater than 0");
    }

    private void checkTransferConditions(Account source, Account dest, BigDecimal amount) {
        if (!dest.isActive()) throw new IllegalArgumentException("Destination account is deactivated");
        if (source.getBalance().compareTo(amount) < 0) throw new IllegalArgumentException("Insufficient funds");
    }

    private Transaction processDebit(Account account, BigDecimal amt, String remarks) {
        if (account.getBalance().compareTo(amt) < 0) throw new IllegalArgumentException("Insufficient funds");
        account.setBalance(account.getBalance().subtract(amt));
        Transaction tx = createTransaction(account, "debit", amt, remarks);
        accountRepo.save(account);
        sendTransactionEmail(tx);
        return tx;
    }

    private Transaction processCredit(Account account, BigDecimal amt, String remarks) {
        account.setBalance(account.getBalance().add(amt));
        Transaction tx = createTransaction(account, "credit", amt, remarks);
        accountRepo.save(account);
        sendTransactionEmail(tx);
        return tx;
    }

    private Transaction createTransaction(Account account, String type, BigDecimal amt, String remarks) {
        Transaction tx = new Transaction();
        tx.setAccount(account);
        tx.setCustomer(account.getCustomer());
        tx.setTranstype(type);
        tx.setAmount(amt);
        tx.setDateTime(java.time.LocalDateTime.now());
        tx.setRemarks(remarks);
        return txnRepo.save(tx);
    }

    private TransactionResponse mapToResponse(Transaction tx) {
        return new TransactionResponse(tx.getId(), tx.getTranstype(), tx.getAmount(), tx.getDateTime(),
                tx.getRemarks());
    }

    private Account getAccount(Long accountId) {
        return accountRepo.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
    }

    private void sendTransactionEmail(Transaction tx) {
        try {
            String to = tx.getCustomer().getUser().getEmail();
            String subject = "Bank Transaction Alert";
            String text = String.format(
                    "Dear %s,\n\nTransaction Type: %s\nAmount: %s\nDate: %s\nBalance: %s",
                    tx.getCustomer().getName(),
                    tx.getTranstype(),
                    tx.getAmount(),
                    tx.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    tx.getAccount().getBalance()
            );
            emailService.sendSimpleMessage(to, subject, text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> getByAccount(Long accountId) {
        return txnRepo.findByAccount_Id(accountId);
    }

    @Override
    public List<Transaction> getByCustomer(Long customerId) {
        return txnRepo.findByCustomer_Id(customerId);
    }

    @Override
    public PassbookResponse getPassbook(Long accountId) {
        Account account = getAccount(accountId);
        List<TransactionResponse> txns = txnRepo.findByAccount_Id(accountId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return new PassbookResponse(account.getBalance(), txns);
    }

    @Override
    public void sendPassbookEmail(Long accountId) {
        Account account = getAccount(accountId); // make sure account exists
        if (account == null || account.getCustomer() == null || account.getCustomer().getUser() == null) {
            throw new IllegalStateException("Account, customer, or user not found for accountId: " + accountId);
        }

        PassbookResponse passbook = getPassbook(accountId);
        try {
            byte[] pdfBytes = generatePassbookPdf(account, passbook);

            String toEmail = account.getCustomer().getUser().getEmail();
            if (toEmail == null || toEmail.isBlank()) {
                throw new IllegalStateException("User email not found for accountId: " + accountId);
            }

            emailService.sendEmailWithAttachment(
                    toEmail,
                    "Your Passbook PDF",
                    "Dear " + account.getCustomer().getName() + ",\n\nPlease find attached your passbook PDF.",
                    "passbook.pdf",
                    pdfBytes
            );

            System.out.println("Passbook email sent successfully to " + toEmail);

        } catch (MessagingException e) {
            System.err.println("Failed to send passbook email: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error while sending passbook email: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private byte[] generatePassbookPdf(Account account, PassbookResponse passbook) throws Exception {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);
        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
        Paragraph title = new Paragraph("Passbook for Account: " + account.getAccountNumber(), font);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(Chunk.NEWLINE);

        PdfPTable table = new PdfPTable(5);
        Stream.of("ID", "Type", "Amount", "Date", "Remarks")
                .forEach(header -> table.addCell(new PdfPCell(new Phrase(header))));
        for (TransactionResponse txn : passbook.getTransactions()) {
            table.addCell(String.valueOf(txn.getId()));
            table.addCell(txn.getTranstype());
            table.addCell(String.valueOf(txn.getAmount()));
            table.addCell(txn.getDateTime().toString());
            table.addCell(txn.getRemarks());
        }
        document.add(table);
        document.close();

        return out.toByteArray();
    }
}
