package com.aurionpro.miniproject.model;

public interface IControllable {
	void turnOn();
	void turnOff();
	void setMode(String mode);
	String[] getAvailableModes();


}
