package com.aurionpro.statics.test;

import com.aurionpro.statics.model.Car;

public class CarTest {
	 public static void main(String[] args) {
	        Car.count = 10;
	        Car car1 = new Car();
	        Car car2 = new Car();
	        Car car3 = new Car();
	        Car car4 = new Car();

	        System.out.println("Total cars: " + Car.count);
	    }
}
