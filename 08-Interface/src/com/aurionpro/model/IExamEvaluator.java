package com.aurionpro.model;

public interface IExamEvaluator {
	void evaluateMarks();
	void calculateGrade();
}
//4. Education/Exam System
//Problem:
//Define an interface ExamEvaluator with methods: evaluateMarks(), calculateGrade().
//Implement for different types of exams: TheoryExam, PracticalExam, and OnlineQuiz.
//Each class uses different grading logic. Write a class that prints the evaluated result using
//interface reference.