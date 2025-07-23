package com.aurionpro.model;
/*Circle Area Calculator:
Create a class Circle with a field: radius.
Use a constructor to initialize the radius.
Create a method calculateArea() to return the area of the circle.
Create an object using user-defined radius and print the area.*/

public class Circle {
	float radius;

//	public Circle() {
//		System.out.println("Circle Area calculator");
//	}

	public Circle(float radius) {
		this.radius = radius;

	}

	public double calculateArea() {
		double area = 3.14 * radius * radius;
		return area;
	}
}
