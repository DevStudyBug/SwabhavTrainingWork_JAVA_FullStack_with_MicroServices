package com.aurionpro.enumeration.model;
//1. Traffic Light Simulation

//Task:
//Create an enum TrafficSignal { RED, YELLOW, GREEN } with a method getAction()
//that returns:
// RED → "Stop"
// YELLOW → "Get Ready"
// GREEN → "Go"
//Use a loop to display each signal and its action.

public class TrafficLightSimulation {
	public static void  getAction(TrafficSignal signal) {  
		switch(signal) {
		case RED:
			System.out.println("STOP!");
			break;
		case YELLOW:
			System.out.println("GET READY!!");
		case GREEN:
			System.out.println("GO>>");
		}
	}
	public static void main(String[] args) {
	getAction(TrafficSignal.RED);
}
}
