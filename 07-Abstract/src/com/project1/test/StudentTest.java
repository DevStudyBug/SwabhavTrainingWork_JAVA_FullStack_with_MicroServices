package com.project1.test;

import java.util.Scanner;

import com.project1.model.CommerceStudent;
import com.project1.model.ScienceStudent;
import com.project1.model.Student;

public class StudentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of Students :");
		int num = scanner.nextInt();
		scanner.nextLine();
		Student[] students = new Student[num];
		for(int i = 0; i<students.length;i++) {
			System.out.println("Enter name of student"+(i+1));
			String name = scanner.nextLine();
			
			System.out.println("Enter Roll number :");
			int rollNumber = scanner.nextInt();
//			scanner.nextLine();
			
			System.out.println("Enter Student Type :");
			System.out.println("1.Science Student");
			System.out.println("2. Commerce Student");
			int select = scanner.nextInt();
			if(select!=1 && select!=2) {
				System.out.println("Invalid selection");
				 i--; 
			}
			else if(select == 1) {
				System.out.println("Enter marks :");
				System.out.print("1. physics :");
				int phyMarks = scanner.nextInt();
				System.out.println("2. Chemisty");
				int chemMarks = scanner.nextInt();
				System.out.println("3. Maths");
				int mathsMarks = scanner.nextInt();
				students[i]= new ScienceStudent(rollNumber, name, phyMarks, chemMarks, mathsMarks);
			}
			else if (select == 2) {
				System.out.println("Enter marks :");
				System.out.print("1. Accounts :");
				int accounts = scanner.nextInt();
				System.out.println("2. Econmics");
				int ecnomics = scanner.nextInt();
				System.out.println("3. Business");
				int buisness = scanner.nextInt();
				students[i]= new CommerceStudent(rollNumber, name, accounts,ecnomics,buisness);
			}
			scanner.nextLine();
		}
		
		for (Student std: students) {
			std.CalculateGrade();
		}
		scanner.close();
	}

}
