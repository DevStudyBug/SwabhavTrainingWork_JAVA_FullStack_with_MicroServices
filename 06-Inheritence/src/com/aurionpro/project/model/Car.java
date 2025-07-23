package com.aurionpro.project.model;

public class Car extends Vehicle {
	String fuelType;
	int numSeats;
	
	public Car(String brand, String model, int speed,String fuelType ,int numSeats) {
		super(brand,model,speed);
		this.fuelType = fuelType;
		this.numSeats = numSeats;	
	}
	
	@Override
	public void displayInfo() {
		System.out.println("Brand: "+ brand+", Model: "+ model+ ", Speed: "+ speed +", Fuel Type: " +fuelType +", Number of seats: "+numSeats);
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
