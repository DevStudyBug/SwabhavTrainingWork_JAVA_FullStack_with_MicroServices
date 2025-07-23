package com.aurionpro.enumeration.model;

public class ECommercePaymentStatusTracker {
	public static void printMessage(PaymentStatus status) {
		switch (status) {
		case SUCCESS:
			System.out.println("Payment received !");
			break;
		case PENDING:
			System.out.println("Payment is pending !");
			break;
		case FAILED:
			System.out.println("Payment was failed !");
			break;
		case CANCELLED:
			System.out.println("Payment cancelled !");
			break;
		default : 
			System.out.println("Invalid status!!");
		}
		
	}
	public static void main(String[] args) {
		System.out.println("\n--------E-Commerce Payment Status Tracker----------\n"); 
		// invoke printMessage() method , And pass different values from the PaymentStatus enum.
		printMessage(PaymentStatus.SUCCESS);
        printMessage(PaymentStatus.PENDING);
        printMessage(PaymentStatus.FAILED);
        printMessage(PaymentStatus.CANCELLED);
	}
}





//3. E-Commerce Payment Status Tracker
//Task:
//Create an enum PaymentStatus { SUCCESS, PENDING, FAILED, CANCELLED }.
//Write a method printMessage(PaymentStatus status) that prints custom messages for
//each status:
// SUCCESS → "Payment received"
// FAILED → "Payment failed"
// etc.
//Call the method from main() with different status values. 