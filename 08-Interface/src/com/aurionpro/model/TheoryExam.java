package com.aurionpro.model;

public class TheoryExam implements IExamEvaluator {

    private int marks;

    public TheoryExam(int marks) {
        this.marks = marks;
    }

    @Override
    public void evaluateMarks() {
        System.out.println("Theory Exam Marks: " + marks);
        calculateGrade();
    }

    @Override
    public void calculateGrade() {
        if (marks >= 85)
            System.out.println("Grade: A");
        else if (marks >= 70)
            System.out.println("Grade: B");
        else if (marks >= 50)
            System.out.println("Grade: C");
        else
            System.out.println("Grade: Fail");
    }
}

