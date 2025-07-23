package com.aurionpro.ISP.Solution.Worker.model;

public class Labour implements IWorkable,ILunchInterval{

	@Override
	public void eat() {
		System.out.println("Eat");
		
	}

	@Override
	public void rest() {
		System.out.println("Rest");
		
	}

	@Override
	public void start() {
		System.out.println("labour Start");
	}

	@Override
	public void stop() {
		System.out.println("labour Stop");
		
	}

}
