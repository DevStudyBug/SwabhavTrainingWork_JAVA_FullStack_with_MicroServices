package com.aurionpro.project.model;

public class Student extends Person {
//	String name;
//	String department;
	int rollNo;
	String enrolledCourses;
	public static int totalStudents = 0;

	public Student(String name, Departments department, int rollNo) {
		super(name, department);
		this.rollNo = rollNo;
		totalStudents++;
	}

	public void enrollCourse(String course) {
		this.enrolledCourses = course;
	}

	@Override
	public String getDetails() {
	    return String.format("%-15s %-15s %-15d %-20s", name, department, rollNo, enrolledCourses);
	}

}




/**
 * 1. Design and implement a Java-based system to manage student and professor
 * data for a university. Each student should have details like name, roll
 * number, department, and enrolled courses. Professors should have name, ID,
 * department, and assigned subjects.
 * 
 * The system should:
 * 
 * Maintain a count of total students and courses (using static).
 * 
 * Use enums to define departments and course types (CORE, ELECTIVE).
 * 
 * Allow methods like enrollCourse() for students and assignSubject() for
 * professors.
 * 
 * Demonstrate inheritance using a Person base class and subclasses Student and
 * Professor.
 * 
 * Use polymorphism to override a method like getDetails() in each subclass.
 */