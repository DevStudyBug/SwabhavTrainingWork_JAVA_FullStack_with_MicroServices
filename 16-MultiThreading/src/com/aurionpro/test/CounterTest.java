package com.aurionpro.test;

import com.aurionpro.model.CounterDemo;

public class CounterTest {

	public static void main(String[] args) throws InterruptedException {
		CounterDemo counter = new CounterDemo();

		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(counter);

		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.println("Final Count is: " + counter.count);
	}
}
