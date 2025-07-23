package com.aurionpro.test;

public class MethodWithParameter {
	public static void add(int a, int b) {
		int sum = a+b;
		System.out.println("sum of two number is : "+ sum);
	}
	public static void main(String[] args) {
		add(4,6);
	}
}
