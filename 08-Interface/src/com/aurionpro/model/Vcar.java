package com.aurionpro.model;

public class Vcar implements IVehicleControl {
	private final int MAX_GEAR = 6;

	@Override
	public void start() {
		System.out.println("Car is starting with key.");
	}

	@Override
	public void stop() {
		System.out.println("Car is stopping with brakes.");
	}

	@Override

	public void changeGear(int gear) {
		if (gear >= 0 && gear <= MAX_GEAR) {
			System.out.println("Car gear changed to: " + gear);
		} else {
			System.out.println("Invalid gear! car supports gears 0 to " + MAX_GEAR);
		}
	}
}