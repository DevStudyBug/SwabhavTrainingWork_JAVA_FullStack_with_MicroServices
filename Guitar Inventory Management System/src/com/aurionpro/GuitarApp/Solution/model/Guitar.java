package com.aurionpro.GuitarApp.Solution.model;

public class Guitar {
	private String serialNumber;
	private double price;
//	private Builder builder ;
//	private String model;
//	private Type type;
//	private Wood backwood ;
//	private Wood topwood;
	private GuitarSpecs specs;

//	public Guitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backwood,
//			Wood topwood)
	public Guitar(String serialNumber, double price, GuitarSpecs specs) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.specs = specs;
//		this.builder = builder;
//		this.model = model;
//		this.type = type;
//		this.backwood = backwood;
//		this.topwood = topwood;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public double getPrice() {
		return price;
	}

	public GuitarSpecs getSpecs() {
		return specs;
	}
//	public Builder getBuilder() {
//		return builder;
//	}
//	
//	public String getModel() {
//		return model;
//	}
//	
//	public Type getType() {
//		return type;
//	}
//	
//	public Wood getBackwood() {
//		return backwood;
//	}
//	
//	public Wood getTopwood() {
//		return topwood;
//	}	
}
