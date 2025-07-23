package com.aurionpro.model;

public class MyThreadUsingRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("Thread runing is: "+ Thread.currentThread().getName());
	}
}
