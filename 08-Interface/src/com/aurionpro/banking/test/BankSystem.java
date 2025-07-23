package com.aurionpro.banking.test;

import java.util.Scanner;

import com.aurionpro.banking.model.CurrentAccount;
import com.aurionpro.banking.model.IAccountOperations;
import com.aurionpro.banking.model.LoanAccount;
import com.aurionpro.banking.model.SavingsAccount;

public class BankSystem {



	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        IAccountOperations account = null;

	        while (true) {
	            try {
	                System.out.println("\n--- Bank Menu ---");
	                System.out.println("1. Savings Account");
	                System.out.println("2. Current Account");
	                System.out.println("3. Loan Account");
	                System.out.println("4. Exit");
	                System.out.print("Choose Account Type (1-4): ");
	                int choice = Integer.parseInt(scanner.nextLine());

	                if (choice == 4) {
	                    System.out.println("Thank you for using the banking system!");
	                    break;
	                }

	                switch (choice) {
	                    case 1:
	                        account = new SavingsAccount();
	                        break;
	                    case 2:
	                        account = new CurrentAccount();
	                        break;
	                    case 3:
	                        LoanAccount loan = new LoanAccount();
	                        System.out.print("Enter your CIBIL Score (300-900): ");
	                        int score = Integer.parseInt(scanner.nextLine());
	                        loan.setCibilScore(score);
	                        account = loan;
	                        break;
	                    default:
	                        System.out.println("Invalid account type!");
	                        continue;
	                }

	                while (true) {
	                    System.out.println("\n-- Operations Menu --");
	                    System.out.println("1. Deposit");
	                    System.out.println("2. Withdraw");
	                    System.out.println("3. Check Balance");
	                    if (account instanceof LoanAccount) {
	                        System.out.println("4. Check CIBIL Score");
	                        System.out.println("5. Back to Account Menu");
	                    } else {
	                        System.out.println("4. Back to Account Menu");
	                    }
	                    System.out.print("Choose operation: ");
	                    int op = Integer.parseInt(scanner.nextLine());

	                    if ((account instanceof LoanAccount && op == 5) ||
	                        (!(account instanceof LoanAccount) && op == 4)) {
	                        break;
	                    }

	                    switch (op) {
	                        case 1:
	                            System.out.print("Enter deposit amount: ");
	                            double depositAmt = Double.parseDouble(scanner.nextLine());
	                            account.deposit(depositAmt);
	                            break;
	                        case 2:
	                            System.out.print("Enter withdrawal amount: ");
	                            double withdrawAmt = Double.parseDouble(scanner.nextLine());
	                            account.withdraw(withdrawAmt);
	                            break;
	                        case 3:
	                            account.checkBalance();
	                            break;
	                        case 4:
	                            if (account instanceof LoanAccount) {
	                                System.out.println("CIBIL Score: " + ((LoanAccount) account).getCibilScore());
	                            } else {
	                                System.out.println("Invalid operation!");
	                            }
	                            break;
	                        default:
	                            System.out.println("Invalid operation!");
	                    }
	                }

	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input! Please enter numbers only.");
	            } catch (Exception e) {
	                System.out.println("Unexpected error: " + e.getMessage());
	            }
	        }

	        scanner.close();
	    }
	}