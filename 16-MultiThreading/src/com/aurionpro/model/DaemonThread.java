package com.aurionpro.model;

public class DaemonThread extends Thread
	
{
//	  	String name;
	    public DaemonThread(String name) {
//	        this.name = name;
	        super(name);
	    }

	    public void run()
	    {
	        
	        if(isDaemon()) {
	            System.out.println(getName() + " is Daemon thread");
	        }
	        else {
	            System.out.println(getName() + " is User thread");
	        }
	    }
	}
