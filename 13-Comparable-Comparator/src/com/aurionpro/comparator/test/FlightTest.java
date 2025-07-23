package com.aurionpro.comparator.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.aurionpro.comparator.model.Flight;
import com.aurionpro.comparator.model.FlightFare;

public class FlightTest {
	public static void main(String[] args) {
		ArrayList<Flight> list = new ArrayList<>();
		list.addAll(Arrays.asList(new Flight("IndiGo", 5000), new Flight("Air India", 7500),
				new Flight("SpiceJet", 4500), new Flight("Vistara", 8000)));

		System.out.println("Array before sorting: \n" + list);

		Collections.sort(list, new FlightFare());

		System.out.println("Array before sorting: \n" + list);
	}
}

/*
 * Q2. Sort Flights by Fare (Descending) 🔸 Problem: Class Flight has:  String
 * airline  double fare Sort a list of flights by:  fare in descending order
 * (highest fare first). 🔸 Hint: Use Double.compare(f2.fare, f1.fare) to
 * reverse the order
 */