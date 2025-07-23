package com.aurionpro.model;

public interface IPayment {
    void processPayment(double amount);
}

//Problem Statement:
//Design an interface Payment with a method processPayment(double amount).
//Implement this interface in classes CreditCardPayment, DebitCardPayment, and UPIPayment.
//Each class should provide its own implementation of processPayment().
//Demonstrate the working of the system using a main method where a user can choose a payment method dynamically.
