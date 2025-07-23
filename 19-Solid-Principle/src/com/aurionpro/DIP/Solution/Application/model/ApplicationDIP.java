package com.aurionpro.DIP.Solution.Application.model;

public class ApplicationDIP {
	private IDatabase databse; // dependency injection
	public ApplicationDIP(IDatabase data) {
		this.databse=data;
	}
	
	public void start() {
		databse.connect();
	}
}
