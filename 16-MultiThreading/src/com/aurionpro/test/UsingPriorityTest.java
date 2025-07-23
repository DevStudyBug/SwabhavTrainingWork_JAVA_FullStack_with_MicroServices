package com.aurionpro.test;

import com.aurionpro.model.UsingPriority;

public class UsingPriorityTest {

	 public static void main(String[] args) {
	        UsingPriority t1 = new UsingPriority();
	        t1.setPriority(Thread.MAX_PRIORITY);
	        t1.setName("Max");
	        t1.start();

	        UsingPriority t2 = new UsingPriority();
	        t2.setPriority(Thread.MIN_PRIORITY);
	        t2.setName("Min");
	        t2.start();

	        UsingPriority t3 = new UsingPriority();
	        t3.setPriority(Thread.NORM_PRIORITY);
	        t3.setName("Normal");
	        t3.start();
	    }
	}
