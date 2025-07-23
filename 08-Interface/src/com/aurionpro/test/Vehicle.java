package com.aurionpro.test;

import java.util.Scanner;
import com.aurionpro.model.IVehicle;
import com.aurionpro.model.Car;
import com.aurionpro.model.Bike;

public class Vehicle{

    public static void main(String[] args) {
        
        IVehicle[] vehicles = new IVehicle[2]; // Array to store Car and Bike objects

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter fuel type for Car (Petrol/Diesel): ");
        String fuel = scanner.next();

        vehicles[0] = new Car(fuel);  // Store Car object
        vehicles[1] = new Bike();     // Store Bike object

        System.out.println("\n--- Vehicle Details ---");

        // Loop for runtime polymorphism demonstration
        for (IVehicle vehicle : vehicles) {
            vehicle.start();
            System.out.println("Fuel Type: " + vehicle.fuelType());
            vehicle.stop();
            System.out.println("----------------------");
        }

        scanner.close();
    }
}
