package com.aurionpro.SRP.Solution.PatientData.model;

public class Formating {
public void formate(patientRecord patient) {
	String name = patient.getname();
	String patientemail = patient.getemail();
	System.out.println("\n------Patient Record---------\n");
	System.out.println("Patient Name: "+ name);
	System.out.println("Patient Email Id: "+ patientemail);
}
}
