package com.aurionpro.statics.model;

public class ElectricityBillApplication {

	private int apartmentNumber;
	private int unitsConsumed;
	private static int costPerUnit = 10;
	
	public  ElectricityBillApplication(int apartmentNumber, int unitsConsumed) {
        this.apartmentNumber = apartmentNumber;
        this.unitsConsumed = unitsConsumed;
        
    }
	
	public int calculateBillAmount() {
        return unitsConsumed * costPerUnit;
    }
	
	
	public static void changeCostPerUnit(int newRate) {
        costPerUnit = newRate;
        System.out.println("change cost per unit: "+newRate);
    }
	public static void displayCurrentRate() {
        System.out.println("Current Cost per Unit: " + costPerUnit);
    }
	
	public void displayBill() {
        System.out.println("Apartment Number: " + apartmentNumber);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Total Bill Amount: " + calculateBillAmount());
//        System.out.println("Change cost per unit: " + changeCostPerUnit());
    }
}
/*
 * Design a simple electricity billing application for a residential apartment
 * complex. Each apartment has its own meter reading and generates a bill based
 * on the number of units consumed. The cost per unit is fixed across all
 * apartments.
 * 
 * The class should provide:
 * 
 * ElectricityBill
 * 
 * - apartmentNumber; - unitsConsumed; - static costPerUnit;
 * 
 * A method to calculate the bill amount
 * 
 * A static method to change the cost per unit (e.g., if government revises it)
 * 
 * A static method to display the current rate
 * 
 * An instance method to display the individual bill
 */