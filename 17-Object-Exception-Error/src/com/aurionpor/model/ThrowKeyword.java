package com.aurionpor.model;

import java.util.Scanner;

public class ThrowKeyword {
	public static void validateMarks(int marks) {
		if (marks < 0 || marks > 100) {
			throw new ArithmeticException("IllegalArgumentException [Marks should be between 0 and 100]");
		} else {
			System.out.println("Valid marks: " + marks);
		}
	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a marks: ");
			int marks = sc.nextInt();
//			ThrowKeyword.validateMarks( marks);
			validateMarks(marks);

		} catch (ArithmeticException e) {
			System.out.println("Invalid marks :"+ e.getMessage());
			System.exit(0);
		} finally {
			System.out.println("End");
		}
	}
}

//4. throw keyword
//Problem:
//Create a method validateMarks(int marks)
// If marks < 0 or marks > 100, manually throw IllegalArgumentException
// Else print “Valid marks