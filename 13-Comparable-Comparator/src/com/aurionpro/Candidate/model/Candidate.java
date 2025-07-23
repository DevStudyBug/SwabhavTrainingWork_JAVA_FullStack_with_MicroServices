package com.aurionpro.Candidate.model;

public class Candidate {
	String name; 
	int age ;
	public Candidate(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Candidate [name=" + name + ",age=" + age + "]";
	}
	
}
