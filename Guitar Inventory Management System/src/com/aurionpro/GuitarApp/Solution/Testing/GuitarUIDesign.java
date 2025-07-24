package com.aurionpro.GuitarApp.Solution.Testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.aurionpro.GuitarApp.Solution.model.Builder;
import com.aurionpro.GuitarApp.Solution.model.Guitar;
import com.aurionpro.GuitarApp.Solution.model.GuitarSpecs;
import com.aurionpro.GuitarApp.Solution.model.Inventory;
import com.aurionpro.GuitarApp.Solution.model.Type;
import com.aurionpro.GuitarApp.Solution.model.Wood;

public class GuitarUIDesign {

	public static void initializeInventory(Inventory inventory) {
		inventory.addGuitar("F001", 14999.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, 12, Wood.ALDER,
				Wood.ALDER);
		inventory.addGuitar("F002", 13999.95, Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6, Wood.MAPLE, Wood.ALDER);
		inventory.addGuitar("F003", 13499.95, Builder.FENDER, "Jazzmaster", Type.ELECTRIC, 6, Wood.MAPLE, Wood.CEDAR);
		inventory.addGuitar("G001", 15499.95, Builder.GIBSON, "Les Paul", Type.ELECTRIC, 6, Wood.MAHOGANY, Wood.MAPLE);
		inventory.addGuitar("G002", 16999.00, Builder.GIBSON, "Explorer", Type.ELECTRIC, 6, Wood.MAHOGANY,
				Wood.MAHOGANY);
		inventory.addGuitar("M001", 11999.00, Builder.MARTIN, "D-28", Type.ACOUSTIC, 6, Wood.BRAZILIAN_ROSEWOOD,
				Wood.ADIRONDACK);
		inventory.addGuitar("M002", 12499.00, Builder.MARTIN, "LX1", Type.ACOUSTIC, 6, Wood.MAPLE, Wood.CEDAR);
		inventory.addGuitar("C001", 13499.95, Builder.COLLINGS, "C10", Type.ACOUSTIC, 6, Wood.CEDAR, Wood.CEDAR);
		inventory.addGuitar("R001", 17499.00, Builder.RYAN, "Nightingale", Type.ACOUSTIC, 12, Wood.INDIAN_ROSEWOOD,
				Wood.SITKA);
		inventory.addGuitar("P001", 19999.00, Builder.PRS, "Custom 24", Type.ELECTRIC, 6, Wood.MAPLE, Wood.COCOBOLO);
	}

	public static List<Guitar> promptSearchFilters(Scanner scanner, Inventory inventory) {
		Builder builder = InputValidator.getEnumInput(scanner, Builder.values(), "Builder");

		Set<String> models = new TreeSet<>();
		for (Guitar g : inventory.getAllGuitars()) {
			models.add(g.getSpecs().getModel());
		}
		String model = InputValidator.getModelInput(scanner, new ArrayList<>(models));

		Type type = InputValidator.getEnumInput(scanner, Type.values(), "Type");
		Integer numStrings = InputValidator.getIntInput(scanner, "Number of Strings (6/10/12) or leave empty: ");
		Wood backWood = InputValidator.getEnumInput(scanner, Wood.values(), "Back Wood");
		Wood topWood = InputValidator.getEnumInput(scanner, Wood.values(), "Top Wood");

		GuitarSpecs filter = new GuitarSpecs(builder, model, type, numStrings != null ? numStrings : -1, backWood,
				topWood);
		return GuitarSearchService.search(filter, inventory.getAllGuitars());
	}

	public static void displayGuitars(List<Guitar> guitars) {
		GuitarPrinter.printGuitars(guitars);
	}

	public static void promptAddGuitar(Scanner scanner, Inventory inventory) {
		System.out.print("Enter Serial Number: ");
		String serialNumber = scanner.nextLine().trim();

		System.out.print("Enter Price: ");
		double price = Double.parseDouble(scanner.nextLine().trim());

		System.out.print("Enter Builder (e.g., FENDER, MARTIN, GIBSON): ");
		Builder builder = Builder.valueOf(scanner.nextLine().trim().toUpperCase());

		System.out.print("Enter Model: ");
		String model = scanner.nextLine().trim();

		System.out.print("Enter Type (e.g., ACOUSTIC, ELECTRIC): ");
		Type type = Type.valueOf(scanner.nextLine().trim().toUpperCase());

		System.out.print("Enter Number of Strings: ");
		int numStrings = Integer.parseInt(scanner.nextLine().trim());

		System.out.print("Enter Back Wood (e.g., MAPLE, ROSEWOOD): ");
		Wood backWood = Wood.valueOf(scanner.nextLine().trim().toUpperCase());

		System.out.print("Enter Top Wood (e.g., MAPLE, ROSEWOOD): ");
		Wood topWood = Wood.valueOf(scanner.nextLine().trim().toUpperCase());

		inventory.addGuitar(serialNumber, price, builder, model, type, numStrings, backWood, topWood);
		System.out.println("\n✅ Guitar successfully added to inventory.");

	}
}
