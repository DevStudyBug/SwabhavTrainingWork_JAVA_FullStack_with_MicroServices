package com.aurionpro.project.test;

import com.aurionpro.project.model.Departments;
import com.aurionpro.project.model.Professors;
import com.aurionpro.project.model.Student;

public class PersonTest {
	static int totalCourses = 0;

	public static void main(String[] args) {

		Student s1 = new Student("Alice", Departments.AIML, 101);
		Student s2 = new Student("Bob", Departments.IT, 102);

		Professors p1 = new Professors("Dr. Smith", Departments.COMPUTER, 1);
		Professors p2 = new Professors("Dr. Ganpati", Departments.IT, 2);

		s1.enrollCourse("JAVA");
		totalCourses++;

		s2.enrollCourse("DSA");
		totalCourses++;

		p1.assignSubject("SOCIAL MEDIA ANALYTICS");
		p2.assignSubject("BLOCKCHAIN");
		
		System.out.println("                  student data for a university   ");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-15s %-15s %-15s %-20s\n", "Name", "Department", "ID/Roll No", "Course/Subject");
		System.out.println("-----------------------------------------------------------------------");
		
		System.out.println(s1.getDetails());
		System.out.println(s2.getDetails());
		System.out.println("\n               professor data for a university   ");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-15s %-15s %-15s %-20s\n", "Name", "Department", "ID/Roll No", "Course/Subject");
		System.out.println("-----------------------------------------------------------------------");
//		System.out.println("Professor details");
		System.out.println(p1.getDetails());
		System.out.println(p2.getDetails());
		System.out.println();

		System.out.println("Total Students: " + Student.totalStudents);

		System.out.println("Total Courses: " + totalCourses);
		System.out.println("Total Professors: "+ Professors.totalprofessor);
		
	}
}


// mention core subject name also //
/*
 * 1 Design and implement a Java-based system to manage student and professor
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
