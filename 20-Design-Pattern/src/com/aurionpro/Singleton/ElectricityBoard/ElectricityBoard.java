package com.aurionpro.Singleton.ElectricityBoard;

import java.util.ArrayList;
import java.util.List;

public class ElectricityBoard {
	// Step1: Creating Static instance of the class (Singleton instance)
	private static ElectricityBoard instance;
	// List to store connected Houses Name;
	private List<String> connectedHouses;
	// Step2: Private constructor so no one else can create an object
	private ElectricityBoard() {
	connectedHouses = new ArrayList<>();
	System.out.println("Electricity Board Office Created");
}
	// Step3:Public method to provide global access point (Thread-safe)
	public static synchronized ElectricityBoard getInstance() {
	if (instance == null) {
	instance = new ElectricityBoard();
	}
	return instance;
	}
	// Method to give connection to a house
	public void giveConnection(String houseName) {
	connectedHouses.add(houseName);
	System.out.println("Connection given to: " + houseName);
	}
	// Method to show all connected houses
	public void showConnections() {
	System.out.println("Connected Houses: " + connectedHouses);
	}
	// Method to return total number of connections
	public int getTotalConnections() {
	return connectedHouses.size();
	}
	}
