package com.aurionpro.SRP.Solution.PatientData.test;

import com.aurionpro.SRP.Solution.PatientData.model.Formating;
import com.aurionpro.SRP.Solution.PatientData.model.patientRecord;
import com.aurionpro.SRP.Solution.PatientData.model.sendEmail;
import com.aurionpro.SRP.Solution.PatientData.model.storePatientData;

public class patientTest {
public static void main(String[] args) {
	patientRecord patient = new patientRecord("Alok", "aloooobatata@gmail.com");
	storePatientData store = new storePatientData();
	store.store(patient);
	
	sendEmail email = new sendEmail();
	
	email.email(patient);
	
	Formating formate = new Formating();
	formate.formate(patient);
	
}
}


/*A PatientRecord class handles storing patient data, sending email notifications, and formatting records for printing. 

Task: Apply SRP by creating specialized classes for each responsibility.*/