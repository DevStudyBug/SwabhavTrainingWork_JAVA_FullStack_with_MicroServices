package com.aurionpro.model;

public interface IVehicleControl {
	void start();
	void stop();
	void changeGear(int gear);	
}

//
//3. Transportation/Vehicle System
//Problem:
//Create an interface VehicleControl with methods: start(), stop(), and changeGear(int
//gear).
//Implement Car, Bike, and Truck classes, each with custom implementations.
//Add a test class that controls different vehicles using interface references and loops.