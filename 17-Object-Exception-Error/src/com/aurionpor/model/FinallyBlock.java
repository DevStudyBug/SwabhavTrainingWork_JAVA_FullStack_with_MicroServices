package com.aurionpor.model;

import java.util.Scanner;

public class FinallyBlock {

	   public static void main(String[] args) {
	        
	        int balance = 10000;  
	        Scanner scanner = new Scanner(System.in);

	        try {
	            System.out.print("Enter amount to withdraw: ₹");
	            int amount = scanner.nextInt();

	            if (amount > balance) {
	                throw new ArithmeticException("Insufficient Balance! Transaction failed.");
	            } else if (amount <= 0) {
	                throw new ArithmeticException("Invalid amount! Please enter a positive value.");
	            } else {
	                balance -= amount;
	                System.out.println("Withdrawal successful! New Balance: ₹" + balance);
	            }

	        } catch (ArithmeticException e) {
	            System.out.println(e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Invalid input! Please enter a numeric value.");
	        } finally {
	            System.out.println("\nTransaction session ended.");
	            scanner.close();
	        }
	    }
	}
/*. finally block 
 * Problem Statement:
Write a program to simulate ATM cash withdrawal.
 Take a hardcoded account balance (e.g., ₹10,000)
 Ask the user to enter an amount to withdraw
 If the amount is greater than balance, throw ArithmeticException
 Else, deduct and show the new balance
 In all cases, the program should print "Transaction session ended." using a
finally block, regardless of whether the transaction was successful or failed.*/
 