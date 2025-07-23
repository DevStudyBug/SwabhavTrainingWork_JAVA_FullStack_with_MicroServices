package com.aurionpro.comparator.model;

import java.util.Comparator;

public class FlightFare implements Comparator<Flight>{

	@Override
	public int compare(Flight f1, Flight f2) {
	
		return Double.compare(f2.fare, f1.fare);
	}

}
