package com.aurionpro.test;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.aurionpro.model.IVehicleControl;
import com.aurionpro.model.Vcar;
import com.aurionpro.model.Vbike;
import com.aurionpro.model.Vtruck;

public class TransportationVehicleSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        IVehicleControl vehicle = null;
        int choice = -1;

        System.out.println("----- Welcome to Transportation Vehicle System -----");

        do {
            try {
                System.out.println("\nSelect Vehicle:");
                System.out.println("1. Car");
                System.out.println("2. Bike");
                System.out.println("3. Truck");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            vehicle = new Vcar();
                            operateVehicle(vehicle, "Car", 5);
                            break;

                        case 2:
                            vehicle = new Vbike();
                            operateVehicle(vehicle, "Bike", 4);
                            break;

                        case 3:
                            vehicle = new Vtruck();
                            operateVehicle(vehicle, "Truck", 8);
                            break;

                        case 4:
                            System.out.println("Exiting System. Thank you!");
                            break;

                        default:
                            System.out.println("Invalid choice! Please enter between 1 and 4.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.next();  
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid numeric input.");
                sc.next(); 
            }
        } while (choice != 4);

        sc.close();
    }

    public static void operateVehicle(IVehicleControl vehicle, String vehicleName, int maxGear) {
        boolean isStarted = false;
        boolean isRunning = true;

        while (isRunning) {
            try {
                System.out.println("\n" + vehicleName + " Control Menu:");
                System.out.println("1. Start Vehicle");
                System.out.println("2. Change Gear");
                System.out.println("3. Stop Vehicle");
                System.out.println("4. Back to Main Menu");
                System.out.print("Enter your choice: ");
                
                if (sc.hasNextInt()) {
                    int option = sc.nextInt();

                    switch (option) {
                        case 1:
                            if (isStarted) {
                                throw new IllegalStateException(vehicleName + " is already started.");
                            }
                            vehicle.start();
                            isStarted = true;
                            break;

                        case 2:
                            if (!isStarted) {
                                throw new IllegalStateException("Start the " + vehicleName + " before changing gears.");
                            }
                            System.out.print("Enter gear to change (1 to " + maxGear + "): ");
                            if (sc.hasNextInt()) {
                                int gear = sc.nextInt();
                                if (gear < 1 || gear > maxGear) {
                                    throw new IllegalArgumentException("Invalid gear! Allowed gears: 1 to " + maxGear);
                                }
                                vehicle.changeGear(gear);
                            } else {
                                System.out.println("Invalid input! Please enter a valid gear number.");
                                sc.next(); // clear invalid input
                            }
                            break;

                        case 3:
                            if (!isStarted) {
                                throw new IllegalStateException(vehicleName + " is already stopped.");
                            }
                            vehicle.stop();
                            isStarted = false;
                            break;

                        case 4:
                            if (isStarted) {
                                throw new IllegalStateException("Stop the " + vehicleName + " before exiting to main menu.");
                            }
                            System.out.println("Returning to Main Menu...");
                            isRunning = false;
                            break;

                        default:
                            System.out.println("Invalid option! Choose between 1 and 4.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.next(); 
                }

            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
