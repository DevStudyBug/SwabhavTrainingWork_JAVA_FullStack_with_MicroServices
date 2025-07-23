package com.aurionpro.Template.PlacementProcess;

public class TCSPlacement extends PlacementProcess {
	    @Override
	    protected void collectStudentData() {
	        System.out.println("Collecting student data for TCS.");
	    }

	    @Override
	    protected void scheduleInterviews() {
	        System.out.println("Scheduling aptitude and technical interviews for TCS.");
	    }

	    @Override
	    protected void conductInterviews() {
	        System.out.println("Conducting interviews for TCS.");
	    }

	    @Override
	    protected void announceResults() {
	        System.out.println("Announcing placement results for TCS.");
	    }

	    @Override
	    protected void postPlacementFormalities() {
	        System.out.println("TCS requires a 1-year service agreement to be signed.");
	    }
	}

