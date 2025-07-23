package com.aurionpro.test;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.aurionpro.model.IExamEvaluator;
import com.aurionpro.model.TheoryExam;
import com.aurionpro.model.PracticalExam;
import com.aurionpro.model.OnlineQuiz;

public class EducationExamSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        IExamEvaluator evaluator;
        int choice = 0;

        System.out.println("----- Welcome to Education Exam System -----");

        do {
            try {
                System.out.println("\nChoose Exam Type:");
                System.out.println("1. Theory Exam");
                System.out.println("2. Practical Exam");
                System.out.println("3. Online Quiz");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Marks for Theory Exam (0-100): ");
                        int theoryMarks = getValidMarks(sc);
                        evaluator = new TheoryExam(theoryMarks);
                        evaluator.evaluateMarks();
                        break;

                    case 2:
                        System.out.print("Enter Marks for Practical Exam (0-100): ");
                        int practicalMarks = getValidMarks(sc);
                        evaluator = new PracticalExam(practicalMarks);
                        evaluator.evaluateMarks();
                        break;

                    case 3:
                        System.out.print("Enter Marks for Online Quiz (0-100): ");
                        int quizMarks = getValidMarks(sc);
                        evaluator = new OnlineQuiz(quizMarks);
                        evaluator.evaluateMarks();
                        break;

                    case 4:
                        System.out.println("Thank you for using Education Exam System!");
                        break;

                    default:
                        System.out.println("Invalid Choice! Please select 1, 2, 3, or 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numeric values only.");
                sc.nextLine(); 
            }
        } while (choice != 4);

        sc.close();
    }

  
    private static int getValidMarks(Scanner sc) {
        int marks = -1; //dummy or starting value
        while (true) {
            try {
                marks = sc.nextInt();
                if (marks < 0 || marks > 100) {
                    throw new IllegalArgumentException("Marks must be between 0 and 100.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Please enter numeric marks (0-100): ");
                sc.nextLine(); 
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage() + " Please re-enter: ");
            }
        }
        return marks;
    }
}

//4. Education/Exam System
//Problem:
//Define an interface ExamEvaluator with methods: evaluateMarks(), calculateGrade().
//Implement for different types of exams: TheoryExam, PracticalExam, and OnlineQuiz.
//Each class uses different grading logic. Write a class that prints the evaluated result using
//interface reference.