package com.aurionpro.enumeration.model;
//3. E-Commerce Payment Status Tracker
//Task:
//Create an enum PaymentStatus { SUCCESS, PENDING, FAILED, CANCELLED }.
//Write a method printMessage(PaymentStatus status) that prints custom messages for
//each status:
// SUCCESS → "Payment received"
// FAILED → "Payment failed"
// etc.
//Call the method from main() with different status values.

public enum PaymentStatus {
	SUCCESS, PENDING, FAILED, CANCELLED;
}
