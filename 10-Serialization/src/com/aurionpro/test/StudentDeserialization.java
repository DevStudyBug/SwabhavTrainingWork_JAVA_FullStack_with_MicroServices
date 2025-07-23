package com.aurionpro.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.aurionpro.model.Student;

public class StudentDeserialization {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		 ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"));
		    Student student = (Student) in.readObject();
		    in.close();
		    System.out.println("Student object restored");
		    student.display();
	}
}
