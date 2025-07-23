package com.aurionpro.overloading.test;

import java.util.Scanner;

import com.aurionpro.overloading.model.StudentResultEvaluator;

public class StudentResultEvaluatorTest {
	public static void main(String[] args) {
		int marks , totalMarks;
		String grade ="A";  //A or B
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter marks");
		marks = scanner.nextInt();
		
		System.out.println("enter total marks");
		totalMarks = scanner.nextInt();
		
		StudentResultEvaluator student = new StudentResultEvaluator();
		
		student.evaluate(marks);
		
		String g = student.evaluate(marks, totalMarks);  //  Percentage to Grade
        System.out.println("Calculated Grade: " + g);

		 System.out.println("Calculated Grade: " + student.evaluate(grade));

	}

}
