package com.aurionpro.overloading.test;

import com.aurionpro.overloading.model.TemperatureConverter;

public class TemperatureConverterTest {
	public static void main(String[] args) {
//		double celsius;
//		double fahrenheit;
		double value =20;
		String scale = "c";
		TemperatureConverter temp = new TemperatureConverter();
		System.out.println("Temprature: "+ temp.convert(value,scale));
	}
}
