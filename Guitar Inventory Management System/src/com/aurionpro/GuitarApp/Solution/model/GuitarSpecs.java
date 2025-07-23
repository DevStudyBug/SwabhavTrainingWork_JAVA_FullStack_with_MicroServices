package com.aurionpro.GuitarApp.Solution.model;

public class GuitarSpecs {
	private Builder builder;
	private String model;
	private Type type;
	private Wood backwood;
	private Wood topwood;
	private int numStrings;

	public GuitarSpecs(Builder builder, String model, Type type, int numStrings, Wood backwood, Wood topwood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.numStrings = numStrings;
		this.backwood = backwood;
		this.topwood = topwood;
	}

	public Builder getBuilder() {
		return builder;
	}

	public String getModel() {
		return model;
	}

	public Type getType() {
		return type;
	}

	public int getNumStrings() {
		return numStrings;
	}

	public Wood getBackwood() {
		return backwood;
	}

	public Wood getTopwood() {
		return topwood;
	}

	public boolean matches(GuitarSpecs otherSpec) {
		if (builder != otherSpec.builder)
			return false;

		if ((model != null) && (!model.equals("")) && (!model.equalsIgnoreCase(otherSpec.model)))
			return false;

		if (type != otherSpec.type)
			return false;

		if (numStrings != otherSpec.numStrings)
			return false;

		if (backwood != otherSpec.backwood)
			return false;

		if (topwood != otherSpec.topwood)
			return false;
		return true;
	}
}