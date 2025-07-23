package com.project1.model;

public abstract class Customer {
	public String name ;
	public int unitsConsumed ;
	
	public Customer (String name , int unitConsumed) {
		this.name = name;
		this.unitsConsumed = unitConsumed;
	}
	public abstract void calculateBill();
}

//Q2. Electricity Billing System
//Create an abstract class Customer with fields name, unitsConsumed, and an abstract method
//calculateBill().
//Subclasses:
// ResidentialCustomer: ₹5/unit
// CommercialCustomer: ₹8/unit
//Use a fixed-size array (e.g., size 3), store objects, and calculate their bills.