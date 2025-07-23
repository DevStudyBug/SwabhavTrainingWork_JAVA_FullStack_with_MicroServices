package com.aurionpro.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinedListBasics {
	public static void main(String[] args) {
		// Creating a LinkedList of String
		
		List<Integer> list = Arrays.asList(10, 20, 30, 40);
		list.replaceAll(n -> n + 5);
		System.out.println(list);
		List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		System.out.println(nums.stream().reduce(1, (a, b) -> a * b));
		List<Integer> nu = Arrays.asList(3, 1, 4, 1, 5, 9);
		System.out.println(nu.stream().filter(n -> n % 2 == 0).count());

		LinkedList<String> cities = new LinkedList<>();

		// 1. add() - Add to end
		cities.add("Mumbai");
		cities.add("Delhi");
		cities.add("Bangalore");
		System.out.println("After add(): " + cities);

		// 2. addFirst() - Add at beginning
		cities.addFirst("Kolkata");
		System.out.println("After addFirst(): " + cities);

		// 3. addLast() - Add at end (same as add())
		cities.addLast("Chennai");
		System.out.println("After addLast(): " + cities);

		// Sort the LinkedList
		Collections.sort(cities);
		System.out.println("After sort: " + cities);

		// 4. add(index, element) - Add at specific index
		cities.add(2, "Pune");
		System.out.println("After add at index 2: " + cities);

		// 5. get() - Access element by index
		System.out.println("Element at index 3: " + cities.get(3));

		// 6. getFirst(), getLast() - First and last elements
		System.out.println("First city: " + cities.getFirst());
		System.out.println("Last city: " + cities.getLast());

		// 7. set(index, element) - Update element
		cities.set(3, "Hyderabad");
		System.out.println("After set() at index 3: " + cities);

		// 8. remove() - Remove first element
		cities.remove();
		System.out.println("After remove(): " + cities);

		// 9. removeFirst(), removeLast()
		cities.removeFirst();
		cities.removeLast();
		System.out.println("After removeFirst() and removeLast(): " + cities);

		// 10. remove(index)
		cities.remove(1);
		System.out.println("After remove(index 1): " + cities);

		// 11. remove(Object)
		cities.remove("Hyderabad");
		System.out.println("After remove(\"Hyderabad\"): " + cities);

		// 12. contains()
		System.out.println("Contains 'Mumbai'? " + cities.contains("Mumbai"));
		System.out.println("Contains 'Delhi'? " + cities.contains("Delhi"));

		// 13. indexOf()
		cities.add("Delhi");
		System.out.println("Index of 'Delhi': " + cities.indexOf("Delhi"));

		// 14. size()
		System.out.println("Size of LinkedList: " + cities.size());

		// 15. isEmpty()
		System.out.println("Is list empty? " + cities.isEmpty());

		// 16. clear() - Remove all elements
		cities.clear();
		System.out.println("After clear(): " + cities);
		System.out.println("Is list empty now? " + cities.isEmpty());
	}
}