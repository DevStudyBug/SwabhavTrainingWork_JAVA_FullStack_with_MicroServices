package com.aurionpro.Candidate.model;

import java.util.Comparator;

public class SortByName implements Comparator<Candidate> {

	@Override
	public int compare(Candidate c1, Candidate c2) {

		int nameCompare = c1.name.compareTo(c2.name);
		if (nameCompare == 0) {
			return c1.age - c2.age;
		} else {
			return nameCompare;
		}
//		   return (nameCompare == 0) ? c1.age - c2.age : nameCompare;
	}

}
