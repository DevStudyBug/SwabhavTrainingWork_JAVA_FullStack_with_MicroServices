package com.aurionpro.GuitarApp.Solution.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private List<Guitar> guitars;
	
	public Inventory() {
		guitars = new LinkedList<Guitar>();
	}
	
	public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type,int numStrings, Wood backwood,
			Wood topwood) {
		GuitarSpecs specs = new GuitarSpecs(builder, model, type, numStrings, backwood, topwood);
		Guitar guitar = new Guitar (serialNumber, price, specs);
		guitars.add(guitar);
	}
	public Guitar getGuitar(String serial) {
		for (Guitar guitar : guitars) {
			if(guitar.getSerialNumber().equals(serial)) {
		return guitar;
		}
		}
		return null;
	}
	public List<Guitar> search(GuitarSpecs searchSpecs){
		List<Guitar> matchingGuitars = new LinkedList<Guitar>() ;
			for (Iterator<Guitar> i = guitars.iterator(); i.hasNext();)
			{
				Guitar guitar =(Guitar)i.next();
				if(guitar.getSpecs().matches(searchSpecs))
					matchingGuitars.add(guitar);
				
				GuitarSpecs guitarSpecs = guitar.getSpecs();
				
				//created matches method in guitarspecs
//				if(searchSpecs.getBuilder()!= guitarSpecs.getBuilder())
//					continue;
//				// for string model
//				String model = searchSpecs.getModel();
//				if((model!=null)&& (!model.equals(""))&&
//						(!model.equals(guitarSpecs.getModel())))
//					continue;
//				if(searchSpecs.getType()!= guitarSpecs.getType())
//					continue;
//				if(searchSpecs.getBackwood()!= guitarSpecs.getBackwood())
//					continue;
//				if(searchSpecs.getTopwood()!= guitarSpecs.getTopwood())
//					continue;
//				matchingGuitars.add(guitar);
			}
			return matchingGuitars;
	}

	public List<Guitar> getAllGuitars() {
	
		return guitars;
	}
}
