package com.aurionpro.calculator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.aurionpro.calculator.model.BankAccount;

public class BankAccountTest {



    private BankAccount account;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("=== Starting BankAccount Tests ===");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("=== Finished BankAccount Tests ===");
    }

    @BeforeEach
    void setup() {
        account = new BankAccount(1000.0);
        System.out.println("Test Started.");
    }

    @AfterEach
    void teardown() {
        System.out.println("Test Finished.\n");
    }

    @Tag("regression")
    @Test
    void test_deposit_positive_amount() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }

    @Tag("regression")
    @Test
    void test_deposit_negative_amount_should_throw_exception() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0));
    }

    @Tag("critical")
    @Test
    void test_withdraw_valid_amount() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance());
    }

    @Tag("critical")
    @Test
    void test_withdraw_insufficient_balance_should_throw_exception() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1500.0));
    }

    @Tag("critical")
    @Test
    void test_withdraw_negative_amount_should_throw_exception() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0));
    }
}
