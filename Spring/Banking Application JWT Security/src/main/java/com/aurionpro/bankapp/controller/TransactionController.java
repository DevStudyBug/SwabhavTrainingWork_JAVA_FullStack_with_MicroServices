package com.aurionpro.bankapp.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aurionpro.bankapp.dto.EntityMapper;
import com.aurionpro.bankapp.dto.TransactionRequest;
import com.aurionpro.bankapp.dto.TransactionResponse;
import com.aurionpro.bankapp.dto.TransferTransactionResponse;
import com.aurionpro.bankapp.entity.Transaction;
import com.aurionpro.bankapp.service.AuthService;
import com.aurionpro.bankapp.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final AuthService authService;

    public TransactionController(TransactionService transactionService, AuthService authService) {
        this.transactionService = transactionService;
        this.authService = authService;
    }

    // ------------------ CREATE TRANSACTION ------------------
    @PostMapping("/account/{accountId}")
    public ResponseEntity<?> createTransaction(@PathVariable Long accountId,
                                               @RequestBody TransactionRequest req) throws AccessDeniedException {
        authService.checkAccountOwnership(accountId);

        if ("transfer".equalsIgnoreCase(req.getTranstype())) {
            TransferTransactionResponse transferResponse = transactionService.transfer(accountId, req);
            return ResponseEntity.ok(transferResponse);
        } else {
            Transaction txn = transactionService.create(accountId, req);
            return ResponseEntity.ok(EntityMapper.toTransactionResponse(txn));
        }
    }

    // ------------------ GET TRANSACTIONS BY ACCOUNT ------------------
    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<TransactionResponse>> getTransactionsByAccount(@PathVariable Long accountId)
            throws AccessDeniedException {
        authService.checkAccountOwnership(accountId);

        List<TransactionResponse> txns = transactionService.getByAccount(accountId).stream()
                .map(EntityMapper::toTransactionResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(txns);
    }

    // ------------------ GET TRANSACTIONS BY CUSTOMER ------------------
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<TransactionResponse>> getTransactionsByCustomer(@PathVariable Long customerId)
            throws AccessDeniedException {
        authService.checkAccess(customerId);

        List<TransactionResponse> txns = transactionService.getByCustomer(customerId).stream()
                .map(EntityMapper::toTransactionResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(txns);
    }

    @GetMapping("/passbook/email/{accountId}")
    public ResponseEntity<String> emailPassbook(@PathVariable Long accountId) throws AccessDeniedException {
        authService.checkAccountOwnership(accountId); // ✅ ensure token matched accountId
        transactionService.sendPassbookEmail(accountId);
        return ResponseEntity.ok("Passbook emailed successfully to customer.");
    }

}
