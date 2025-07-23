package com.project1.model;

public class CommerceStudent extends Student {
	int accounts;
	int ecnomics;
	int buisness;
	
	public CommerceStudent(int rollNumber, String name, int accounts, int ecnomics, int buisness) {
		super(rollNumber, name);
		this.accounts=accounts;
		this.ecnomics=ecnomics;
		this.buisness=buisness;
	}
	
	@Override  
	 public void CalculateGrade(){
		float average = (accounts+ecnomics+buisness)/3.0f ;
		System.out.println("Average marks of "+ name+ ", is :"+average);
		if(average>90) {
			System.out.println("Grade A");
		}else if (average >70) {
			System.out.println("Grade B");	
		}else if (average >50) {
			System.out.println("Grade C");
		}else {
			System.out.println("Grade F");
		}
	}
}
