package com.aurionpro.test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.aurionpro.model.Employee_Miscellaneous;

public class EmployeeTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee_Miscellaneous> employees = new ArrayList<>();

        System.out.println("Enter Employee Details");

        while (true) {
            try {
                // Name validation
                String name = "";
                while (true) {
                    System.out.print("Enter name: ");
                    name = scanner.nextLine().trim();
                    if (!name.matches("[a-zA-Z ]+")) {
                        System.out.println("Invalid name. Only letters and spaces allowed.");
                    } else {
                        break;
                    }
                }

                // Salary validation
                double salary = 0;
                while (true) {
                    System.out.print("Enter salary: ");
                    try {
                        salary = Double.parseDouble(scanner.nextLine());
                        if (salary <= 0) {
                            System.out.println("Salary must be positive.");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Enter a valid number.");
                    }
                }

                // Joining date validation
                LocalDate joiningDate = null;
                while (true) {
                    System.out.print("Enter joining date (yyyy-MM-dd): ");
                    String dateInput = scanner.nextLine();
                    try {
                        joiningDate = LocalDate.parse(dateInput);
                        break;
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Use yyyy-MM-dd.");
                    }
                }

                // Gender validation
                String gender = "";
                while (true) {
                    System.out.print("Enter gender (M/F): ");
                    gender = scanner.nextLine().trim().toUpperCase();
                    if (!gender.equals("M") && !gender.equals("F")) {
                        System.out.println("Gender must be 'M' or 'F'.");
                    } else {
                        break;
                    }
                }

                // Add employee
                employees.add(new Employee_Miscellaneous(name, salary, joiningDate, gender));
                System.out.println("Employee added successfully.");

                // Ask to continue
                System.out.print("Add another employee? (Yes/No): ");
                String choice = scanner.nextLine().trim();
                if (choice.equalsIgnoreCase("No")) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // clear buffer
            }
        }

        scanner.close();

        // Display all employees
        System.out.println("\nEmployee List:");
        employees.forEach(System.out::println);

        // 1. Max salary
        System.out.println("\nEmployee with Maximum Salary:");
        employees.stream()
            .max(Comparator.comparing(e -> e.salary))
            .ifPresent(System.out::println);

        // 2. Second highest salary
        System.out.println("\nEmployee with Second Highest Salary:");
        employees.stream()
            .sorted(Comparator.comparing((Employee_Miscellaneous e) -> e.salary).reversed())
            .skip(1)
            .findFirst()
            .ifPresent(System.out::println);

        // 3. Most senior employee
        System.out.println("\nMost Senior Employee:");
        employees.stream()
            .min(Comparator.comparing(e -> e.joiningDate))
            .ifPresent(System.out::println);

        // 4. Count employees based on gender
        System.out.println("\nEmployee Count by Gender:");
        employees.stream()
            .collect(Collectors.groupingBy(e -> e.gender, Collectors.counting()))
            .forEach((g, count) -> System.out.println(g + " : " + count));
    }
}
