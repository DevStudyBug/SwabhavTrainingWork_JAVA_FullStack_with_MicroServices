package com.aurionpro.model;

public class OnlineQuiz implements IExamEvaluator {

    private int marks;

    public OnlineQuiz(int marks) {
        this.marks = marks;
    }

    @Override
    public void evaluateMarks() {
        System.out.println("Online Quiz Marks: " + marks);
        calculateGrade();
    }

    @Override
    public void calculateGrade() {
        if (marks >= 80)
            System.out.println("Grade: Pass");
        else
            System.out.println("Grade: Fail");
    }
}