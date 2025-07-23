package com.aurionpro.overloading.model;

//🔹 5. Temperature Converter
//Create a class Converter:
// convert(double celsius) – converts to Fahrenheit
// convert(double value, String scale) – if scale is "C", convert to F; if "F",
//convert to C.
public class TemperatureConverter {
	double celsius;
	double fahrenheit;
	double value ;
	String scale;

	public double convert(double c) {
		double f = c * (9 / 5) + 32;
		return f;

	}

	public double convert(double value, String scale) {
		if (scale.equalsIgnoreCase("c")) {
			double f = value * (9 / 5) + 32;
			return f;
		} else {
			double c = value - 32 * 5 / 9;
			return c;
		}
	}

}