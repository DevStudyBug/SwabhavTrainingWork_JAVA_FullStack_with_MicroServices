package com.aurionpro.OrderProcessingSystem.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.OrderProcessingSystem.model.CreditCardPayment;
import com.aurionpro.OrderProcessingSystem.model.DiscountStrategy;
import com.aurionpro.OrderProcessingSystem.model.EmailConformation;
import com.aurionpro.OrderProcessingSystem.model.FestivalDiscount;
import com.aurionpro.OrderProcessingSystem.model.NoDiscount;
import com.aurionpro.OrderProcessingSystem.model.Notifier;
import com.aurionpro.OrderProcessingSystem.model.PaymentStrategy;
import com.aurionpro.OrderProcessingSystem.model.Product;
import com.aurionpro.OrderProcessingSystem.model.SMSConformation;
import com.aurionpro.OrderProcessingSystem.model.UPIPayment;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter number of products to add: ");
			int count = Integer.parseInt(sc.nextLine());

			List<Product> products = new ArrayList<>();

			for (int i = 1; i <= count; i++) {
				System.out.print("Enter name of product " + i + ": ");
				String name = sc.nextLine();

				System.out.print("Enter price of " + name + ": ");
				double price = Double.parseDouble(sc.nextLine());

				if (price < 0)
					throw new IllegalArgumentException("Price cannot be negative.");

				products.add(new Product(name, price));
			}

			// Select Discount
			System.out.println("\nChoose Discount Type:\n1. No Discount\n2. Festival Discount");
			int discountChoice = Integer.parseInt(sc.nextLine());
			DiscountStrategy discount = (discountChoice == 2) ? new FestivalDiscount() : new NoDiscount();

			// Select Payment
			System.out.println("\nChoose Payment Method:\n1. UPI\n2. Credit Card");
			int paymentChoice = Integer.parseInt(sc.nextLine());
			PaymentStrategy payment = (paymentChoice == 2) ? new CreditCardPayment() : new UPIPayment();

			// Notifiers
			List<Notifier> notifiers = new ArrayList<>();
			notifiers.add(new EmailConformation());
			notifiers.add(new SMSConformation());

			Order order = new Order(discount, payment, notifiers);
			for (Product p : products) {
				order.addProducts(p);
			}

			System.out.println("\nProcessing your order...");
			order.processOrder();

		} catch (NumberFormatException e) {
			System.out.println("Invalid number format. Please enter valid numeric input.");
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		} finally {
			sc.close();
		}
	}
}
