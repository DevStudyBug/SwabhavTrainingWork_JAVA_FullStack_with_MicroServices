package com.aurionpro.SRP.Solution.PatientData.model;

public class sendEmail {
	public void email (patientRecord patient) {
		String patientemail = patient.getemail();
		System.out.println("Email send to patient Email id : "+ patientemail);
	}
}
//sending email notifications, 