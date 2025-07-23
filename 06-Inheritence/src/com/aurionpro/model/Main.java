package com.aurionpro.model;

public class Main {
	public static void main(String[] args) {
		subclassSuperclass superclass = new Subclass();
		subclassSuperclass supercl = new subclassSuperclass();
		superclass.Display();
		superclass.Display("anshika");
		supercl.Display();
	}
}
