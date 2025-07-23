package com.aurionpro.model;

public class ScienceStudent extends Student {

    int physicsMarks;
    int chemistryMarks;
    int mathsMarks;
    float average;

    public ScienceStudent(String name, int rollNumber, int physicsMarks, int chemistryMarks, int mathsMarks) {
        super(name, rollNumber, "Science");
        this.physicsMarks = physicsMarks;
        this.chemistryMarks = chemistryMarks;
        this.mathsMarks = mathsMarks;
    }

    @Override
    public void calculatePerformance() {
        average = (physicsMarks + chemistryMarks + mathsMarks) / 3f;

        System.out.println("Average marks of " + name + " is: " + average);
        System.out.println("Grade: " + getGrade(average));
    }

//    private String getGrade() {
//        if (average > 90)
//            return "A";
//        else if (average > 70)
//            return "B";
//        else if (average > 50)
//            return "C";
//        else
//            return "F";
//    }

    public void displayPerformance() {
        System.out.println("Performance: " + average);
    }

    public void displayPerformance(boolean detailed) {
        if (detailed) {
            System.out.println("Subjects Marks: Physics: " + physicsMarks + ", Chemistry: " + chemistryMarks + ", Math: " + mathsMarks);
        }
        System.out.println("Average: " + average + ", Grade: " + getGrade(average));
    }
    public void displayPerformance(String format) {
        if (format.equalsIgnoreCase("percentage")) {
            System.out.println("Performance Percentage: " + average);
        } else if (format.equalsIgnoreCase("grade")) {
            System.out.println("Performance Grade: " + getGrade(average));
        } else {
            System.out.println("Invalid format. Use 'percentage' or 'grade'.");
        }
    }
    
    
}