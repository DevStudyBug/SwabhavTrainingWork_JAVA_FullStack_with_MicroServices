package com.aurionpro.model;

public class MyThreadUsingThreadCLass extends Thread{
//	System.out.println("Thread runing is: "+ Thread.currentThread().getname());
	@Override  //optional to use in thread class
	public void run() {
		System.out.println("Thread runing is: "+ Thread.currentThread().getName());
	}
}
