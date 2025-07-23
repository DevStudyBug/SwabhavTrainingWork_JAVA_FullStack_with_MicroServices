package com.aurionproThrowsExample.model;

import java.util.Scanner;

public class CustomException{
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner (System.in);
			System.out.println("Enter your password: ");
			String password = scanner.nextLine();

			if(password.length()<8) {
				throws new InvalidPasswordException();
				System.out.println("");
			}
		}
	}
		
}

//5. Custom Exception
//Problem:
//Create a custom exception InvalidPasswordException.
// Write a method checkPassword(String pwd) that throws the exception if the
//password is less than 8 characters or doesn't contain a digit.
// Handle it in main() and print a message.
