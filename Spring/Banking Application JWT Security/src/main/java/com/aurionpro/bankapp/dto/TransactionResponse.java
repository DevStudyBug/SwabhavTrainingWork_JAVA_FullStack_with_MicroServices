package com.aurionpro.bankapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.aurionpro.bankapp.entity.Transaction;

@NoArgsConstructor
@Data
public class TransactionResponse {
    private Long id;
    private String transtype;
    private BigDecimal amount;
    private LocalDateTime dateTime;
    private String remarks;

    // existing all-args constructor (if you want to keep)
    public TransactionResponse(Long id, String transtype, BigDecimal amount, LocalDateTime dateTime, String remarks) {
        this.id = id;
        this.transtype = transtype;
        this.amount = amount;
        this.dateTime = dateTime;
        this.remarks = remarks;
    }

    // ✅ new: constructor that accepts the Entity
    public TransactionResponse(Transaction t) {
        if (t == null) return;
        this.id = t.getId();
        this.transtype = t.getTranstype();
        this.amount = t.getAmount();
        this.dateTime = t.getDateTime();
        this.remarks = t.getRemarks();
    }
}
