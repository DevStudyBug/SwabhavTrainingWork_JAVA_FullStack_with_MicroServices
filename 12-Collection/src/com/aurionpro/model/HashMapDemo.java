package com.aurionpro.model;

import java.util.HashMap;

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
//		1.put
		map.put(1, "anshika");
		map.put(null, "alok"); // hash map allow one null
		map.put(null, "Avisha");
		map.put(2, null);
		map.put(3, "vivek");
		System.out.println(map);

//		2. put if absent
		map.putIfAbsent(2, "aditya");
		System.out.println(map);

//  	3. get

		System.out.println(map.get(3));

// 4.remove key
		System.out.println("remove key : "+ map.remove(1));
		System.out.println("Map after removing key : "+map);
		
		//5. remove both
		System.out.println(map.remove(2, "aditya"));
		System.out.println(map);

		//6. contains
		System.out.println("contains key? : "+ map.containsKey(null));
		
		// 7. contains values
		System.out.println("contains values? "+map.containsValue("vivek"));
		
		//8. size
		System.out.println(map.size());
		
		
		// 9 . is empty
		System.out.println(map.isEmpty());
		
		//10 clear 
//		System.out.println(map.clear());
		
		//11 . keyset
		System.out.println(map.keySet());
		System.out.println(map.values());
		
		System.out.println("replace "+map.replace(null, "alok"));
		System.out.println(map);
		System.out.print("replace old "+map.replace(null, "alok", "amit"));
		System.out.println(map);
		
		
	}

}
