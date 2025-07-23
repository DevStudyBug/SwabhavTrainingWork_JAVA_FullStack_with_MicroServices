package com.aurionpor.model;

import java.util.Scanner;

public class DivisionbyZero {
	public static void main(String[] args) {
	
		try {
			int num1,num2,num3;
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter First Number");
			num1 = scanner.nextInt();
			System.out.println("Enter Second Number");
			num2 = scanner.nextInt();
			
		    num3 = num1/num2;
			System.out.println("division: "+ num3);
			
		}
		catch(NullPointerException e) {
			System.out.println("Invalid input (non-numeric");
		}
		catch(ArithmeticException e) {
			System.out.println("Arithmetic Exception: division by zero!");
			System.exit(0);
		}
		
		catch(Exception e) {
			System.out.println(e);
			System.exit(0);
		}
		finally {
			System.out.println("Anshika's programs sucks oooooh");
		}
	}


}
//1. try-catch
//Problem:
//Write a program that takes two numbers from the user and divides them. Use try-catch to
//handle:
// Division by zero
// Invalid input (non-numeric)
