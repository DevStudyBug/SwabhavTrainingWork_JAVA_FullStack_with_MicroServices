package com.aurionpro.ISP.Solution.EducationalSoftware.model;

public class Teacher implements ITeacher {

	@Override
	public void gradeExam() {
		System.out.println("Grade student performance!");
		
	}

	@Override
	public void createQuestionBank() {
		System.out.println("Create question bank for upcoming exam!");
		
	}

}
