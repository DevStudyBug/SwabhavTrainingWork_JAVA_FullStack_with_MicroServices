package com.project1.model;

public class ResidentialCustomer extends Customer {
	public final int charge = 5;

	public ResidentialCustomer(String name, int unitsConsumed) {
		super(name, unitsConsumed);
	}
	@Override
	public void calculateBill() {
		unitsConsumed = unitsConsumed * charge;
		System.out.println("name: " + name + ",  Electricity Bill charge $: " + unitsConsumed);
	}
}

//Q2. Electricity Billing System
//Create an abstract class Customer with fields name, unitsConsumed, and an abstract method
//calculateBill().
//Subclasses:
// ResidentialCustomer: ₹5/unit
// CommercialCustomer: ₹8/unit
//Use a fixed-size array (e.g., size 3), store objects, and calculate their bills.