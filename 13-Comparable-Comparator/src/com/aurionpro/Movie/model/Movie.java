package com.aurionpro.Movie.model;

public class Movie {
	String title;
	int year;
	public Movie(String title, int year) {
		this.title = title;
		this.year = year;
	}
	@Override
	public String toString() {
//		return "Movie [title=" + title + ", year=" + year + "]";
		return String.format("%-20s %-10d", title, year);
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