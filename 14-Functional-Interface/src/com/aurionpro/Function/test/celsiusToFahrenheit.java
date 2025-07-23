package com.aurionpro.Function.test;

import java.util.function.Function;

public class celsiusToFahrenheit {
public static void main(String[] args) {
	// Function to convert Celsius to Fahrenheit
    Function<Double, Double> celsiusToFahrenheit = celsius -> (celsius * 9 / 5) + 32;

    double[] celsiusValues = {0, 20, 37};

    System.out.println("=== Celsius to Fahrenheit Conversion ===");
    for (double celsius : celsiusValues) {
        double fahrenheit = celsiusToFahrenheit.apply(celsius);
        System.out.printf(celsius + "°C = " + fahrenheit + "°F"+ "\n");
    }
}
}
