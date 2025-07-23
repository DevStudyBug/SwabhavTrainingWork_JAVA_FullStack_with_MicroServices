package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class salary {
public static void main(String[] args) {
//	2. Given a list of salaries, sort in descending order and skip the top 2 values.

	List <Integer> salary = Arrays.asList(1000,23000,2000,40000,100000,900);
	salary.stream().sorted(Comparator.reverseOrder()).skip(2).forEach(System.out::println);
	
	//4. From a list of words, sort by descending length and display only the first 3 longest words
	List<String> names = Arrays.asList("Amit","Om","Aradhya","Anshika","Alok","v","Rucha","Rashi","adi");
	names.stream().sorted(Comparator.comparing(String::length).reversed()).limit(3).forEach(System.out::println);
	

	//5. Given a list of Product objects, filter products with price > 500, and limit the result to only 2 products.
	List <Integer> product = Arrays.asList(1000,23000,2000,40000,100000,900);
	product.stream().filter(price->price>500).limit(2).forEach(System.out::println);
	
	
}
}


