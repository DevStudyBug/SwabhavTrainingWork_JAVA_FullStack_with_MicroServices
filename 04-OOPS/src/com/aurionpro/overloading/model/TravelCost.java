package com.aurionpro.overloading.model;
/*11. Travel Cost Estimator
Objective: Use method overloading to estimate trip cost under different input conditions.
🔹 Requirements:
 Create a class TravelCost with:
o estimate(int distance)
o estimate(int distance, int passengers)
o estimate(int distance, int passengers, boolean AC)
🧪 Logic:
 Base rate = ₹10/km
 Multiply by passengers if >1
 Add 20% extra if AC is true*/

public class TravelCost {
	int distance;
	int passengers;
	boolean AC ;
	int baserate =10, cost =0;
	public int estimate(int distance) {
		 int cost = distance * baserate;
	        System.out.println("Estimated Cost: ₹" + cost);
	        return cost;
		
	}
	public int estimate(int distance, int passengers) {
		int cost = distance * baserate * passengers;
        System.out.println("Estimated Cost for " + passengers + " passengers: ₹" + cost);
		return cost ;		
	}
	public int estimate(int distance, int passengers, boolean AC) {
		 int cost = distance * baserate * passengers;

	        if (AC) {
	            cost += cost * 0.2;  // 20% extra for AC
	        }

	        System.out.println("Estimated Cost with AC (" + AC + "): ₹" + cost);
	        return cost;
	        }
}
