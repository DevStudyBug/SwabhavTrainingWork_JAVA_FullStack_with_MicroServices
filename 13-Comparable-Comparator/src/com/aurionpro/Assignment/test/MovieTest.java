package com.aurionpro.Assignment.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;

import com.aurionpro.Movie.model.Movie;
import com.aurionpro.Movie.model.SortByYearThenTitle;

public class MovieTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Movie> list = new ArrayList<>();
		System.out.println("----Enter Movie Details----\n");
		while (true) {
			try {
				System.out.println("Enter the Movie Title: ");
				String title = scanner.nextLine();

				if (title.isEmpty() || !title.matches("[a-zA-Z0-9]+")) {
					throw new IllegalArgumentException("Title must contains aphabets , number and space!\n");
				}

				int year;
				while (true) {
					try {
						System.out.println("Enter release year: ");
						year = Integer.parseInt(scanner.nextLine());

						int currentYear = Calendar.getInstance().get(Calendar.YEAR);

						if (year < 1950 || year > currentYear + 5) {
							throw new IllegalArgumentException("Year must be between 1950 and " + (currentYear + 5)
									+ " (including upcoming movies)!\n");
						}
						break;
					} catch (NumberFormatException e) {
						System.out.println("Invalid input, Year must have numeric value!\n");
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
				}
				list.add(new Movie(title, year));

				String choice;
				while (true) {
					System.out.println("Add another movie in list? (yes/no)");
					choice = scanner.nextLine().toLowerCase();
					if (choice.equals("yes") || choice.equals("no")) {
						break;
					}
					System.out.println("Please enter 'yes' or 'no' only\n");
				}
				if (choice.equals("no")) {
					break;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error: " + e.getMessage());
			}
		}
		if(list.isEmpty()) {
			System.out.println("No movie to sort!!");
			scanner.close();
			return;
		}
		Collections.sort(list, new SortByYearThenTitle());
		
		System.out.println("\n-----Movie sorted by Year (Descending) then Title(Ascending)-----\n ");
		System.out.printf("%-20s %-10s\n", "Title", "Year");
		System.out.println("---------------------------------------");
		for(Movie m : list) {
			System.out.println(m);
		}
		scanner.close();
	}
}

//Q3. Sort Movies by Year (Descending), then Title
//(Ascending)
//🔸 Problem:
//Create a Movie class with:
// String title
// int year
//Sort a list of movies:
// By year (latest first)
// If same year, then by title (A to Z)