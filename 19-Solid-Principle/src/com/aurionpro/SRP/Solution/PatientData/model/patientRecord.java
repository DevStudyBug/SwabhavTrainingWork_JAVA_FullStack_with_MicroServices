package com.aurionpro.SRP.Solution.PatientData.model;

public class patientRecord {
	private String patientName;
	private String emailId;
	
	public patientRecord(String name,String email) {
		this.patientName = name;
		this.emailId = email;
	}
	public String getname() {
		return patientName;
	}
	public String getemail() {
		return emailId;
	}
}

//A PatientRecord class handles storing patient data, 
//sending email notifications, 
//and formatting records for printing. 
//
//Task: Apply SRP by creating specialized classes for each responsibility.