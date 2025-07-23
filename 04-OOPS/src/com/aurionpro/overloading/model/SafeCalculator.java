package com.aurionpro.overloading.model;

//🔹 8. Calculator with Input Validation
//Create a class SafeCalculator:
// Overload divide(int a, int b) and divide(double a, double b)
// If divisor is 0, return -1 or show "invalid"
public class SafeCalculator {
	int number1;
	int number2;

	public double dividebyZero(double a, double b) {
		if (b == 0) {
			System.out.println("invalid!");
			return -1;
		} else {
			return a / b;
		}
	}

	public double divide(int a, int b) {
		return dividebyZero(a, b);
	}
	public double divide(double a, double b) {
		return dividebyZero(a, b);

	}

}
