package com.aurionpro.model;

public class StringBasics {
public static void main(String[] args) {
	String str1 = "amit";
	String str2 = "amit";
	System.out.println(str1==str2);  // store in string pool
	String str3 ="hello";
	System.out.println(str3.concat(" world"));
	
	//heap memory store all objects 
	String str4 = new String("hello");
	String str5 = new String ("hello");
	System.out.println(str4==str5);  // compare reference
	System.out.println(str3.compareTo(str4));  // Compares content,
	System.out.println(str3.equals(str4));     // check value
	System.out.println();
	String string1= "Amit";
	String string2= "Amit";

	System.out.println(string1==string2);

	String greet = "Welcome to Swabhav";
System.out.println("Hello here");
	System.out.println(greet.charAt(1));
	System.out.println(greet.charAt(10));
	System.out.println(greet.length());
	System.out.println(greet.substring(10,greet.length()));
	System.out.println(greet.substring(10));
	
	for(int i=0; i<greet.length();i++)
	{
	    System.out.print(greet.charAt(i) + " ");
	}
	System.err.println("\n");
	System.out.println(greet.startsWith("Wel"));
}
}
