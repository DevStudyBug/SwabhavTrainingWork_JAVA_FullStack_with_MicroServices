package com.aurionpro.model;

public class DynamicPriorityWithSleep extends Thread {
	 public DynamicPriorityWithSleep(String name, int priority) {
	        setName(name);
	        setPriority(priority);
	    }

	    public void run() {
	        for(int i=1; i<=5; i++) {
	            System.out.println(getName() + ": " + i);
	            try {
	                Thread.sleep(1000); 
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
