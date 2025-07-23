package com.aurionpro.miniproject.model;

public class Speaker implements IControllable {
    public void turnOn() {
        System.out.println("Speaker turned ON");
    }

    public void setMode(String mode) {
        System.out.println("Speaker mode set to: " + mode);
    }

    public void turnOff() {
        System.out.println("Speaker turned OFF");
    }
    
    public String[] getAvailableModes() {
        return new String[] { "Bass", "Treble", "Normal" };
    }

}
