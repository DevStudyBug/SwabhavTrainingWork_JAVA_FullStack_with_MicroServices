package com.aurionpro.comparator.test;

import java.util.ArrayList;
import java.util.Collections;

import com.aurionpro.comparator.model.Candidate;
import com.aurionpro.comparator.model.CandidateSortByNameThenID;

public class CandidateTest {
	public static void main(String[] args) {
		ArrayList<Candidate> list = new ArrayList<>();
		list.add(new Candidate("Alok", 22));
		list.add(new Candidate("Anshika", 23));
		list.add(new Candidate("Amit", 32));
		list.add(new Candidate("Vivek", 21));
		list.add(new Candidate("Avisha", 20));
		list.add(new Candidate("Prasant", 23));
		list.add(new Candidate("Soham", 23));
		list.add(new Candidate("Rashi", 24));
		list.add(new Candidate("Soham", 22));

		System.out.println("Before Sorting:");
		System.out.println(list);

		Collections.sort(list, new CandidateSortByNameThenID());

		System.out.println("\nAfter Sorting by Name, then Age:");
		System.out.println(list);

	}
}
