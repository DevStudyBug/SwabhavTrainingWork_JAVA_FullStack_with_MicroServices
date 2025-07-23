package com.aurionpro.Singleton.ElectricityBoard;

public class EBOfficeTest {
	public static void main(String[] args) {
		 // Getting singleton instance
		 ElectricityBoard eb1 = ElectricityBoard.getInstance();
		 eb1.giveConnection("House A");
		 // Getting same singleton instance again
		 ElectricityBoard eb2 = ElectricityBoard.getInstance();
		 eb2.giveConnection("House B");

		 ElectricityBoard eb3 = ElectricityBoard.getInstance();
		 eb3.giveConnection("House C");

		 ElectricityBoard eb4 = ElectricityBoard.getInstance();
		 eb4.giveConnection("House D");

		 ElectricityBoard eb6 = ElectricityBoard.getInstance();
		 eb6.giveConnection("House E");

		 ElectricityBoard eb7 = ElectricityBoard.getInstance();
				 eb7.giveConnection("House F");
		 // Displaying connections from either object (same instance)
		 eb4.showConnections();
		 // Display total connections
		 System.out.println("Total Connections: " + eb2.getTotalConnections());
		// Verifying if both references are same
		 System.out.println("Same instance? " + (eb1 == eb2)); // Output: true
		 }
		}
	
