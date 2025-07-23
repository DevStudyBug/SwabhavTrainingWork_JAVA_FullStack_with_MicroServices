package com.aurionpro.test;

import java.util.function.Consumer;

import com.aurionpro.model.Invoice;

public class InvoiceTest {
public static void main(String[] args) {
	Invoice i1 = new Invoice("Pen", 2, 10.0);
	Invoice i2 = new Invoice("Notebook", 1, 50.0);
	Invoice i3 = new Invoice("Pencil", 5, 6.0);

	// Define a Consumer to print formatted bill line
	Consumer<Invoice> printInvoice = invoice -> 
	    System.out.println("Item: " + invoice.itemName + " | Quantity: " + invoice.quantity + " | Price: " + invoice.price);

	// Use the consumer for each invoice
	printInvoice.accept(i1);
	printInvoice.accept(i2);
	printInvoice.accept(i3);
}
}
