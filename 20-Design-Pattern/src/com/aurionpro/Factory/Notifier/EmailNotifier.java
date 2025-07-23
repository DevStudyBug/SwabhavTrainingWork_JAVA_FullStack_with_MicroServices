package com.aurionpro.Factory.Notifier;

public class EmailNotifier implements INotifier{

	@Override
	public void send(String message) {
		System.out.println("Email \n"+ message);
		
	}

}
