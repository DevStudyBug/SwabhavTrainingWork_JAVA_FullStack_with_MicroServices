package assignment.week1.model;

public class Student {
	String name;
	int rollno;
	int subject1;
	int subject2;
	int subject3;
	
	public Student(String name, int rollno,int subject1,int subject2,int subject3) {
		this.name = name;
		this.rollno = rollno;
		this.subject1=subject1;
		this.subject2=subject2;
		this.subject3=subject3;
	}
	
	public void display() {
		System.out.println("Student Name : "+name+" Roll No. : "+rollno+" Marks : Subject 1:"+subject1+" Subject 2: "+subject2+" Subject 3: "+subject3);;
	}
}

