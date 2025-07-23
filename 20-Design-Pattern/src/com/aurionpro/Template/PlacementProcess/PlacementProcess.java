package com.aurionpro.Template.PlacementProcess;

public abstract class PlacementProcess {
	// Template Method
    public final void conductPlacement() {
        collectStudentData();
        scheduleInterviews();
        conductInterviews();
        announceResults();
        postPlacementFormalities();
    }

    protected abstract void collectStudentData();
    protected abstract void scheduleInterviews();
    protected abstract void conductInterviews();
    protected abstract void announceResults();
    protected abstract void postPlacementFormalities();
}
