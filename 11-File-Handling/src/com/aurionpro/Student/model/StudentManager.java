package com.aurionpro.Student.model;

import java.io.*;
import java.util.Scanner;

public class StudentManager {

    private static final String FILE_NAME = "Student.txt";
    Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.println("\n--- Add New Student ---");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
        	while (true) {
                System.out.print("Enter Roll Number: ");
                int roll = Integer.parseInt(scanner.nextLine());
                
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                
                System.out.print("Enter Marks: ");
                int marks = Integer.parseInt(scanner.nextLine());

                Student student = new Student(roll, name, marks);
                writer.write(student.roll + "," + student.name + "," + student.marks);
                writer.newLine();

                System.out.println("Student added successfully!");

                String choice;
                while (true) {
                    System.out.print("Do you want to add another student? (yes/no): ");
                    choice = scanner.nextLine().trim().toLowerCase();
                    
                    if (choice.equals("yes") || choice.equals("no")) {
                        break;
                    }
                    System.out.println("Invalid input. Please type 'yes' or 'no'.\n");
                }

                if (choice.equals("no")) {
                    break;
                }
            }
            
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    public void viewAllStudents() {
        System.out.println("\n--- All Student Records ---\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean found = false;

            System.out.printf("%-10s %-15s %-5s\n", "Roll", "Name", "Marks");
            System.out.println("-------------------------------");

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Student student = new Student(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));
                    System.out.println(student);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No student records found.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. No records exist yet.");
        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
        }
    }

    public void searchStudentByRoll() {
        System.out.println("\n--- Search Student by Roll Number ---\n");

        while (true) {
            System.out.print("Enter Roll Number to search: ");
            int searchRoll = Integer.parseInt(scanner.nextLine());
            boolean found = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3 && Integer.parseInt(parts[0]) == searchRoll) {
                        Student student = new Student(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));
                        System.out.println("\nStudent Found:");
                        System.out.printf("%-10s %-15s %-5s\n", "Roll", "Name", "Marks");
                        System.out.println("-------------------------------");
                        System.out.println(student);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student with roll number " + searchRoll + " not found.");
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found. No records exist yet.");
            } catch (IOException e) {
                System.out.println("File read error: " + e.getMessage());
            }

            System.out.print("Do you want to search another roll number? (yes/no): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }

    public void deleteStudentByRoll() {
        System.out.println("\n--- Delete Student by Roll Number ---\n");

        while (true) {
            System.out.print("Enter Roll Number to delete: ");
            int deleteRoll = Integer.parseInt(scanner.nextLine());
            boolean deleted = false;

            File inputFile = new File(FILE_NAME);
            File tempFile = new File("temp.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3 && Integer.parseInt(parts[0]) == deleteRoll) {
                        deleted = true;
                        continue;
                    }
                    writer.write(line);
                    writer.newLine();
                }

            } catch (IOException e) {
                System.out.println("Error processing file: " + e.getMessage());
                return;
            }

            if (deleted) {
                if (inputFile.delete()) {
                    if (tempFile.renameTo(inputFile)) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Error renaming temp file.");
                    }
                } else {
                    System.out.println("Error deleting original file.");
                }
            } else {
                System.out.println("Student with roll number " + deleteRoll + " not found.");
                tempFile.delete();
            }

            String choice;
            while (true) {
                System.out.print("Do you want to delete another roll number? (yes/no): ");
                choice = scanner.nextLine().trim().toLowerCase();
                if (choice.equals("yes") || choice.equals("no")) {
                    break;
                }
                System.out.println("Invalid input. Please type 'yes' or 'no'.");
            }

            if (choice.equals("no")) {
                break;
            }
        }
    }}