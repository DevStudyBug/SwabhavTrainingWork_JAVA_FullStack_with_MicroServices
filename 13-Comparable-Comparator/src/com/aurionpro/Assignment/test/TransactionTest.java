package com.aurionpro.Assignment.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.aurionpro.Transaction.model.SortByAmountThenId;
import com.aurionpro.Transaction.model.Transaction;

public class TransactionTest {
	 public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Transaction> list = new ArrayList<>();

	        System.out.println("----- Enter Transaction Details -----\n");

	        while (true) {
	            try {
	                int id;
	                while (true) {
	                    try {
	                        System.out.print("Enter Transaction ID: ");
	                        id = Integer.parseInt(scanner.nextLine());
	                        if (id <= 0) {
	                            throw new IllegalArgumentException("Transaction ID must be a positive number!\n");
	                        }
	                        break;
	                    } catch (NumberFormatException e) {
	                        System.out.println("Invalid input! Please enter a numeric ID.\n");
	                    } catch (IllegalArgumentException e) {
	                        System.out.println(e.getMessage());
	                    }
	                }

	                double amount;
	                while (true) {
	                    try {
	                        System.out.print("Enter Transaction Amount: ");
	                        amount = Double.parseDouble(scanner.nextLine());
	                        if (amount <= 0) {
	                            throw new IllegalArgumentException("Amount must be a positive number!\n");
	                        }
	                        break;
	                    } catch (NumberFormatException e) {
	                        System.out.println("Invalid input! Please enter a numeric amount.\n");
	                    } catch (IllegalArgumentException e) {
	                        System.out.println(e.getMessage());
	                    }
	                }

	                list.add(new Transaction(id, amount));

	                String choice;
	                while (true) {
	                    System.out.print("Do you want to add another transaction? (yes/no): ");
	                    choice = scanner.nextLine().toLowerCase();
	                    if (choice.equals("yes") || choice.equals("no")) {
	                        break;
	                    }
	                    System.out.println("Please enter 'yes' or 'no' only.\n");
	                }
	                if (choice.equals("no")) {
	                    break;
	                }

	            } catch (Exception e) {
	                System.out.println("Unexpected error: " + e.getMessage());
	            }
	        }

	        if (list.isEmpty()) {
	            System.out.println("\nNo transactions to sort!");
	            scanner.close();
	            return;
	        }

	        Collections.sort(list, new SortByAmountThenId());

	        System.out.println("\n----- Transactions sorted by Amount (Descending) then ID (Ascending) -----\n");
	        System.out.printf("%-10s %-15s\n", "ID", "Amount");
	        System.out.println("--------------------------------");

	        for (Transaction t : list) {
	            System.out.println(t);
	        }

	        scanner.close();
	    }
	}