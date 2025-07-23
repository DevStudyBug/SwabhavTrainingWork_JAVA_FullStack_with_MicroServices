package com.project1.model;

public class ScienceStudent extends Student {
    int phyMarks;
    int chemMarks;
    int mathsMarks;
    
    public ScienceStudent(int rollNumber, String name, int phyMarks, int chemMarks, int mathsMarks) {
        super(rollNumber, name);
        this.phyMarks = phyMarks;
        this.chemMarks = chemMarks;
        this.mathsMarks = mathsMarks;
    }
    
    @Override
    public void CalculateGrade() {
        float average = (phyMarks + chemMarks + mathsMarks) / 3.0f;
        
        System.out.println("Average marks of " + name + " is: " + average);
        
        if (average > 90) {
            System.out.println("Grade A");
        } else if (average > 70) {
            System.out.println("Grade B");
        } else if (average > 50) {
            System.out.println("Grade C");
        } else {
            System.out.println("Grade F");
        }
    }
}
