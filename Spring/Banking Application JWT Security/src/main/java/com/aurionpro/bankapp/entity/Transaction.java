package com.aurionpro.bankapp.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.aurionpro.bankapp.dto.TransactionResponse;
import lombok.Data;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Transaction type is required")
    private String transtype;

    @DecimalMin(value = "1.0", message = "Amount must be greater than 0")
    private BigDecimal amount;

    @NotNull(message = "Transaction date is required")
    private LocalDateTime dateTime;

    private String remarks;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Helper method to convert entity to DTO
    public TransactionResponse toTransactionResponse() {
        return new TransactionResponse(
                this.id,
                this.transtype,
                this.amount,
                this.dateTime,
                this.remarks
        );
    }
}
