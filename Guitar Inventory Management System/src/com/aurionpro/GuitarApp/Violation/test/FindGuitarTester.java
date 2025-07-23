package com.aurionpro.GuitarApp.Violation.test;

import com.aurionpro.GuitarApp.Violation.model.Guitar;
import com.aurionpro.GuitarApp.Violation.model.Inventory;

public class FindGuitarTester {
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		initializeInventory(inventory);

		Guitar whatErinLikes = new Guitar("", 0, "Fender", "Stratocastor", "electric", "Alder", "Alder");

		Guitar guitar = inventory.search(whatErinLikes);
		if (guitar != null) {
			System.out.println("Erin, you might like this " + guitar.getBuilder() + " " + guitar.getModel() + " "
					+ guitar.getType() + " guitar:\n" + guitar.getBackWood() + " back and sides,\n"
					+ guitar.getTopWood() + " top.\nYou can have it for ₹" + guitar.getPrice() + "!");
		} else {
			System.out.println("Sorry, Erin, we have nothing for you.");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		inventory.addGuitar("11277", 39999.95, "fender", "stratocastor", "electric", "alder", "alder"); // Note: all
																										// lowercase

		inventory.addGuitar("V95693", 14999.95, "Gibson", "Les Paul", "electric", "Mahogany", "Maple");
		inventory.addGuitar("70108276", 22999.95, "Gibson", "SG", "electric", "Mahogany", "Mahogany");
	}
}