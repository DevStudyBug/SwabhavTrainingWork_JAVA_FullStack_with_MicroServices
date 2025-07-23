package com.aurionpro.comparator.test;

import java.util.ArrayList;
import java.util.Collections;

import com.aurionpro.comparator.model.Student;
import com.aurionpro.comparator.model.IdSortUsingComparator;
import com.aurionpro.comparator.model.SortByName;

public class StudentTest {
	public static void main(String[] args) {
		ArrayList <Student> list = new ArrayList<>();
		list.add(new Student(12,"Amit"));
		list.add(new Student(22,"Om"));
		list.add(new Student(15,"Alok"));
		list.add(new Student(13,"Vivek"));
		
		System.out.println("Array before sorting: \n"+list);
		Collections.sort(list , new IdSortUsingComparator());
		System.out.println("Array after sorting by id: \n"+list);
		Collections.sort(list , new SortByName());
		System.out.println("Array after sorting by name: \n"+list);
}
}
