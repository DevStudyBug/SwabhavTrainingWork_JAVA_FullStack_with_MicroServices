package com.aurionpro.model;

public interface IVehicle {
	void start();
	void stop();
	String fuelType();
	
}

//Problem Statement:
//Create an interface Vehicle with methods:
//start()
//stop()
//fuelType()
//Implement this interface in Car and Bike classes with specific functionalities.
//
//Car should return "Diesel" or "petrol" as the fuel type.
//Bike should return "Petrol".
//In the main class, create an array of Vehicle references and store objects of Car and Bike to demonstrate runtime polymorphism.