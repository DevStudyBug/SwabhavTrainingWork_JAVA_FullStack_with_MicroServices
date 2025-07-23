package com.aurionpro.Flight.model;

public class Flight {
	String airline;
	double fare;
	public Flight(String airline, double fare) {
		this.airline = airline;
		this.fare = fare;	
	}
	@Override
	public String toString() {
//		return "Flight [airline=" + airline + ", fare=" + fare + "]";
		 return String.format("%-20s %-10.2f", airline, fare);
	}
	
}

//Q2. Sort Flights by Fare (Descending)
//🔸 Problem:
//Class Flight has:
// String airline
// double fare
//Sort a list of flights by:
// fare in descending order (highest fare first).
//🔸 Hint: Use Double.compare(f2.fare, f1.fare) to reverse the order