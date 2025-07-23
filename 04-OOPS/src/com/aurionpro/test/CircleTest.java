package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Circle;

/*Circle Area Calculator:
Create a class Circle with a field: radius.
Use a constructor to initialize the radius.
Create a method calculateArea() to return the area of the circle.
Create an object using user-defined radius and print the area.*/

public class CircleTest {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the radius of circle: ");
	float radius = scanner.nextFloat();
//	Circle circle1 = new Circle();
	Circle circle = new Circle(radius);
	System.out.println("the area of cirlce is " + circle.calculateArea());
	
	
}


}
