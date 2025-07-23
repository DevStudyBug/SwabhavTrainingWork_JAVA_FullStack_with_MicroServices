package com.aurionpro.miniproject.test;

import java.util.Scanner;
import com.aurionpro.miniproject.model.Fan;
import com.aurionpro.miniproject.model.IControllable;
import com.aurionpro.miniproject.model.Light;
import com.aurionpro.miniproject.model.Speaker;
import com.aurionpro.miniproject.model.TV;

public class SmartHomeDevice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IControllable device;
        int choice;

        do {
            System.out.println("\n--- Smart Home Device Controller ---");
            System.out.println("1. Light");
            System.out.println("2. Fan");
            System.out.println("3. TV");
            System.out.println("4. Speaker");
            System.out.println("5. Exit");
            System.out.print("Choose a device: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: device = new Light(); break;
                case 2: device = new Fan(); break;
                case 3: device = new TV(); break;
                case 4: device = new Speaker(); break;
                case 5:
                    System.out.println("Exiting Smart Home Controller. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select between 1-5.");
                    continue;
            }

            System.out.print("Do you want to turn ON the device? (yes/no): ");
            String powerChoice = scanner.next().toLowerCase();

            if (powerChoice.equals("yes")) {
                device.turnOn();

                String[] modes = device.getAvailableModes();
                int modeChoice;

                // Mode selection loop
                while (true) {
                    System.out.println("\nAvailable Modes:");
                    for (int i = 0; i < modes.length; i++) {
                        System.out.println((i + 1) + ". " + modes[i]);
                    }

                    System.out.print("Choose a mode: ");
                    modeChoice = scanner.nextInt();

                    if (modeChoice >= 1 && modeChoice <= modes.length) {
                        device.setMode(modes[modeChoice - 1]);
                        break;
                    } else {
                        System.out.println("Invalid mode. Please try again.");
                    }
                }

                System.out.print("Do you want to turn OFF the device? (yes/no): ");
                String offChoice = scanner.next().toLowerCase();
                if (offChoice.equals("yes")) {
                    device.turnOff();
                } else {
                    System.out.println("Device remains ON.");
                }
            } else {
                System.out.println("Device was not turned ON.");
            }
        } while (true);
    }
}


/*
 * Mini Project Title: "Smart Home Device Controller" 📄 Problem Definition: In
 * a smart home setup, different types of electronic devices (like TVs, Lights,
 * Fans, and Speakers) respond to common actions such as turning on, turning
 * off, and adjusting settings. However, each device responds differently to
 * these actions. Create a Java-based system that simulates a unified interface
 * for controlling various smart devices, ensuring loose coupling and
 * polymorphism through the use of interfaces only. 🎯 Objective: To design a
 * system where all smart devices follow a common interface (Controllable) but
 * implement their own behaviour for turnOn(), turnOff(), and setMode().
 * Requirements:
 * 
 * 1. Define an Interface: Controllable interface Controllable { void turnOn();
 * void turnOff(); void setMode(String mode); }
 * 
 * 2. Implementing Classes (Devices):  Light  Fan  TV  Speaker Each class
 * must:  Implement Controllable  Customize setMode() method for its own
 * setting (e.g., Light: "Dim", Fan: "High", TV: "HD", Speaker: "Bass") 3. Main
 * Controller Class (Simulation)  Create an array of Controllable devices. 
 * Use a loop to turn all devices on, set mode, and turn off.  Show how
 * interface references enable flexibility and polymorphism. 🧪 Sample Output:
 * Light turned ON Light mode set to: Dim Light turned OFF Fan turned ON Fan
 * mode set to: High Fan turned OFF TV turned ON TV mode set to: HD TV turned
 * OFF Speaker turned ON Speaker mode set to: Bass Speaker turned OFF
 */
