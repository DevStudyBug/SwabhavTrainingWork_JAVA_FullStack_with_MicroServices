package com.aurionpro.model;

public class Plugin {
	private double version;
	private Plugin() {
		
	}
	public void execute() {
		System.out.println("Plugin Executed!");
	}
}

//**Task:**
//Create a class Plugin with:
//- Private field version
//- Private constructor
//- Public method execute() prints "Plugin executed"
//
//Use reflection to:
//- Access private constructor
//- Set version = 3.1
//- Call execute()
//- Print version

