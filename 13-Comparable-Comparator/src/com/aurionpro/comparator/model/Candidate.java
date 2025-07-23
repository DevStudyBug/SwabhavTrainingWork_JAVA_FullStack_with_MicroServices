package com.aurionpro.comparator.model;

import java.util.Comparator;

public class Candidate  {
	String name;
	int age;

	public Candidate(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Candidate [name=" + name + ", age=" + age + "]";
	}
}
/*
 * Q1. Sort Candidates by Name, then by Age 🔸 Problem: Create a class Candidate
 * with:  String name  int age Sort a list of candidates:  First by name
 * (alphabetically)  Then by age (ascending), if names are equal. 🔸 Hint: Use
 * a custom Comparator<Candidate> and compare() with both fields
 */
