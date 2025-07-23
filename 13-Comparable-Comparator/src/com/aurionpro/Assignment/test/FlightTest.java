package com.aurionpro.Assignment.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.aurionpro.Flight.model.Flight;
import com.aurionpro.Flight.model.SortByFare;

public class FlightTest {
public static void main(String[] args) {
	Scanner scanner = new Scanner (System.in);
	ArrayList <Flight> list = new ArrayList<>();
	
	System.out.println("------Flight Details-----");
	while(true) {
		try {
			System.out.println("Enter Airline name: ");
			String airline = scanner.nextLine();
			
			if(airline.isEmpty() || !airline.matches("[a-zA-Z]+")) {
				throw new IllegalArgumentException("Airline name must contain only alphabets and space.");
			}
			double fare;
			while(true) {
				try {
                    System.out.print("Enter Fare: ");
                    fare = Double.parseDouble(scanner.nextLine().trim());

                    if (fare <= 0) {
                        throw new IllegalArgumentException("Fare must be greater than 0.");
                    }
                    break;
				}catch(NumberFormatException e) {
						System.out.println("Invalid input, fare must have numeric value!!");
					}
					catch(IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
					
				}
				list.add(new Flight(airline, fare));
				
				String choice;
                while (true) {
                    System.out.print("Add another flight? (yes/no): ");
                    choice = scanner.nextLine().toLowerCase();
                    if (choice.equals("yes") || choice.equals("no")) {
                        break;
                    }
                    System.out.println("Please enter 'yes' or 'no' only.");
                }
                if (choice.equals("no")) {
                    break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
	if (list.isEmpty()) {
        System.out.println("No flights to sort.");
        scanner.close();
        return;
    }

    Collections.sort(list, new SortByFare());

    System.out.println("\n---- Flights Sorted by Fare (Descending) ----\n");

    System.out.printf("%-20s %-10s\n", "Airline", "Fare");
    System.out.println("------------------------------------------");
    for (Flight f : list) {
        System.out.println(f);
    }
    scanner.close();
}
}
	