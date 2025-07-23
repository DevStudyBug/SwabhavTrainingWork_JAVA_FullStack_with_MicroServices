package com.aurionpro.Singleton.SmartTV;

public class SmartTV {

	private static SmartTV instance;
	 private boolean isOn = false;
	 private int volume = 10;
	 private SmartTV() {
	 System.out.println("Smart TV Created");
	 }
	 public static SmartTV getInstance() {
	 if (instance == null) {
	 instance = new SmartTV();
	 }
	 return instance;
	 }
	 public void powerToggle() {
		 if (isOn == false) {
		 isOn = true;
		 System.out.println("TV is now ON");
		 } else {
		 isOn = false;
		 System.out.println("TV is now OFF");
		 }
		 }

		 public void increaseVolume() {
		 if (isOn == true) {
		 volume = volume + 1;
		 System.out.println("Volume increased to: " + volume);
		 } else {
		 System.out.println("TV is OFF. Please turn it ON first.");
		 }
		 }
		 public void decreaseVolume() {
			 if (isOn == true) {
			 volume = volume - 1;
			 System.out.println("Volume decreased to: " + volume);
			 } else {
			 System.out.println("TV is OFF. Please turn it ON first.");
			 }
			 }
			}

