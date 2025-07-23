package com.aurionpro.overloading.test;

import java.util.Scanner;

import com.aurionpro.overloading.model.TravelCost;

public class TravelCostTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    TravelCost travel = new TravelCost();
	    
	    System.out.println("Enter distance in km:");
	    int distance = scanner.nextInt();

	    System.out.println("\nEstimate for 1 passenger (Non-AC):");
	    travel.estimate(distance);

	    System.out.println("\nEnter number of passengers:");
	    int passengers = scanner.nextInt();
	    travel.estimate(distance, passengers);

	    System.out.println("\nIs AC required? (true/false):");
	    boolean ac = scanner.nextBoolean();
	    travel.estimate(distance, passengers, ac);
	    scanner.close();
	}
	
}
