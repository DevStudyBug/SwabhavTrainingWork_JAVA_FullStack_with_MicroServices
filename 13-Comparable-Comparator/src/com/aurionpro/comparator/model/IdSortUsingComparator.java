package com.aurionpro.comparator.model;

import java.util.Comparator;
import java.util.stream.Collector;

public class IdSortUsingComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
	
		return o1.id - o2.id;
	}
	
	
}
