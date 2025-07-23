package com.aurionpro.Product.model;

public class Product {
	String category;
	String name;
	double price;
	public Product(String category, String name, double price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
//		return "Product [category=" + category + ", name=" + name + ", price=" + price + "]";
		
		 return String.format("%-15s %-20s %-10.2f", category, name, price); //left align
	}
	
}
//Q4. Sort Products by Category then by Price
//(Ascending)
//🔸 Problem:
//Create a Product class with:
// String category
// String name
// double price
//Sort all products:
// Grouped by category (A to Z),
// Within each category, sort by price.
