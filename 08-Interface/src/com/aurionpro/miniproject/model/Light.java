package com.aurionpro.miniproject.model;

public class  Light implements IControllable {
	public void turnOn() {
		System.out.println("Light turned ON");
	}

	public void setMode(String mode) {
		System.out.println("Light mode set to: " + mode);
	}

	public void turnOff() {
		System.out.println("Light turned OFF");

	}

	  public String[] getAvailableModes() {
	        return new String[] { "Bright", "Dim", "Night" };
	    }
}