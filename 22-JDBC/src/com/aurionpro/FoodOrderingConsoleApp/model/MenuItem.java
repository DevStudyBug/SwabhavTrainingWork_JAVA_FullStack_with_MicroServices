package com.aurionpro.FoodOrderingConsoleApp.model;


public class MenuItem {
	private int id;
	private String name;
	private double price;

	public MenuItem(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("┌────┬────────────────────┬──────────┐\n");
	    sb.append(String.format("│ %-2s │ %-18s │ %-8s │%n", "ID", "Item Name", "Price"));
	    sb.append("├────┼────────────────────┼──────────┤\n");
	    sb.append(String.format("│ %-2d │ %-18s │ ₹%-7.2f │%n", id, name, price));
	    sb.append("└────┴────────────────────┴──────────┘");
	    return sb.toString();
	}

}