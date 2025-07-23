package com.aurionpro.model;
/*4. Product Details Editor:
- Create a Product class with private fields: id, name, price.
- Provide getters and setters.
- Add validation in setter to ensure price > 0.
- Create a method to display full product details
*/
public class Product {
	private int id;
	private String name;
	private double price;
	
	public int getid() {
		return id;
	}
	public String getname() {
		return name;
	}
	public double getprice() {
		return price;
	}
	public void setid(int id) {
		this.id = id;
	}
	public void setname(String name) {
		this.name = name;
	}
	public void setprice(double price ) {
		if (price>0) {
			this.price= price;
		}
		else {
			System.out.println("Invalid price!");
		}	
	}
	public String toString() {
		return "Product details { Product id: " + id + " name: "+ name+ " price: "+ price + " }";
	}
}
