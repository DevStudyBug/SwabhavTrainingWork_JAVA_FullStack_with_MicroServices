package com.aurionpro.miniproject.model;

public class TV implements IControllable {
    public void turnOn() {
        System.out.println("TV turned ON");
    }

    public void setMode(String mode) {
        System.out.println("TV mode set to: " + mode);
    }

    public void turnOff() {
        System.out.println("TV turned OFF");
    }
    public String[] getAvailableModes() {
        return new String[] { "HD", "4K", "Cinema", "Sports" };
    }


}
