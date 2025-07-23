package com.aurionpro.Supplier.test;

import java.util.Scanner;
import java.util.function.Supplier;

public class DefaultCity {
public static void main(String[] args) {
	Supplier<String> defaultcity =()-> "Pune";
	
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter city name: ");
	String cityname = scanner.nextLine();
	
	boolean validname = cityname.matches("[a-zA-z]+");

	String city = (validname) ? cityname : defaultcity.get();
	
	System.out.println("City name: "+ city);
	scanner.close();
}
}
//2. Default City Provider
//Create a Supplier<String> that supplies a default city name ("Pune").
//Task: Use it when no user input is provided (simulate fallback).