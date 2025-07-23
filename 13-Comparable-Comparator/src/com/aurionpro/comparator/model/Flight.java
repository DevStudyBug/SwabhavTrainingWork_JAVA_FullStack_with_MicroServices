package com.aurionpro.comparator.model;

import java.util.Comparator;

public class Flight  {
	String airline;
	 double fare;
	public Flight(String airline, double fare) {
		this.airline = airline;
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "Flight [airline=" + airline + ", fare=" + fare + "]";
	}
	
	
}
