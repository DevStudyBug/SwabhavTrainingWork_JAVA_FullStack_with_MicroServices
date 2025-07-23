package com.aurionpro.GuitarApp.Solution.model;

public enum Builder {
	FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

	public String toString() {
		switch (this) {
		case FENDER:
			return "fender";
		case ANY:
			return "any";
		case COLLINGS:
			return "collings";
		case GIBSON:
			return "gibson";
		case MARTIN:
			return "martin";
		case OLSON:
			return "olson";
		case PRS:
			return "prs";
		case RYAN:
			return "ryan";
		default:
			return "";

		}
	}
}
