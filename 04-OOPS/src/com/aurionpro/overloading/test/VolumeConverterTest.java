package com.aurionpro.overloading.test;
//🔹 6. Volume Calculator
//Create a class VolumeCalculator:
// volume(int side) – cube
// volume(int length, int breadth, int height) – cuboid
// volume(double radius) – sphere

import com.aurionpro.overloading.model.VolumeConverter;

public class VolumeConverterTest {
	public static void main(String[] args) {
		int side=2,l=3 , b=4 ,h=2 ;
		double radius =2;
		VolumeConverter volume = new VolumeConverter();
		System.out.println("Cube: "+volume.volume(side));
		System.out.println("Cuboid: "+volume.volume(l,b,h));
		System.out.println("sphere:  "+volume.volume(radius));
	}	
}
