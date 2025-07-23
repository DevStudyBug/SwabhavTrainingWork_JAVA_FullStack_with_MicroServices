package com.aurionpro.Transaction.model;

import java.util.Comparator;

public class SortByAmountThenId implements Comparator<Transaction> {

	@Override
	public int compare(Transaction t1, Transaction t2) {

		int amountCompare = Double.compare(t2.amount, t1.amount); // Descending
		return (amountCompare == 0) ? Integer.compare(t1.id, t2.id) : amountCompare;
	}

}
