package com.aurionpro.model;

public class CounterDemo implements Runnable {
	public static int count = 0;

	public synchronized void countProtection() {
		count++;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 1000; i++) {
			countProtection();
		}
	}
}