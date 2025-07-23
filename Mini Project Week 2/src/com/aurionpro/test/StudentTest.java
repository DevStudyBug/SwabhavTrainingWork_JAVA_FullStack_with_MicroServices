package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.ArtsStudent;
import com.aurionpro.model.CommerceStudent;
import com.aurionpro.model.ScienceStudent;
import com.aurionpro.model.Student;

public class StudentTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of students: ");
		int number = scanner.nextInt();
		scanner.nextLine();

		Student[] students = new Student[number];

		for (int i = 0; i < number; i++) {
			System.out.println("\nEnter details for Student " + (i + 1));
			System.out.print("Enter name: ");
			String name = scanner.nextLine();

			System.out.print("Enter roll number: ");
			int rollNumber = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter stream (Science/Commerce/Arts): ");
			String stream = scanner.nextLine();

			if (stream.equalsIgnoreCase("Science")) {
				System.out.print("Enter Physics marks: ");
				int physics = scanner.nextInt();
				System.out.print("Enter Chemistry marks: ");
				int chemistry = scanner.nextInt();
				System.out.print("Enter Maths marks: ");
				int maths = scanner.nextInt();
				scanner.nextLine();

				students[i] = new ScienceStudent(name, rollNumber, physics, chemistry, maths);

			} else if (stream.equalsIgnoreCase("Commerce")) {
				System.out.print("Enter Accounts marks: ");
				int accounts = scanner.nextInt();
				System.out.print("Enter Business Studies marks: ");
				int business = scanner.nextInt();
				System.out.print("Enter Economics marks: ");
				int economics = scanner.nextInt();
				scanner.nextLine();

				students[i] = new CommerceStudent(name, rollNumber, accounts, business, economics);

			} else if (stream.equalsIgnoreCase("Arts")) {
				System.out.print("Enter History marks: ");
				int history = scanner.nextInt();
				System.out.print("Enter Political Science marks: ");
				int political = scanner.nextInt();
				System.out.print("Enter Sociology marks: ");
				int sociology = scanner.nextInt();
				scanner.nextLine(); // consume newline

				students[i] = new ArtsStudent(name, rollNumber, history, political, sociology);

			} else {
				System.out.println("Invalid stream entered!!");
				i--;
				continue;
			}
		}

//		System.out.println("\n--- Student Performance ---");
		for (Student std : students) {

			System.out.println("\nSelect Display Option:");
			System.out.println("1. Default Performance");
			System.out.println("2. Detailed Performance");
			System.out.println("3. Performance by Format (grade/percentage)");
			System.out.print("Enter choice (1-3): ");

			int choice = scanner.nextInt();
			scanner.nextLine(); //

			std.displayInfo();
			std.calculatePerformance();

			switch (choice) {
			case 1:
				std.displayPerformance();
				break;
			case 2:
				std.displayPerformance(true);
				break;
			case 3:
				System.out.print("Enter format (grade/percentage): ");
				String format = scanner.nextLine();
				std.displayPerformance(format);
				break;
			default:
				System.out.println("Invalid choice!");
			}

			System.out.println("---------------------------------------");
		}

		scanner.close();
	}
}
