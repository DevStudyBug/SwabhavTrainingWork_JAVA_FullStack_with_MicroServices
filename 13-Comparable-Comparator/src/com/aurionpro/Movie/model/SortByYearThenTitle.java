package com.aurionpro.Movie.model;

import java.util.Comparator;

public class SortByYearThenTitle implements Comparator<Movie> {

	@Override
	public int compare(Movie m1, Movie m2) {
		int yearCompare = Integer.compare(m2.year, m1.year); //Year (Descending), 
		// then Title (Ascending)
		return 	(yearCompare==0) ? m1.title.compareTo(m2.title) : yearCompare ;
	}

}
