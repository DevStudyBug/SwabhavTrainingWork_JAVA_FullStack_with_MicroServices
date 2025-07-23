package com.aurionpro.model;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
	LinkedHashMap <Integer, String> linked = new LinkedHashMap<>();
	
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		map.put(1, "Aloo");
		map.put(5, "Kanda");
		map.put(3, "Pyaj");
		map.put(4, "Bhindi");
		map.put(2, "Aloo");
		map.put(6, "tamatar");
		System.out.println(map);
		
		System.out.println(map.entrySet());
		System.out.println(map.getOrDefault(5, "Alooo"));
		System.out.println(map);
	}
}


