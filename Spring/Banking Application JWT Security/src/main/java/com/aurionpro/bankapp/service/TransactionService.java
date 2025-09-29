package com.aurionpro.bankapp.service;

import com.aurionpro.bankapp.dto.PassbookResponse;
import com.aurionpro.bankapp.dto.TransactionRequest;
import com.aurionpro.bankapp.dto.TransferTransactionResponse;
import com.aurionpro.bankapp.entity.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction create(Long accountId, TransactionRequest req);

    TransferTransactionResponse transfer(Long accountId, TransactionRequest req);

    List<Transaction> getByAccount(Long accountId);

    List<Transaction> getByCustomer(Long customerId);

    PassbookResponse getPassbook(Long accountId);

    void sendPassbookEmail(Long accountId);
}
