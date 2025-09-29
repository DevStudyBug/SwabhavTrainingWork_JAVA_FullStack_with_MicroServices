package com.aurionpro.bankapp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRequest {
    @NotNull private String transtype; // debit, credit, transfer
    @NotNull private BigDecimal amount;
    private Long destinationAccountId;
    private String remarks;
}
