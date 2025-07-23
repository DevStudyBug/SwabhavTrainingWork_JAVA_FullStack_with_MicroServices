package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class findFirstFindAny {
public static void main(String[] args) {
	List<String> names = Arrays.asList("Amit","Om","Aradhya","Anshika","Alok","v","Rucha","Rashi","S");
	System.out.println("Find First: "+names.stream().filter(s->s.startsWith("A")).findFirst());
	System.out.println("Find any: "+names.stream().filter(s->s.startsWith("A")).findAny());
	System.out.println("---------------------");
	
	Stream.of("one", "two", "three", "four")
	.filter(e -> e.length() > 3)
	.peek(e -> System.out.println("Filtered value: " + e))
	.map(String::toUpperCase)
	.peek(e -> System.out.println("Mapped value: " + e))
	.collect(Collectors.toList());
System.out.println("--------------------");
	 List<String> cricketers = Arrays.asList(
	            "Sachin Tendulkar", 
	            "Virat Kohli", 
	            "MS Dhoni", 
	            "Rohit Sharma", 
	            "Hardik Pandya", 
	            "Jasprit Bumrah", 
	            "Shikhar Dhawan", 
	            "Bhuvneshwar Kumar", 
	            "Kedar Jadhav"
	        );

	        // Using findFirst() to get the first cricketer's name starting with "V"
	        Optional<String> firstMatch = cricketers.stream()
	                                              .filter(s -> s.startsWith("V"))
	                                              .findFirst();

	        // Using findAny() to get any cricketer's name starting with "S"
	        Optional<String> anyMatch = cricketers.stream()
	                                            .filter(s -> s.startsWith("S"))
	                                            .findAny();

	        // Printing the results
	        System.out.println("First cricketer starting with 'V': " + firstMatch.orElse("No match found"));
	        System.out.println("Any cricketer starting with 'S': " + anyMatch.orElse("No match found"));
	    }
}

