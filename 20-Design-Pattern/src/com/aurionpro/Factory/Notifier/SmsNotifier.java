package com.aurionpro.Factory.Notifier;

public class SmsNotifier implements INotifier {

	@Override
	public void send(String message) {
System.out.println("SMS \n"+ message);		
	}

}
