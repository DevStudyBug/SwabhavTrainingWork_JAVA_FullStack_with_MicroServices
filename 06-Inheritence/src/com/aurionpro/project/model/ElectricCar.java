package com.aurionpro.project.model;

public class ElectricCar extends Car {
	int batteryCapacity, chargingTime;
	
	public ElectricCar(String brand, String model, int speed, String fuelType ,int numSeats, int batteryCapacity, int chargingTime) {
		super(brand,model,speed,fuelType,batteryCapacity);
		this.fuelType = fuelType;
		this.batteryCapacity = batteryCapacity;
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Fuel Type: "+ fuelType+ ", Battery Capacity: "+batteryCapacity);
	}
	
}
