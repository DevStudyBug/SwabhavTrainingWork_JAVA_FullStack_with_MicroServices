package com.aurionpro.Template.PlacementProcess;

public class AurionproPlacementProcess  extends PlacementProcess {

    @Override
    protected void collectStudentData() {
        System.out.println("Collecting student profiles for Aurionpro assessment...");
    }

    @Override
    protected void scheduleInterviews() {
        System.out.println("Scheduling coding test and technical rounds for Aurionpro...");
    }

    @Override
    protected void conductInterviews() {
        System.out.println("Conducting 1 technical + 1 manageral + 1 HR interview (Aurionpro)...");
    }

    @Override
    protected void announceResults() {
        System.out.println("Publishing Aurionpro selection list...");
    }

    @Override
    protected void postPlacementFormalities() {
        System.out.println("Aurionpro requires a 2-year bond to be signed after placement");
    }
}
