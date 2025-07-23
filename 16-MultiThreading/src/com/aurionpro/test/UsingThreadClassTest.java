package com.aurionpro.test;

import com.aurionpro.model.MyThreadUsingThreadCLass;

public class UsingThreadClassTest {
public static void main(String[] args) {
	MyThreadUsingThreadCLass thread1 = new MyThreadUsingThreadCLass();
	thread1.run();
	thread1.run();

	thread1.start();
}
}
