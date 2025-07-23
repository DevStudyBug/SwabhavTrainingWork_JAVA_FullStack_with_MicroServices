package com.aurionpro.test;

public class LargestOfThreeNumber {
	public static void main(String [] args) {
		int number1 = 5,  number2 = 6,  number3 = 2;
		int largest;
		if( number1 > number2 && number1 >number3) {
			largest = number1; 
			
		} else if (number2 > number1 && number2 > number3) {
			largest = number2;
		}
	   else {
	    	largest = number3;
	    }
	    System.out.println("largest number is : " + largest);
	}
}