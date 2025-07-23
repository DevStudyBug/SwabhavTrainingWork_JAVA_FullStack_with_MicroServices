package com.aurionpro.ECommerce.model;

public interface IPaymentGateway {
	boolean pay(double amaount);
	void refund(double amount);

}
//
//2. E-commerce Domain
//Problem:
//Define an interface PaymentGateway with methods: pay(double amount) and
//refund(double amount).
//Implement classes CreditCard, UPI, and NetBanking that simulate payment processing
//differently.
//Create a Checkout class that uses a PaymentGateway reference to complete transactions
//dynamically.
