package com.aurionpro.DIP.Solution.Application.model;

public class Cloud implements IDatabase{

	@Override
	public void connect() {
		System.out.println("Connected to cloud .....");
		
	}

}
