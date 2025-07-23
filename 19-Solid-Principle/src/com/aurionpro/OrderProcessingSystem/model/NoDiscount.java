package com.aurionpro.OrderProcessingSystem.model;

public class NoDiscount implements DiscountStrategy {

	@Override
	public double applyDiscount(double amount) {
		return amount;
	}

}