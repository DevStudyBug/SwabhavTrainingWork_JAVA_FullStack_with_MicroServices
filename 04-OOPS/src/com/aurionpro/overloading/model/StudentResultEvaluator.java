package com.aurionpro.overloading.model;
/*10. Student Result Evaluation System
Objective: Overload a method to evaluate student performance based on different criteria.
🔹 Requirements:
 Create a class StudentEvaluator with overloaded methods:
o evaluate(int marks)
o evaluate(int marks, int totalMarks)
o evaluate(String grade)
🧪 Logic:
 If marks ≥ 90, print "Excellent"
 In overloaded version with totalMarks, calculate percentage and return grade.
 If grade = "A", return "Very Good"; "B" = "Good"; else = "Needs Improvement"*/

public class StudentResultEvaluator {
	int marks, totalMarks;
	String grade;

	public void evaluate(int marks) {
		if(marks>=90) {
			System.out.println("Excellent! ");
		}
//		return marks;
	}

	public String evaluate(int marks, int totalMarks) {
		double percentage = (marks * 100.0) / totalMarks;
		 System.out.println("percent is : "+ percentage );
		if (percentage >= 90) {
            return "Grade A";
        } else if (percentage >= 75) {
            return "Grade B";
        } else if (percentage >= 50) {
            return "Grade C";
        } else {
            return "Grade D";
        } 
   
	}
	public String evaluate(String grade) {
        switch (grade) {
            case "A":
                return "Very Good";
            case "B":
                return "Good";
            default:
                return "Needs Improvement";
        }
    }

}
