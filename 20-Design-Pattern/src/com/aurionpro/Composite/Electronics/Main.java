package com.aurionpro.Composite.Electronics;

public class Main {
	public static void main(String[] args) {
		// Leaf Parts
		Part mouse = new Part("Mouse", 500);
		Part keyboard = new Part("Keyboard", 1000);
		Part ram = new Part("RAM", 4000);
		Part motherboard = new Part("Motherboard", 7000);
		Part ssd = new Part("SSD", 3000);

		// Composite: Peripherals
		CompositePart peripherals = new CompositePart("Peripherals");
		peripherals.addComponent(mouse);
		peripherals.addComponent(keyboard);

		// Composite: Core Components
		CompositePart coreComponents = new CompositePart("Core Components");
		coreComponents.addComponent(ram);
		coreComponents.addComponent(motherboard);
		coreComponents.addComponent(ssd);

		// Top-Level Composite: Computer
		CompositePart computer = new CompositePart("Computer");
		computer.addComponent(coreComponents);
		computer.addComponent(peripherals);
		System.out.println("=== Single Part ===");
		mouse.showDetails();
		System.out.println("\n=== Peripherals ===");
		peripherals.showDetails();
		System.out.println("\n=== Core Components ===");
		coreComponents.showDetails();
		System.out.println("\n=== Full Computer Build ===");
		computer.showDetails();
	}
}
