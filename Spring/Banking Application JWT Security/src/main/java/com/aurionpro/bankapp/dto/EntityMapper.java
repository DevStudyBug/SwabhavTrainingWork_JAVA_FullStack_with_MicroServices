package com.aurionpro.bankapp.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.aurionpro.bankapp.entity.Account;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.entity.Transaction;

public class EntityMapper {

    // ------------------ Customer → CustomerResponse ------------------
    public static CustomerResponse toCustomerResponse(Customer c) {
        if (c == null) return null;

        String username = null;
        String email = null;
        if (c.getUser() != null) {
            username = c.getUser().getUsername();
            email = c.getUser().getEmail();
        }

        String city = null, state = null, pincode = null;
        if (c.getAddress() != null) {
            city = c.getAddress().getCity();
            state = c.getAddress().getState();
            pincode = c.getAddress().getPincode();
        }

        CustomerResponse response = new CustomerResponse();
        response.setId(c.getId());
        response.setUsername(username);
        response.setEmail(email);
        response.setName(c.getName());
        response.setContactNo(c.getContactNo());
        response.setDob(c.getDob());
        response.setCity(city);
        response.setState(state);
        response.setPincode(pincode);

        return response;
    }

    // ------------------ Transaction → TransactionResponse ------------------
    public static TransactionResponse toTransactionResponse(Transaction t) {
        if (t == null) return null;
        return new TransactionResponse(
                t.getId(),
                t.getTranstype(),
                t.getAmount(),
                t.getDateTime(),
                t.getRemarks()
        );
    }

    // ------------------ Account → AccountResponse ------------------
    public static AccountResponse toAccountResponse(Account a) {
        if (a == null) return null;

        List<TransactionResponse> txns = null;
        if (a.getTransactions() != null) {
            txns = a.getTransactions().stream()
                    .map(EntityMapper::toTransactionResponse)
                    .collect(Collectors.toList());
        }

        Long custId = null;
        if (a.getCustomer() != null) {
            custId = a.getCustomer().getId();
        }

        return new AccountResponse(
                a.getId(),
                a.getAccountNumber(),
                a.getAccountType(),
                a.getBalance(),
                a.isActive(),
                custId,
                txns
        );
    }
}
