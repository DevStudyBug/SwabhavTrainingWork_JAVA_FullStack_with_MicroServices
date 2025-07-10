package com.aurionpro.ECommerce.model;

public class UPI implements IPaymentGateway {

    private double lastCashback = 0;  // Stores last cashback value

    public boolean pay(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return false;
        }

        lastCashback = (amount >= 500 && amount <= 1000) ? 50 : 100;

        System.out.println("Paid ₹" + amount + " using UPI.");
        System.out.println("Yay! You received ₹" + lastCashback + " cashback.");
        return true;
    }

    public void refund(double amount) {
        double adjustedRefund = amount - lastCashback;
        if (adjustedRefund < 0) adjustedRefund = 0;

        System.out.println("Refunded ₹" + adjustedRefund + " to UPI (₹" + lastCashback + " cashback revoked).");

        lastCashback = 0;  
    }
}
