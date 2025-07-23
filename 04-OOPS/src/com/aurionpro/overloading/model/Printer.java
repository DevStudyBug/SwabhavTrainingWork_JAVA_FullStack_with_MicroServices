package com.aurionpro.overloading.model;
//1. Print Details
//Create a class Printer with overloaded print() methods:
// print() – prints "Default message"
// print(String msg) – prints the message
// print(int number) – prints the number

public class Printer {
public String print() {
	return "Prints Default message" ;
}
public String print(String msg) {
	return "Print the message";
}
public double print (int number) {
	System.out.println("Print the number");
	return number;
}
}
