package com.aurionpro.model;

public class PracticalExam implements IExamEvaluator {

    private int marks;

    public PracticalExam(int marks) {
        this.marks = marks;
    }

    @Override
    public void evaluateMarks() {
        System.out.println("Practical Exam Marks: " + marks);
        calculateGrade();
    }

    @Override
    public void calculateGrade() {
        if (marks >= 90)
            System.out.println("Grade: Excellent");
        else if (marks >= 75)
            System.out.println("Grade: Good");
        else if (marks >= 60)
            System.out.println("Grade: Satisfactory");
        else
            System.out.println("Grade: Needs Improvement");
    }
}
