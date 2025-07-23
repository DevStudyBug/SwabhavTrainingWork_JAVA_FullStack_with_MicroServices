package com.aurionpro.miniproject.model;

public enum TicketType {
	REGULAR(500), 
	VIP(1000), 
	PREMIUM(2000) ;
	
	private final int price;
	
	TicketType(int price){
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
}
