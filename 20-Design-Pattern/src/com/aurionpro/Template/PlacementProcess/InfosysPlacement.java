package com.aurionpro.Template.PlacementProcess;

public class InfosysPlacement extends PlacementProcess {

    @Override
    protected void collectStudentData() {
        System.out.println("Collecting student data for Infosys.");
    }

    @Override
    protected void scheduleInterviews() {
        System.out.println("Scheduling aptitude and technical interviews for Infosys.");
    }

    @Override
    protected void conductInterviews() {
        System.out.println("Conducting interviews for Infosys.");
    }

    @Override
    protected void announceResults() {
        System.out.println("Announcing placement results for Infosys.");
    }

    @Override
    protected void postPlacementFormalities() {
        System.out.println("Infosys requires a 1-year bond after placement.");
    }
}