package com.aurionpro.model;

import java.util.Collections;
import java.util.Hashtable;

public class HashTable {
	public static void main(String[] args) {
		Hashtable<Integer , String> t = new Hashtable<>();
		//put
		t.put(1, "Anshika");
		t.put(2,"Amit " );
		t.put(3, "sheetal");
		t.put(4 , "Alok");
		System.out.println(t);
		
		//get
		System.out.println("value at key 3 "+ t.get(3));

		//remove
		System.out.println(t.remove(4));
		
		//remove both 
		System.out.println("remove "+ t.replace(3, "sheetal"));
		
		// contains
		System.out.println(t.contains("Amit"));
		
		//contains value
		System.out.println(t.containsValue("Anshika"));
		
		// contains key
		System.out.println(t.containsKey(4));
		
		//size
		System.out.println(t.size());
		
		//isempty
		System.out.println(t.isEmpty());
		
		//clear
		t.clear();
		System.out.println(t);
		
		t.put(5, "Avisha");
		t.put(6, "adi");
		System.out.println(t.keySet());
		System.out.println(t.values());
		System.out.println(t.entrySet());
		
//		clone();
		Hashtable<Integer , String> t2 = (Hashtable <Integer , String >) t.clone();
		System.out.println("clone "+t2);
		// equal 
		System.out.println(t.equals(t2));
		// hash code 
		System.out.println(t.hashCode());
		
	}
}
