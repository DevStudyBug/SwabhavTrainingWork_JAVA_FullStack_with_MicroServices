package com.aurionpro.OrderProcessingSystem.test;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.OrderProcessingSystem.model.DiscountStrategy;
import com.aurionpro.OrderProcessingSystem.model.Notifier;
import com.aurionpro.OrderProcessingSystem.model.PaymentStrategy;
import com.aurionpro.OrderProcessingSystem.model.Product;

public class Order {

	private List<Product> products = new ArrayList<Product>();
	private DiscountStrategy discountStrategy;
	private PaymentStrategy paymentStrategy;
	private List<Notifier> notifiers;

	public Order(DiscountStrategy discountStrategy, PaymentStrategy paymentStrategy, List<Notifier> notifiers) {
		this.discountStrategy = discountStrategy;
		this.paymentStrategy = paymentStrategy;
		this.notifiers = notifiers;
	}

	public void addProducts(Product product) {
		products.add(product);
	}

	public void processOrder() {
		double total = 0;
		for (Product p : products) {
			total += p.getPrice();
		}

		double discountedTotal = discountStrategy.applyDiscount(total);
		paymentStrategy.pay(discountedTotal);

		for (Notifier notifier : notifiers) {
			notifier.send("Order placed successfully. Total: ₹" + discountedTotal);
		}
	}

}

