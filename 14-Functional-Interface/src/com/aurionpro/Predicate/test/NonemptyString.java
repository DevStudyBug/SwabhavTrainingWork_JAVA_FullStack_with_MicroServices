package com.aurionpro.Predicate.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NonemptyString {
	public static void main(String[] args) {
		Predicate <String> validstring = str-> str != null &&  !str.isEmpty();
		
		List<String> string = Arrays.asList("" , "Java", null, " ");
		
		System.out.println("Valid non-empty strings:");

        // Loop and filter valid strings
        for (String str : string) {
            if (validstring.test(str)) {
                System.out.println(str);
            }
        }
	}
}

//2. Non-empty String
//Create a Predicate<String> that checks if a given string is not empty and not null.
//Task: Filter valid strings from a list: ["", "Java", null, " "]