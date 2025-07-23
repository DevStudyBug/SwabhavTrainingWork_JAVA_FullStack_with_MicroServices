package com.aurionpro.Template.PlacementProcess;

public class Main {

	public static void main(String[] args) {

		PlacementProcess aurionpro = new AurionproPlacementProcess();
		aurionpro.conductPlacement();
		System.out.println("\n-----------------------------\n");
		PlacementProcess infosys = new InfosysPlacement();
		infosys.conductPlacement();

		System.out.println("\n-----------------------------\n");

		PlacementProcess tcs = new TCSPlacement();
		tcs.conductPlacement();

		System.out.println("\n-----------------------------\n");

	}
}