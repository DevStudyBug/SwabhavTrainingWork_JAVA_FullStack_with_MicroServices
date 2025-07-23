package com.aurionpro.Transaction.model;

public class Transaction {
	int id;
	double amount;
	public Transaction(int id, double amount) {
		this.id = id;
		this.amount = amount;
	}
	@Override
	public String toString() {
//		return "Transaction [id=" + id + ", amount=" + amount + "]";
		 return String.format("%-10d %-15.2f", id, amount);
	}
	
	
}

//Q5. Sort Transactions by Amount (Descending),
//Fallback to ID
//🔸 Problem:
//Class Transaction with:
// int id
// double amount
//Sort by:
// amount (high to low)
// If equal, sort by id (ascending)