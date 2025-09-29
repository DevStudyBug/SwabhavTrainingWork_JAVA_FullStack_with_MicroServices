package com.aurionpro.bankapp.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bankapp.dto.AccountRequest;
import com.aurionpro.bankapp.dto.AccountResponse;
import com.aurionpro.bankapp.dto.EntityMapper;
import com.aurionpro.bankapp.entity.Account;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.repository.CustomerRepository;
import com.aurionpro.bankapp.service.AccountService;
import com.aurionpro.bankapp.service.AuthService;
import com.aurionpro.bankapp.service.EmailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;
    private final AuthService authService;
    private final EmailService emailService;
    private final CustomerRepository customerRepo;

    public AccountController(AccountService accountService,
                             @Lazy AuthService authService,
                             EmailService emailService,
                             CustomerRepository customerRepo) {
        this.accountService = accountService;
        this.authService = authService;
        this.emailService = emailService;
        this.customerRepo = customerRepo;
    }

    // ------------------ CREATE ACCOUNT (ADMIN ONLY) ------------------
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody AccountRequest req) {
        Account account = accountService.create(req);

        Customer customer = account.getCustomer();
        String to = customer.getUser().getEmail();
        String subject = "Account Created Successfully";
        String text = String.format(
                "Dear %s,\n\nYour bank account has been created successfully!\n\nAccount Number: %s\nAccount Type: %s\nInitial Balance: %s\n\nThank you for banking with us.",
                customer.getName(),
                account.getAccountNumber(),
                account.getAccountType(),
                account.getBalance()
        );

        emailService.sendSimpleMessage(to, subject, text);

        return ResponseEntity.ok(EntityMapper.toAccountResponse(account));
    }

    // ------------------ GET ACCOUNT BY ID ------------------
    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> get(@PathVariable Long id) throws AccessDeniedException {
        Account account = accountService.getById(id);
        authService.checkAccountOwnership(account.getId());
        return ResponseEntity.ok(EntityMapper.toAccountResponse(account));
    }

    // ------------------ GET ALL ACCOUNTS (ADMIN ONLY) ------------------
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AccountResponse>> all() {
        List<AccountResponse> accounts = accountService.getAll().stream()
                .map(EntityMapper::toAccountResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(accounts);
    }

    // ------------------ GET ACCOUNTS BY CUSTOMER ------------------
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<AccountResponse>> byCustomer(@PathVariable Long customerId) throws AccessDeniedException {
        authService.checkAccess(customerId);
        List<AccountResponse> accounts = accountService.getByCustomerId(customerId).stream()
                .map(EntityMapper::toAccountResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(accounts);
    }

    // ------------------ GET LOGGED-IN CUSTOMER ACCOUNTS ------------------
    @GetMapping("/me")
    public ResponseEntity<List<AccountResponse>> myAccounts() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Customer customer = customerRepo.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        List<AccountResponse> accounts = accountService.getByCustomerId(customer.getId()).stream()
                .map(EntityMapper::toAccountResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(accounts);
    }

    // ------------------ DEACTIVATE ACCOUNT (ADMIN ONLY) ------------------
    @PatchMapping("/deactivate/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deactivate(@PathVariable Long id) {
        try {
            Account account = accountService.deactivate(id);
            return ResponseEntity.ok(EntityMapper.toAccountResponse(account));
        } catch (IllegalStateException ex) {
            // Account already deactivated
            return ResponseEntity.status(400).body(
                    Map.of("status", 400, "message", ex.getMessage())
            );
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(
                    Map.of("status", 500, "message", ex.getMessage())
            );
        }
    }
}
