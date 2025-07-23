package com.aurionpro.overloading.test;

import com.aurionpro.overloading.model.BillGenerator;

public class BillGeneratorTest {
	public static void main(String[] args) {
		String item = "Book";
		int qty = 2;
		int mrp = 500;
		double discount = 80;
		double tax = 150;
		
		BillGenerator bill = new BillGenerator();
		System.out.println("-----Bill of item-----" + item);
		System.out.println("price : " + bill.generateBill(item, qty, mrp));
		System.out.println("Bill after discount: " + bill.generateBill(item, qty, discount, mrp));
		System.out.println("Total bill including tax: " + bill.generateBill(item, qty, mrp, discount, tax));	
	}
}
