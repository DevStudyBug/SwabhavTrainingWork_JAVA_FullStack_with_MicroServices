package com.aurionpro.calculator.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedExampleTest {
	@Nested
	class group1Test {

	    @Test
	    void test1() {
	        assertTrue(true);
	        System.out.println("Testing test one");
	    }
	}

	@Nested
	class group2Test {

	    @Test
	    void test2() {
	        assertTrue(true);
	        System.out.println("Testing test two");
	    }
	}
}
