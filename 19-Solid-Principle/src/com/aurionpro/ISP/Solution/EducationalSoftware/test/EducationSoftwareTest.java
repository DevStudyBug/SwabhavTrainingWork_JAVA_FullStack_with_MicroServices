package com.aurionpro.ISP.Solution.EducationalSoftware.test;

import com.aurionpro.ISP.Solution.EducationalSoftware.model.Admin;
import com.aurionpro.ISP.Solution.EducationalSoftware.model.Student;
import com.aurionpro.ISP.Solution.EducationalSoftware.model.Teacher;

public class EducationSoftwareTest {
public static void main(String[] args) {
System.out.println("-------Admin-------");
	Admin a = new Admin();
	a.assignTeacher();
	System.out.println("\n-------Teacher------");
	Teacher t = new Teacher();
	t.createQuestionBank();
	t.gradeExam();
	System.out.println("\n-------Student--------");
	Student s = new Student();
	s.startExam();


}
}
