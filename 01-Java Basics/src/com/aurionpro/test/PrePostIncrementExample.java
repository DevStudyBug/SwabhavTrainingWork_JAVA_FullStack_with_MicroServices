package com.aurionpro.test;

public class PrePostIncrementExample {
	public static void main(String [] args ) {
		int a = 10;
		int b = --a;
		int x=10;
		System.out.println(++x + x++);
		int y =5;
		System.out.println(y++ + ++y);
		int z= 3;
		System.out.println(z-- - --z);
		System.out.println(a);
		System.out.println(b);
	}
}
