package com.aurionpro.model;

public class StringBuilderExample {
public static void main(String[] args) {
	String str1 = "Hello";
	str1.concat("world"); // Creates "Helloworld", but doesn't store it
	System.out.println(str1);
	str1 = str1.concat("world");
	System.out.println("updated value "+str1);
	
	StringBuilder stringBuilder = new StringBuilder("Hello");
	System.out.println(stringBuilder);
	//Allocates memory in the heap for a new StringBuilder object.
	stringBuilder.append("World");
	System.out.println(stringBuilder);
	
	System.out.println(stringBuilder.reverse());
System.out.println("updated value "+stringBuilder);
	stringBuilder.insert(0, 'F');
	System.out.println(stringBuilder);

	stringBuilder.replace(0, 2, "F");
	System.out.println("replace: "+stringBuilder);
	
	System.out.println(str1.hashCode());

	StringBuilder stringBuilder1 = new StringBuilder("Hello");
	StringBuilder stringBuilder2 = new StringBuilder("Hello");

	System.out.println(stringBuilder1 == stringBuilder2); //Checks reference (memory address).
	System.out.println(stringBuilder1.equals(stringBuilder2)); // Checks reference (memory address).
//	compare contents 
	System.out.println(stringBuilder1.toString().equals(stringBuilder2.toString()));

}
}
