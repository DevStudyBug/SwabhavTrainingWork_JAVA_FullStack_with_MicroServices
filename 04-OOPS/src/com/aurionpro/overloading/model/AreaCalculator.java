package com.aurionpro.overloading.model;
/*🔹 2. Area Calculator
Create a class AreaCalculator:
 area(int side) – returns area of square
 area(int length, int breadth) – returns area of rectangle
 area(double radius) – returns area of circle*/

public class AreaCalculator {
	int side, length , breath ;
	double radius;
	
public int area(int side) {
	return side*side ;
}

public int area(int length, int breadth) {
	int rectangle = length * breadth;
	return rectangle;
}

public double area(double radius) {
	double circle = 3.14*radius *radius;
	return circle;
}

}
