package com.aurionpro.FoodOrderingConsoleApp.model;


public class DeliveryPartner {
	private int id;
	private String name;
	private String contact;

	public DeliveryPartner(int id, String name, String contact) {
		this.id = id;
		this.name = name;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getContact() {
		return contact;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("┌────┬────────────────────┬──────────────┐\n");
	    sb.append(String.format("│ %-2s │ %-18s │ %-12s │%n", "ID", "Name", "Contact"));
	    sb.append("├────┼────────────────────┼──────────────┤\n");
	    sb.append(String.format("│ %-2d │ %-18s │ %-12s │%n", id, name, contact));
	    sb.append("└────┴────────────────────┴──────────────┘");
	    return sb.toString();
	}
}