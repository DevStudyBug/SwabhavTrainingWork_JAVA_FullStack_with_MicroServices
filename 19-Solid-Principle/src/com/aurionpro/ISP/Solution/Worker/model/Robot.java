package com.aurionpro.ISP.Solution.Worker.model;

public class Robot implements IWorkable{

	@Override
	public void start() {
		System.out.println("Robot Start");	
	}

	@Override
	public void stop() {
System.out.println("Robot Stop");
	}

}
