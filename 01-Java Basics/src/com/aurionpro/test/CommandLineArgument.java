package com.aurionpro.test;

public class CommandLineArgument {
	public static void main(String [] args ) {
		int number1 = Integer.parseInt(args[0]);
		int number2 =Integer.parseInt(args[1]) ;
		int sum = number1 + number2;
		System.out.println(" sum is : "+ sum );
		System.out.println(" My name is " + args[2]);
	}
}
