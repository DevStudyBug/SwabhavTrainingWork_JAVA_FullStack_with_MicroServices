package com.aurionpro.Supplier.test;
import java.util.function.Supplier;
public class RandomNumber {
	public static void main(String[] args) {
		Supplier<Double> random = ()-> Math.random();
		for(int i=0; i<5;i++) {
			System.out.println("Random number "+i+": "+ random.get());
		}
	}
}
//1. Random Number Generator
//Use a Supplier<Double> to generate and print 5 random numbers between 0 and 1.