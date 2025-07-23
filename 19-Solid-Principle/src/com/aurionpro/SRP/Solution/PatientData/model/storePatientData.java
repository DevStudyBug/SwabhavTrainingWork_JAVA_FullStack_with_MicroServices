package com.aurionpro.SRP.Solution.PatientData.model;

public class storePatientData {
	public void store (patientRecord patient) {
		String name = patient.getname();
		String patientemail = patient.getemail();
//		System.out.println("name: "+ name+", Email Id: "+ patientemail);
		System.out.println("patient "+name+ "'s data store Successfully!");
	}
}
