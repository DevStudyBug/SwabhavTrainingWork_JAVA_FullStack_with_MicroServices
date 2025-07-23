package com.aurionpro.comparable.test;

import java.util.ArrayList;
import java.util.Collections;

import com.aurionpro.comparable.model.Student;

public class StudentTest {
public static void main(String[] args) {
	
	ArrayList <Student> list = new ArrayList<>();
	
	list.add(new Student(12,"Amit"));
	list.add(new Student(22,"Om"));
	list.add(new Student(15,"Alok"));
	list.add(new Student(13,"Vivek"));
	
	System.out.println("Array before sorting: "+list);
	Collections.sort(list);
	System.out.println("Array after sorting: "+list);
	
}
}
