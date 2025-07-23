package com.aurionpro.GuitarApp.Solution.model;

public enum Wood {
	INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;

	public String toString() {
		switch (this) {
		case ADIRONDACK:
			return "adirondack";
		case ALDER:
			return "alder";
		case BRAZILIAN_ROSEWOOD:
			return "brazilian_rosewood";
		case CEDAR:
			return "cedar";
		case COCOBOLO:
			return "cocobolo";
		case INDIAN_ROSEWOOD:
			return "indian_rosewood";
		case MAHOGANY:
			return "mahogany";
		case MAPLE:
			return "maple";
		case SITKA:
			return "sitka";
		default:
			return "";
		}
	}
}
