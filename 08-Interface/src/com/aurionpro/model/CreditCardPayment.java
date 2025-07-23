package com.aurionpro.model;

public class CreditCardPayment implements IPayment {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
