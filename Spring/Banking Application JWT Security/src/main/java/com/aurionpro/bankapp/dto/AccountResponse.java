package com.aurionpro.bankapp.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.aurionpro.bankapp.entity.Account;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountResponse {
    private Long id;
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private boolean active;
    private Long customerId;
    private List<TransactionResponse> transactions;

    public AccountResponse(Account account) {
        this.id = account.getId();
        this.accountNumber = account.getAccountNumber();
        this.accountType = account.getAccountType();
        this.balance = account.getBalance();
        this.active = account.isActive();
        this.customerId = account.getCustomer().getId();

        // Null safe mapping
        if (account.getTransactions() != null) {
            this.transactions = account.getTransactions()
                    .stream()
                    .map(TransactionResponse::new)
                    .collect(Collectors.toList());
        }
    }
  
    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public List<TransactionResponse> getTransactions() { return transactions; }
    public void setTransactions(List<TransactionResponse> transactions) { this.transactions = transactions; }
}
