package com.aurionpro.banking.model;

public class LoanAccount implements IAccountOperations {
    private double balance;
    private int cibilScore;

    public LoanAccount() {
        this.balance = 0;  // initially no loan taken
        this.cibilScore = 750;  // default good score
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Repayment must be positive.");
            return;
        }
        if (amount > -balance) {
            System.out.println("You are trying to repay more than the loan amount.");
            return;
        }
        balance += amount;  // Repaying loan → reduce negative balance
        System.out.println("Loan repaid: ₹" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Loan amount must be positive.");
            return;
        }

        balance -= amount;  // Taking loan → balance goes more negative
        System.out.println("Loan taken: ₹" + amount);

        if (cibilScore < 650) {
            System.out.println("Warning: Your CIBIL score is low (" + cibilScore + "). Risk of rejection.");
        }
    }

    @Override
    public void checkBalance() {
        if (balance < 0) {
            System.out.println("Outstanding loan balance: ₹" + -balance);
        } else {
            System.out.println("No loan outstanding.");
        }
    }

    public int getCibilScore() {
        return cibilScore;
    }

    public void setCibilScore(int score) {
        if (score < 300 || score > 900) {
            System.out.println("Invalid CIBIL score. Must be between 300-900.");
        } else {
            this.cibilScore = score;
        }
    }
}