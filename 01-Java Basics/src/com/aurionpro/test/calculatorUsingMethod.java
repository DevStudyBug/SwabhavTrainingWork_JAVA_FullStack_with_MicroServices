package com.aurionpro.test;

import java.util.Scanner;

public class calculatorUsingMethod {
	public static int addition(int num1, int num2) {
		int addition = num1 + num2;
		return addition;
//	return num1+num2;
	}

	public static int subtraction(int num1, int num2) {
		return num1 - num2;
	}

	public static int multi(int num1, int num2) {
		return num1 * num2;
	}

	public static int division(int num1, int num2) {
		if (num2 == 0) {
			System.out.println("second number can not be zero !");
		}  
			return num1 / num2;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number : ");
		int num1 = sc.nextInt();
		System.out.println("Enter the second number : ");
		int num2 = sc.nextInt();
		System.out.println("additon is " + addition(num1, num2));
		System.out.println("subtraction is " + subtraction(num1, num2));
		System.out.println("multiplication is " + multi(num1, num2));
		System.out.println("division is " + division(num1, num2));
		sc.close();
	}
}
