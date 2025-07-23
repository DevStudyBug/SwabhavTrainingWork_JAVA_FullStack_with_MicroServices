package com.aurionpro.model;

public class HiddenOps {
	private String secretCode(String input) {
//		return input;
		return new StringBuilder(input).reverse().toString();
		
	}
}

//Assignment 8
//Task:
//Class HiddenOps has a private method String secretCode(String input) that returns input in reverse.
//Use reflection to:
//
//Access and call the private method
//Pass "hello" → Output: "olleh"