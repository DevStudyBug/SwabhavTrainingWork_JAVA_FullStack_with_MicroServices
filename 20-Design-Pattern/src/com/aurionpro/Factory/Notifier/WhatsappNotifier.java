package com.aurionpro.Factory.Notifier;

public class WhatsappNotifier implements INotifier {

	@Override
	public void send(String message) {
		System.out.println("Whatsapp\n "+ message);
		
	}

}
