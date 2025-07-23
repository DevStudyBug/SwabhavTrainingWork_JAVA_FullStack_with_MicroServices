package com.aurionpro.model;

public class Vtruck implements IVehicleControl {

    @Override
    public void start() {
        System.out.println("Truck is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Truck is stopping using brakes.");
    }

    @Override
    public void changeGear(int gear) {
        System.out.println("Truck gear changed to: " + gear);
    }
}
