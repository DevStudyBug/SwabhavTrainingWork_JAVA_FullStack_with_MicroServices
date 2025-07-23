package com.aurionpro.model;

public class PassByValueExample  {
	    public static void changeValue(int x) {
	        x = 100 / x;
	        System.out.println("x: " + x);
	    }

	    public static void main(String[] args) {
	        int a = 50;
	        changeValue(a);
	        System.out.println("Value of a: " + a);
	    }
	}

