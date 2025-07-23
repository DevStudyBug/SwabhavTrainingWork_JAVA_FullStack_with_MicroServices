package com.aurionpro.Singleton.SmartTV;

public class SmartTVTest {
	public static void main(String[] args) {

		SmartTV controller1 = SmartTV.getInstance();
		controller1.powerToggle();
		controller1.increaseVolume();

		SmartTV controller2 = SmartTV.getInstance();
		controller2.increaseVolume();
		controller2.decreaseVolume();

		if (controller1 == controller2) {
			System.out.println("Both controllers are using the same Smart TV");
		} else {
			System.out.println("Different TV objects! Not a singleton!");
		}
	}
}