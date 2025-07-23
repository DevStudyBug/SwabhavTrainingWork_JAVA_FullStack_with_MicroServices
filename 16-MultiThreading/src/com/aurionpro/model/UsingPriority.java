package com.aurionpro.model;

public class UsingPriority extends Thread{

	 public void run() {
	        System.out.println(getName() + " priority: " + getPriority());
	    }

	
}