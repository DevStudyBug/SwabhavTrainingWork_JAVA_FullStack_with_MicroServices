package com.aurionpro.calculator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.aurionpro.calculator.model.StringProcessor;

public class StringProcessorTest {
StringProcessor processor = new StringProcessor();
@BeforeEach
void setup() {
    processor = new StringProcessor();
    System.out.println("Test Started.");
}

@AfterEach
void teardown() {
    System.out.println("Test Finished.\n");
}

@Tag("fast")
@Test
@DisplayName("Palindrome Test - True Case")
void testIsPalindrome_True() {
    assertTrue(processor.isPalindrome("madam"));
}

@Tag("fast")
@Test
@DisplayName("Palindrome Test - False Case")
void testIsPalindrome_False() {
    assertFalse(processor.isPalindrome("world"));
}

@Nested
@DisplayName("Reverse Method Tests")
class ReverseTests {

    @Test
    @DisplayName("Reverse of Normal String")
    void testReverse_NormalString() {
        assertEquals("cba", processor.reverse("abc"));
    }

    @RepeatedTest(3)
    @DisplayName("Repeated Reverse Test")
    void repeatedReverseTest() {
        assertEquals("dcba", processor.reverse("abcd"));
    }

    @Disabled("Under development")
    @Test
    @DisplayName("Reverse Special Case (Under Development)")
    void testReverse_SpecialCase() {
        assertEquals("321", processor.reverse("123"));
    }
}
}
//Assignment 2: StringProcessor Test Suite
//Problem Statement:
//Create a class StringProcessor with methods:
// boolean isPalindrome(String str)
// String reverse(String str)
//Tasks:
// Use @Tag("fast") on palindrome tests
// Use @Nested class ReverseTests for reverse method-related tests
// Add one test method as @Disabled("Under development")
// Use @RepeatedTest(3) to repeatedly test reverse() with the same input