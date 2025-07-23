package com.aurionpro.model;

public class Car implements IVehicle {

	String fuel;

    public Car(String fuel) {
//        if (fuel.equalsIgnoreCase("Petrol") || fuel.equalsIgnoreCase("Diesel")) {
            this.fuel = fuel;
//            return;
//        }
//        this.fuel = "Petrol"; 
    }

    @Override
    public void start() {
        System.out.println("Car started.");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }

    @Override
    public String fuelType() {
        return fuel;
    }
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