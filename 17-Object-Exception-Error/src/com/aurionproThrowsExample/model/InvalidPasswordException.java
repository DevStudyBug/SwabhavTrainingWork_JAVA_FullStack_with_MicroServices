package com.aurionproThrowsExample.model;

public class InvalidPasswordException extends Exception {
	public InvalidPasswordException() {
		System.out.println("Invalid password!");
	}
	public  InvalidPasswordException(String message) {
		super(message);
	}
}
//5. Custom Exception
//Problem:
//Create a custom exception InvalidPasswordException.
// Write a method checkPassword(String pwd) that throws the exception if the
//password is less than 8 characters or doesn't contain a digit.
// Handle it in main() and print a message.
