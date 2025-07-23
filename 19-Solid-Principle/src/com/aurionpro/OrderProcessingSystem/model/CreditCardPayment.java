package com.aurionpro.OrderProcessingSystem.model;

public class CreditCardPayment implements PaymentStrategy {
	@Override
	public void pay(double amount) {
		System.out.println("Paid Rs. :" + amount + " Using Credit Card. ");

	}

}
