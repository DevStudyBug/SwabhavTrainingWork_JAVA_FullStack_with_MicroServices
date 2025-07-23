package com.aurionpro.Composite.Electronics;

public class Part implements Component{
	private String name;
	private int price;
	public Part(String name, int price) {
	this.name = name;
	this.price = price;
	}
	@Override
	public void showDetails() {
	System.out.println("- " + name + " : ₹" + price);
	}
}
