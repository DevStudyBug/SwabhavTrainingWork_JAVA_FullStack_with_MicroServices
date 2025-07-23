package com.aurionpro.ECommerce.model;

public class CreditCard implements IPaymentGateway {
    
    private final double LIMIT = 50000;   // Credit card limit 
    private double lastCashback = 0;      

    public boolean pay(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return false;
        }

        if (amount > LIMIT) {
            System.out.println("Credit card limit exceeded! Max: ₹" + LIMIT);
            return false;
        }

        lastCashback = amount * 0.10;  
        System.out.println("Paid ₹" + amount + " using Credit Card.");
        System.out.println("Yay! You received ₹" + lastCashback + " cashback.");
        return true;
    }

    public void refund(double amount) {
        double adjustedRefund = amount - lastCashback;
        if (adjustedRefund < 0) adjustedRefund = 0;
        
        System.out.println("Refunded ₹" + adjustedRefund + " to Credit Card (₹" + lastCashback + " cashback revoked).");
        
        lastCashback = 0;  
    }
}
