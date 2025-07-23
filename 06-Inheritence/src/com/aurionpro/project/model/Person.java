package com.aurionpro.project.model;

public class Person {
 String name;
 Departments department;
 public Person(String name, Departments department) {
	 this.name = name;
     this.department = department;
 }
 public String getDetails() {
     return "Name: " + name + ", Department: " + department;
 }

}
//1. Design and implement a Java-based system to manage student and professor data for a university. Each student should have details like name, roll number, department, and enrolled courses. Professors should have name, ID, department, and assigned subjects.
//
//The system should:
//
//Maintain a count of total students and courses (using static).
//
//Use enums to define departments and course types (CORE, ELECTIVE).
//
//Allow methods like enrollCourse() for students and assignSubject() for professors.
//
//Demonstrate inheritance using a Person base class and subclasses Student and Professor.
//
//Use polymorphism to override a method like getDetails() in each subclass.