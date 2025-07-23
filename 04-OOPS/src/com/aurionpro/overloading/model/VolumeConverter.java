package com.aurionpro.overloading.model;
//🔹 6. Volume Calculator
//Create a class VolumeCalculator:
// volume(int side) – cube
// volume(int length, int breadth, int height) – cuboid
// volume(double radius) – sphere

public class VolumeConverter {
int side,length , breadth ,height ;
double radius;
public int volume(int side) {
	int cube = side*side*side;
	return cube;
}
public int volume (int length, int breadth, int height) {
	int cuboid = length*breadth* height;
	return cuboid;
}

public double volume (double radius) {
	double sphere = 4/3*(3.14)*radius*radius*radius;
	return sphere;
}
}
