package com.aurionpro.model;

public class Vbike implements IVehicleControl {

    @Override
    public void start() {
        System.out.println("Bike is starting with kickstart.");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping with brakes.");
    }

    @Override
    public void changeGear(int gear) {
        System.out.println("Bike gear changed to: " + gear);
    }
}
