package com.project1.model;

public class CommercialCustomer extends Customer {
	public final int charge = 8;

	public CommercialCustomer(String name, int unitsConsumed) {
		super(name, unitsConsumed);
	}

	@Override
	public void calculateBill() {
		unitsConsumed = unitsConsumed * charge;
		System.out.println("name: " + name + ", Electricity Bill charge $: " + unitsConsumed);
	}
}