package com.aurionpro.overloading.test;

import com.aurionpro.overloading.model.AreaCalculator;

/*🔹 2. Area Calculator
Create a class AreaCalculator:
 area(int side) – returns area of square
 area(int length, int breadth) – returns area of rectangle
 area(double radius) – returns area of circle*/
public class AreaCalculatorTest {
	public static void main(String[] args) {
		int side = 5;
		int length = 10;
		int breadth = 20;
		double radius = 2;
		AreaCalculator areaCal = new AreaCalculator();
	
		System.out.println("squar area "+areaCal.area(side));
		System.out.println("ractangle area "+areaCal.area(3,4));
		System.out.println("circle area "+areaCal.area(radius));
	}
}
