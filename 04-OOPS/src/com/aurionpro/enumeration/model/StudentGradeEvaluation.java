package com.aurionpro.enumeration.model;

import java.util.Scanner;

public class StudentGradeEvaluation {
	public void gradecalculation(Grade grade) {
		switch(grade){
			case A:
				System.out.println("Excellent !");
				break;
			case B:
				System.out.println("very good !");
				break;
			case C:
				System.out.println("Good !");
				break;
			case D:
				System.out.println("Bad!");
				break;
			case E:
				System.out.println("need improvment!");
				break;
			default: System.out.println("Enter correct grade!!");
		}
		
	}
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the grade (A, B, C, D, E): ");
//	char ch = scanner.next().charAt(0);
	String g = scanner.nextLine().toUpperCase();
	Grade grade = Grade.valueOf(g);
	StudentGradeEvaluation std = new StudentGradeEvaluation();
	std.gradecalculation(grade);
//	gradecalculation(grade);
	
	
}
}
