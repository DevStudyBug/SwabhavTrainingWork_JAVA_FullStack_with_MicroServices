package com.aurionpro.project.model;

public class Vehicle {
	String brand, model;
	int speed;

	public Vehicle(String brand, String model, int speed) {
		this.brand = brand;
		this.model = model;
		this.speed = speed;
	}

	public void accelerate() {
		speed += 10;
		System.out.println("Brand: "+ brand+" Model: "+ model+"Accelerated speed: " + speed);
	}

	public void brake() {
		speed = 0;
		System.out.println("Brand: "+ brand+" Model: "+ model+  "brake: " + speed);
	}
	public void displayInfo() {
		System.out.println("Brand: "+ brand+" Model: "+ model+ " Speed: "+ speed );
	}
}

//1. Develop a vehicle management system using multilevel inheritance:
//
//The Vehicle class contains common properties like brand, model, and speed.
//The Car class extends Vehicle and adds attributes like fuelType and numSeats.
//The ElectricCar class extends Car and includes properties like batteryCapacity and chargingTime.
//Tasks:
//Implement constructors and appropriate methods (e.g., accelerate(), brake(), displayInfo()).
//Creating objects and call methods for different vehicle types.
