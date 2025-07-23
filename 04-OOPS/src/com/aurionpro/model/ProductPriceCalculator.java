package com.aurionpro.model;
/*2. Product Price Calculator:
- Create a Product class with fields: productName, price, quantity.
- Create a constructor to initialize all fields.
- Create a method calculateTotal() that returns total price = price × quantity.
- Create 2 product objects and display their total cost.*/

public class ProductPriceCalculator {
	String productName;
	int price;
	int quantity;
	
	public ProductPriceCalculator(String productName, int price, int quantity) {
		this.productName=productName;
		this.price=price;
		this.quantity=quantity;
	}
	
	public int calculateTotal() {
		return price * quantity;
	}
	
	public void display() {
		System.out.println("Product name :"+productName);
		System.out.println("Product price :"+price);
		System.out.println("Quantity :"+quantity);
		System.out.println("Total price is :"+calculateTotal());
	}

}
