package com.aurionpro.test;

public class WrapperClass {
	public static void main(String [] args ) {
		
	
	int number1 = 7; 
	Integer number2 = new Integer(number1); // boxing
	Integer number3 = number1;  //autoboxing
	
	System.out.println(number1);
	System.out.println(number2);
	System.out.println(number3);
	
	int number4 = number2.intValue();
	int number5 = number3;
	System.out.println(number4); //unboxing
	System.out.println(number5); //autounboxing
	}
	
	
}
