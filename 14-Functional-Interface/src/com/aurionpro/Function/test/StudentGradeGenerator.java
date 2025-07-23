package com.aurionpro.Function.test;

import java.util.Scanner;
import java.util.function.Function;

public class StudentGradeGenerator {
public static void main(String[] args) {
	Function<Integer , String > gradeFunction = (marks)->{
		if(marks>=75) {
			return "A";
		}else if (marks>=50) {
			return "B";
		}else {
			return "Fail";
		}
	};
	
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter Student marks");
	for(int i =1; i <=5 ; i++) {
		System.out.println("Enter marks for student "+i+": ");
		int inputMarks = scanner.nextInt();
		
		String grade = gradeFunction.apply(inputMarks);
		System.out.println("Student "+ ": marks = "+ inputMarks+ ", grade = "+ grade);
	}
	scanner.close();
}
}
