package com.aurionpro.model;

public class CommerceStudent extends Student {
    int accounts;  // Marks in Accounts, Business Studies, Economics
    int businessStudies;
    int economics;
    float average;

    public CommerceStudent(String name, int rollNumber, int accounts, int businessStudies, int economics) {
        super(name, rollNumber, "Commerce");
        this.accounts = accounts;
        this.businessStudies = businessStudies;
        this.economics = economics;
    }

    @Override  
    public void calculatePerformance() {
        average = (accounts + businessStudies + economics) / 3f;
        System.out.println("Average marks of " + name + " is: " + average);
        System.out.println("Grade: " + getGrade(average));
    }

    public void displayPerformance() {
        System.out.println("Performance: " + average);
    }

    public void displayPerformance(boolean detailed) {
        if (detailed) {
            System.out.println("Subjects: Accounts: " + accounts 
                + ", Business Studies: " + businessStudies 
                + ", Economics: " + economics);
        }
        System.out.println("Average: " + average + " Grade: " + getGrade(average));
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
