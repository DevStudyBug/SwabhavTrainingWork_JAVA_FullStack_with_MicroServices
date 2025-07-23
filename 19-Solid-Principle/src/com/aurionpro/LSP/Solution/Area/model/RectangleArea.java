package com.aurionpro.LSP.Solution.Area.model;

public class RectangleArea implements IShape {
	protected double length;
	protected double breadth;

	public RectangleArea(double length, double breadth) {
		this.length = length;
		this.breadth = breadth;
	}

	public double getLength() {
		return length;
	}

	public double getBreadth() {
		return breadth;
	}

	@Override
	public double getArea() {
		return length * breadth;
	}
}
