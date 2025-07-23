package com.aurionpro.model;

public class DebitCardPayment implements IPayment {
@Override
public void processPayment(double amount) {
	System.out.println("the Debitcard payment of $"+ amount);
}
}
