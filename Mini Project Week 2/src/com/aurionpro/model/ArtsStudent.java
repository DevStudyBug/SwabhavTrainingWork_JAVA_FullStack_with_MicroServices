package com.aurionpro.model;

public class ArtsStudent extends Student {
	//marks in History, Political Science, Sociology
	int history;
	int politicalScience;
	int sociology;
	float average;
	public ArtsStudent(String name, int rollNumber,int history,int politicalScience,int sociology){
		super(name,rollNumber,"Arts");
		this.history = history;
		this.politicalScience = politicalScience;
		this.sociology = sociology;
	}
	
	@Override  
	 public void calculatePerformance(){
		average = (history+politicalScience+sociology) / 3f ;
		System.out.println("Average marks of "+ name+ ", is :"+average);
		System.out.println("Grade: " + getGrade(average));
    }

    public void displayPerformance() {
        System.out.println("Performance: " + average);
    }

    public void displayPerformance(boolean detailed) {
        if (detailed) {
        	 System.out.println("Subjects: History: " + history + ", Political Science: " + politicalScience + ", Sociology: " + sociology);
        }
        System.out.println("Average: " + average + " | Grade: " + getGrade(average));
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
