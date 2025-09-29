package com.aurionpro.bankapp.service.impl;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aurionpro.bankapp.entity.Account;
import com.aurionpro.bankapp.entity.Address;
import com.aurionpro.bankapp.entity.Customer;
import com.aurionpro.bankapp.entity.Role;
import com.aurionpro.bankapp.entity.User;
import com.aurionpro.bankapp.repository.AccountRepository;
import com.aurionpro.bankapp.repository.CustomerRepository;
import com.aurionpro.bankapp.repository.RoleRepository;
import com.aurionpro.bankapp.repository.UserRepository;
import com.aurionpro.bankapp.security.JwtUtil;
import com.aurionpro.bankapp.service.AuthService;
import com.aurionpro.bankapp.service.EmailService;

@Service
public class AuthServiceImpl implements AuthService {

    private final CustomerRepository customerRepo;
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final AccountRepository accountRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final EmailService emailService;

    public AuthServiceImpl(CustomerRepository customerRepo, UserRepository userRepo, RoleRepository roleRepo,
            AccountRepository accountRepo, PasswordEncoder passwordEncoder, JwtUtil jwtUtil,
            @Lazy EmailService emailService) {
        this.customerRepo = customerRepo;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.accountRepo = accountRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.emailService = emailService;
    }

    // ------------------ REGISTER CUSTOMER ------------------
    @Override
    public Customer registerCustomer(String username, String password, String email, String name, String contactNo,
            String dobStr, String city, String state, String pincode) {

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        Role customerRole = roleRepo.findByName("ROLE_CUSTOMER")
                .orElseThrow(() -> new RuntimeException("ROLE_CUSTOMER not found"));
        user.setRoles(Set.of(customerRole));

        Address address = new Address(city, state, pincode);

        Customer customer = new Customer();
        customer.setName(name);
        customer.setContactNo(contactNo);
        customer.setDob(LocalDate.parse(dobStr, DateTimeFormatter.ISO_DATE));
        customer.setUser(user);
        customer.setAddress(address);

        Customer savedCustomer = customerRepo.save(customer);

        if (email != null && !email.isBlank()) {
            String subject = "Welcome to Our Bank";
            String body = String.format(
                    "Dear %s,\nYour account has been created!\nUsername: %s\nPassword: %s\nPlease change your password after first login.",
                    name, username, password);
            emailService.sendSimpleMessage(email, subject, body);
        }

        return savedCustomer;
    }

    // ------------------ LOGIN ------------------
    @Override
    public String login(String username, String password) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getUsername());
    }

    // ------------------ ACCESS CHECK ------------------
    @Override
    public void checkAccess(Long resourceCustomerId) throws AccessDeniedException {
        String username = getLoggedInUsername();

        User currentUser = userRepo.findByUsername(username)
                .orElseThrow(() -> new AccessDeniedException("Unauthorized"));

        boolean isAdmin = currentUser.getRoles().stream()
                .anyMatch(r -> r.getName().equals("ROLE_ADMIN"));

        if (isAdmin) return; // admin can access any customer

        // else check if this customer is accessing own data
        Customer currentCustomer = customerRepo.findByUserUsername(username)
                .orElseThrow(() -> new AccessDeniedException("Unauthorized"));

        if (!currentCustomer.getId().equals(resourceCustomerId)) {
            throw new AccessDeniedException("You cannot access this resource");
        }
    }

    @Override
    public void checkAccountOwnership(Long accountId) throws AccessDeniedException {
        if (accountId == null)
            throw new AccessDeniedException("Account id missing");

        Account account = accountRepo.findById(accountId)
                .orElseThrow(() -> new AccessDeniedException("Account not found: " + accountId));

        String username = getLoggedInUsername();
        User currentUser = userRepo.findByUsername(username)
                .orElseThrow(() -> new AccessDeniedException("Unauthorized"));

        boolean isAdmin = currentUser.getRoles().stream()
                .anyMatch(r -> r.getName().equals("ROLE_ADMIN"));

        if (isAdmin) return; // admin can access any account

        Customer currentCustomer = customerRepo.findByUserUsername(username)
                .orElseThrow(() -> new AccessDeniedException("Unauthorized"));

        if (account.getCustomer() == null || !account.getCustomer().getId().equals(currentCustomer.getId())) {
            throw new AccessDeniedException("You cannot access this account");
        }
    }

    // ------------------ HELPER ------------------
    private String getLoggedInUsername() throws AccessDeniedException {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() || auth.getName() == null
            || auth.getName().equals("anonymousUser")) {
            throw new AccessDeniedException("Unauthorized");
        }
        return auth.getName();
    }
}

