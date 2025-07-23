package assignment.week1.test;

import java.util.Scanner;

import assignment.week1.model.Student;

public class StudentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student details ");
		
		System.out.print("Enter No. of students: ");
		int noOfStudents = scanner.nextInt();
		scanner.nextLine(); // clear newline after nextInt()

		Student[] student = new Student[noOfStudents];

		for (int i = 0; i < noOfStudents; i++) {
			System.out.println("\nEnter details for Student " + (i + 1) + ":");

			System.out.print("Enter Name: ");
			String name = scanner.nextLine();

			System.out.print("Enter Roll Number: ");
			int rollNo = scanner.nextInt();

			System.out.println("Enter marks of 3 Subjects:");
			System.out.print("Subject 1: ");
			int sub1 = scanner.nextInt();

			System.out.print("Subject 2: ");
			int sub2 = scanner.nextInt();
			System.out.print("Subject 3: ");
			int sub3 = scanner.nextInt();

			scanner.nextLine(); // clear newline after last int

			student[i] = new Student(name, rollNo, sub1, sub2, sub3);
		}

		System.out.println("\n--- Student Details ---");
		for (Student result : student) {
			result.display();
		}
		scanner.close();
	}

}
