package com.aurionpro.model;
/*5. Bank Account Balance Checker:
- Create a class BankAccount with fields: accountNumber, accountHolder, balance.
- Use a parameterized constructor to initialize these fields.
- Add a method checkBalance() to print the current balance.
- Create multiple accounts and call the method on each object.*/

public class BankAccount {
	 private String accountNumber;
	    private String accountHolder;
	    private double balance;

	    public BankAccount(String accountNumber, String accountHolder, double balance) {
	        this.accountNumber = accountNumber;
	        this.accountHolder = accountHolder;
	        this.balance = balance;
	    }
	    
	    public void checkBalance() {
	        System.out.println("Account Holder: " + accountHolder + ", Account Number: " + accountNumber + ", Balance: " + balance);
	    }
}
