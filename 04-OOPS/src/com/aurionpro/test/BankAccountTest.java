package com.aurionpro.test;
import java.util.Scanner;
import com.aurionpro.model.BankAccount;
/*5. Bank Account Balance Checker:
- Create a class BankAccount with fields: accountNumber, accountHolder, balance.
- Use a parameterized constructor to initialize these fields.
- Add a method checkBalance() to print the current balance.
- Create multiple accounts and call the method on each object.*/

public class BankAccountTest {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        BankAccount[] accounts = new BankAccount[3];  

	        for (int i = 0; i < 3; i++) {

	            System.out.print("Enter Account Number: ");
	            String accountNumber = scanner.nextLine();

	            System.out.print("Enter Account Holder Name: ");
	            String accountHolder = scanner.nextLine();

	            System.out.print("Enter Balance: ");
	            double balance = scanner.nextDouble();
	            scanner.nextLine(); 

	            accounts[i] = new BankAccount(accountNumber, accountHolder, balance);
	        }

	        System.out.println("\n--- Bank Account Details ---");
	        for (BankAccount acc : accounts) {
	            acc.checkBalance();
	        }

	        scanner.close();
	    }
	}


