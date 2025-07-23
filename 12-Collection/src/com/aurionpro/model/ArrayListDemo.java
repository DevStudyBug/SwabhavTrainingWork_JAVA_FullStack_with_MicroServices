package com.aurionpro.model;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("apple");
		list.add("mango");
		list.add("cherry");
		System.out.println("arraylist: " + list);
		// add at index
		list.add(0, "guava");
		System.out.println(list);
		// remove
		list.remove(0);
		System.out.println(list);
		// set
		list.set(1, "Orange");
		System.out.println(list);

		// contains
		System.out.println("Contains elements? : " + list.contains("mango")); // false

		// indexOf
		System.out.println("Index of cherry: " + list.indexOf("cherry"));

		// doubt!! //last indexOf

		System.out.println("last index of element: " + list.lastIndexOf("cherry"));

		list.add("apple");
		System.out.println("last index of duplicate element apple " + list.lastIndexOf("apple"));
		// size
		System.out.println("Size: " + list.size());

		// Is the list empty?
		System.out.println("Is Empty? " + list.isEmpty());

		// clear
		list.clear();
		System.out.println("clear list " + list);

		// trim to size
		list.trimToSize();
		list.add("kiwi");
		System.out.println("Final list :" + list);

		// add all
		list.addAll(Arrays.asList("Banana", "Dragonfruit", "Apple"));
		System.out.println("Add all element: " + list);

		// for each loop
		System.out.print("List elements: ");
		for (String res : list) {
			System.out.print(" " + res + " ");
		}
		System.out.println("");

		// clone //clone // doubt

		System.out.println("Original List: " + list);

		// Clone the ArrayList
		ArrayList<String> clonedList = (ArrayList<String>) list.clone();

		System.out.println("Cloned List: " + clonedList);

		// Modifying original list to check if cloned list changes
		list.add("Orange");

		System.out.println("After modifying original list:");
		System.out.println("Original List: " + list);
		System.out.println("Cloned List: " + clonedList);

		// Further verify both lists
		System.out.println("Size of Original List: " + list.size());
		System.out.println("Size of Cloned List: " + clonedList.size());

	}

}
