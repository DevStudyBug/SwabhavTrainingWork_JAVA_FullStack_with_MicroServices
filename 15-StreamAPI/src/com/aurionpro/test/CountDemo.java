package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CountDemo {
public static void main(String[] args) {
	List <Integer> list = Arrays.asList(40,80,50,30,12,20,10,60,70,80,1);
	long passstudent = list.stream().filter(pass->pass>60).count();
	System.out.println("Total Pass students: " + passstudent);
	System.out.println("Even count "+list.stream().filter(iseven->iseven%2 ==0).count());
	System.out.println("odd count "+list.stream().filter(iseven->iseven%2 ==1).count());

	Integer[] marks = { 10, 20 ,30 ,40};
//	System.out.println(marks.stream.filter(i->i>30).count());
	
	System.out.println("marks above 30 "+Arrays.stream(marks).filter(i->i>30).count());
	
	Stream input = Stream.of(1,2,3,"Array",4.5);
	System.out.println(input.toString().charAt(4));
}
} 
//1. get the total number of passed student from the list.
//2. Given a list of integers, count how many are even / odd