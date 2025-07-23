package com.aurionpro.overloading.test;

import com.aurionpro.overloading.model.SafeCalculator;

//🔹 8. Calculator with Input Validation
//Create a class SafeCalculator:
// Overload divide(int a, int b) and divide(double a, double b)
// If divisor is 0, return -1 or show "invalid"
public class SafeCalculatorTest {
public static void main(String[] args) {
	int a = 2;
	int b=0;
	SafeCalculator calculator = new SafeCalculator();
	
	System.out.println("-----Safe Calculator-------");
	System.out.println("value: "+ calculator.divide(a, b));
	System.out.println("value: "+calculator.divide(2.1, 1));
}
}
