package com.aurionpro.OrderProcessingSystem.model;

public class UPIPayment implements PaymentStrategy{

	@Override
	public void pay(double amount) {
		System.out.println("Paid Rs. :"+amount+" Using UPI. ");
		
	}
}
