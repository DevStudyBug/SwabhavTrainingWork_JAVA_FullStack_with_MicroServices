package assignment.day4.test;

import java.util.Scanner;

import assignment.day4.model.StudentSubjectMarks;

public class StudentSubjectTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of student : ");
		String nameofStudent = scanner.nextLine();

		System.out.println("Enter the marks of 3 Subject : ");

		System.out.print("Enter makrs of subject 1:  ");
		int subject1 = scanner.nextInt();

		System.out.print("Enter makrs of subject 2:  ");
		int subject2 = scanner.nextInt();

		System.out.print("Enter makrs of subject 3:  ");
		int subject3 = scanner.nextInt();

		StudentSubjectMarks student = new StudentSubjectMarks(subject1, subject2, subject3);

		// Display result
		System.out.println("Marks of 3 subjects for student name : " + nameofStudent);
		student.display();

	}
}
