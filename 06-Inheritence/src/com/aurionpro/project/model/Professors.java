package com.aurionpro.project.model;

public class Professors extends Person {
    int id;
	    String subject;
	    public static  int totalprofessor;
	    public Professors(String name, Departments department, int id) {
	        super(name, department);
	        this.id = id;
	        
			totalprofessor++;
	    }

	    public void assignSubject(String subject) {
	        this.subject = subject;
	    }

	    @Override
	    public String getDetails() {
	        return String.format("%-15s %-15s %-15d %-20s", name, department, id, subject);
	    }

	}


