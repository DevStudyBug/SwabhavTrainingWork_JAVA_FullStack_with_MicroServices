package com.aurionpro.model;

import java.util.HashSet;
import java.util.Set;

public class SetBasics {

	public static void main(String[] args) {

		// Creating a HashSet of Strings
		Set<String> fruits = new HashSet<>();

		// 1. add() - Add elements to the Set
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Mango");
		fruits.add("Orange");
		System.out.println("After add(): " + fruits);

		// 2. add() - Duplicates are ignored
		fruits.add("Apple");
		System.out.println("After adding duplicate 'Apple': " + fruits);

		// 3. remove(Object) - Remove specific element
		fruits.remove("Banana");
		System.out.println("After remove('Banana'): " + fruits);

		// 4. contains() - Check if element exists
		System.out.println("Contains 'Mango'? " + fruits.contains("Mango"));
		System.out.println("Contains 'Grapes'? " + fruits.contains("Grapes"));

		// 5. size() - Get number of elements
		System.out.println("Size of Set: " + fruits.size());

		// 6. isEmpty() - Check if Set is empty
		System.out.println("Is Set empty? " + fruits.isEmpty());

		// 7. clear() - Remove all elements
		fruits.clear();
		System.out.println("After clear(): " + fruits);
		System.out.println("Is Set empty now? " + fruits.isEmpty());

		// 8. Re-adding elements for iteration example
		fruits.add("Kiwi");
		fruits.add("Pineapple");
		fruits.add("Guava");

		// 9. Iterating using for-each
		System.out.println("Iterating Set:");
		for (String fruit : fruits) {
			System.out.println(fruit);
		}

		// 10. equals() - Compare two sets
		Set<String> set2 = new HashSet<>();
		set2.add("Kiwi");
		set2.add("Guava");
		set2.add("Pineapple");
		System.out.println("Set 2 elements :" + set2);
		System.out.println("Are both sets equal? " + fruits.equals(set2));

		// 11. retainAll() - Intersection (common elements)
		set2.add("Strawberry");
		System.out.println(set2);
		fruits.retainAll(set2);
		System.out.println("After retainAll() - common elements: " + fruits);

		// 12. addAll() - Union of sets
		fruits.addAll(set2);
		System.out.println("After addAll(): " + fruits);

		// 13. removeAll() - Remove elements present in another set
		fruits.removeAll(set2);
		System.out.println("After removeAll(): " + fruits);
	}
}
