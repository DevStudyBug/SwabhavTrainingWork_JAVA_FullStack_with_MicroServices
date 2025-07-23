package com.aurionpro.Student.test;

import java.util.Scanner;

import com.aurionpro.Student.model.StudentManager;

public class StudentTest {

	public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("--------Welcome to Student Record Management System ------\n");

        do {
           System.out.println("\nPlease choose an option from the menu below:\n");
            System.out.println("1️ Add Student");
            System.out.println("2️ View All Students");
            System.out.println("3️ Search Student by Roll Number");
            System.out.println("4️ Delete Student by Roll Number");
            System.out.println("5️ Exit");
           
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> manager.addStudent();
                    case 2 -> manager.viewAllStudents();
                    case 3 -> manager.searchStudentByRoll();
                    case 4 -> manager.deleteStudentByRoll();
                    case 5 -> System.out.println("Exiting... Thank you!");
                    default -> System.out.println("Invalid choice. Please enter 1 to 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid numeric choice.");
                choice = 0;
            }

        } while (choice != 5);

        sc.close();
    }
}