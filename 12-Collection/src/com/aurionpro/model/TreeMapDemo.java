package com.aurionpro.model;

import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {
		TreeMap<Integer , String > map = new TreeMap<>();
		map.put(1, "kajal");
		map.put(2, "Sheetal");
		map.put(3, "Bhupali");
		map.put(4, "Anshika");
		
		System.out.println(map);
		
		
		System.out.println("higher key "+map.higherKey(1));
		System.out.println("Lower key "+ map.lowerKey(4));
		
		System.out.println("Ceiling "+ map.ceilingKey(2));
		System.out.println("Floor "+ map.floorKey(2));
	
	
	}
}
