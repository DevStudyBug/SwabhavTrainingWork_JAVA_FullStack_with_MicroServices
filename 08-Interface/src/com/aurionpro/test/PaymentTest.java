package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.CreditCardPayment;
import com.aurionpro.model.DebitCardPayment;
import com.aurionpro.model.UPIPayment;
import com.aurionpro.model.IPayment;
public class PaymentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Select Payment Method:");
		System.out.println("1. Credit Card");
		System.out.println("2. Debit Card");
		System.out.println("3. UPI");

		int choice = scanner.nextInt();System.out.print("Enter payment amount: ");
		double amount = scanner.nextDouble();

		IPayment payment = null;

		switch(choice)
		{
	        case 1:
	            payment = new CreditCardPayment();
	            break;
	        case 2:
	            payment = new DebitCardPayment();
	            break;
	        case 3:
	            payment = new UPIPayment();
	            break;
	        default:
	            System.out.println("Invalid choice. Payment cancelled.");
	            System.exit(0);
	    }

		payment.processPayment(amount);
		scanner.close();
	}
	}
	
