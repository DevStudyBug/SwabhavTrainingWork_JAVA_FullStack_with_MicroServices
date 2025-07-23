package com.aurionpro.DIP.Solution.Application.model;

public class MySQLDatabase  implements IDatabase{

	@Override
	public void connect() {
		System.out.println("Connected to MYSQL Database.....");
		
	}

}
