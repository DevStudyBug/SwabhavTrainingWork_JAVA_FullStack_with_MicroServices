package com.aurionpro.model;

public class Invoice {
	public String itemName;
	public int quantity;
	public double price;
	
	public Invoice(String itemName, int quantity, double price) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		
	}

	@Override
	public String toString() {
		return "Invoice [itemName=" + itemName + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
//3. Invoice Formatter
//Create a class Invoice with fields itemName, quantity, and price.
//Write a Consumer<Invoice> to print a formatted bill line: