package com.aurionpro.comparator.model;

import java.util.Comparator;

public class CandidateSortByNameThenID implements Comparator<Candidate> {

	@Override
	public int compare(Candidate c1, Candidate c2) {

		int nameCompare = c1.name.compareTo(c2.name);
		if (nameCompare == 0) { // equal
			return c1.age - c2.age; // ascending order
		} else {
			return nameCompare;
		}
	}

}
