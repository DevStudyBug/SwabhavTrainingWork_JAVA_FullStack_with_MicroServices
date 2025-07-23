package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.model.Student;

public class StudentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		Student [] students = new Student[3];
		List <Student> students = new ArrayList<>();
		System.out.println("-----Enter student details----");
		for (int i = 0 ; i <3 ; i++) {
			System.out.println("Enter student name: ");
			String name = scanner.nextLine();
			
			System.out.println("Enter rollnumber: ");
			int rollnumber = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Enter the CGPA: ");
			double cgpa = scanner.nextDouble();
			scanner.nextLine();
//			students[i] = new Student(name, rollnumber, cgpa);
			students.add(new Student(name, rollnumber, cgpa));
			
			
		}
//		for(Student std : students) {
//			System.out.println(std);
//		}
		
		students.stream().sorted(Comparator.comparing(s ->s.cgpa)).forEach(System.out::println);
		
		
	}
}
