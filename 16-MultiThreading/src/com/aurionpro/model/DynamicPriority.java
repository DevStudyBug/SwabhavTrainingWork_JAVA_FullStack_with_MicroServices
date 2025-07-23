package com.aurionpro.model;


	 public class DynamicPriority extends Thread{
	 public DynamicPriority(String name, int priority) {
	        setName(name);
	        setPriority(priority);
	    }

	    public void run() {
	        System.out.println(getName() + " started with priority: " + getPriority());
	    }
}
