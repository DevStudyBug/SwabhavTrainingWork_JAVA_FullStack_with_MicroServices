package com.aurionpro.GuitarApp.Solution.Testing;


import java.util.Scanner;

public class InputValidator {

	public static <T extends Enum<T>> T getEnumInput(Scanner scanner, T[] values, String label) {
		System.out.println("\nSelect " + label + " (or press Enter to skip):");
		for (int i = 0; i < values.length; i++) {
			System.out.printf("%d. %s%n", i + 1, values[i]);
		}
		System.out.print("Enter choice: ");
		String input = scanner.nextLine().trim();
		if (input.isEmpty())
			return null;
		try {
			int index = Integer.parseInt(input);
			if (index >= 1 && index <= values.length)
				return values[index - 1];
		} catch (Exception ignored) {
		}
		System.out.println("Invalid input. Skipping " + label);
		return null;
	}

	public static String getModelInput(Scanner scanner, java.util.List<String> models) {
		System.out.println("\nSelect Model (or press Enter to skip):");
		for (int i = 0; i < models.size(); i++) {
			System.out.printf("%d. %s%n", i + 1, models.get(i));
		}
		System.out.print("Enter choice: ");
		String input = scanner.nextLine().trim();
		if (input.isEmpty())
			return "";
		try {
			int index = Integer.parseInt(input);
			if (index >= 1 && index <= models.size())
				return models.get(index - 1);
		} catch (Exception ignored) {
		}
		System.out.println("Invalid input. Skipping Model");
		return "";
	}

	public static Integer getIntInput(Scanner scanner, String prompt) {
		System.out.print("\n" + prompt);
		String input = scanner.nextLine().trim();
		if (input.isEmpty())
			return null;
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Invalid number. Skipping.");
			return null;
		}
	}
}

