package com.aurionpro.Assignment.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.aurionpro.Candidate.model.Candidate;
import com.aurionpro.Candidate.model.SortByName;

public class CandidateTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Candidate> list = new ArrayList<>();

        System.out.println("------ Enter Candidate details -------");

        while (true) {
            String name = getValidName(scanner);
            int age = getValidAge(scanner);

            list.add(new Candidate(name, age));

            if (!askYesOrNo(scanner)) {
                break;
            }
        }

        if (list.isEmpty()) {
            System.out.println("No candidates to sort.");
            return;
        }

        Collections.sort(list, new SortByName());

        System.out.println("\nSorted Candidates (by Name, then Age):");
        for (Candidate c : list) {
            System.out.println(c);
        }

        scanner.close();
    }

    private static String getValidName(Scanner scanner) {
        while (true) {
            System.out.print("Enter Candidate name: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name. Only alphabets and spaces allowed.");
            } else {
                return name;
            }
        }
    }

    private static int getValidAge(Scanner scanner) {
        while (true) {
            System.out.print("Enter Candidate age: ");
            String input = scanner.nextLine().trim();

            try {
                int age = Integer.parseInt(input);

                if (age <= 0 || age > 100) {
                    System.out.println("Invalid age. Enter age between 1 and 100.");
                } else {
                    return age;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for age.");
            }
        }
    }

    private static boolean askYesOrNo(Scanner scanner) {
        while (true) {
            System.out.print("Add another candidate? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("yes")) {
                return true;
            } else if (response.equals("no")) {
                return false;
            } else {
                System.out.println("Please enter 'yes' or 'no' only.");
            }
        }
    }
}

//Q1. Sort Candidates by Name, then by Age
//🔸 Problem:
//Create a class Candidate with:
// String name
// int age
//Sort a list of candidates:
// First by name (alphabetically)
// Then by age (ascending), if names are equal.
//🔸 Hint: Use a custom Comparator<Candidate> and compare() with both fields.
