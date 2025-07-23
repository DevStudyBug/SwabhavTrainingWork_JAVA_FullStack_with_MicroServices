package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Student;

public class StudentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of students :");
		int num = scanner.nextInt();
		scanner.nextLine();
		
		Student[] students = new Student[num];
		for(int i =0;i<num;i++) {
			System.out.println("Enter student name :");
			String name = scanner.nextLine();
			System.out.println("Enter roll no:");
			int rollNo = scanner.nextInt();
			System.out.println("Enter marks :");
			int marks = scanner.nextInt();
			scanner.nextLine();
			

			students[i] = new Student();
			students[i].setname(name);
			students[i].setrollNo(rollNo);
			students[i].setmarks(marks);
			
		}
		for (Student std : students ) {
			System.out.println(std);
		}

	}
}
