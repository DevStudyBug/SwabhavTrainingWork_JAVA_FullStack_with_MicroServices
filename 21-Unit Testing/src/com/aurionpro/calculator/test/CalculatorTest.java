package com.aurionpro.calculator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.aurionpro.calculator.model.calculator;

public class CalculatorTest {

    calculator cal = new calculator();
    
    @BeforeAll
    public static void setUp()
    {
        System.out.println("Before all tests");
    }

    @BeforeEach
    public void beforeNewTest()
    {
        System.out.println("New test is about to start");
    }

    @AfterAll
    public static void allTestsDone()
    {
        System.out.println("All tests are completed");
    }

    @AfterEach
    public void afterTest()
    {
    	System.out.println("test is about to end");
    }
    
    @Test
    public void testAddition() {
        int sum = cal.additon(3, 5);
        assertEquals(8, sum);
    }
    @Test
    @Disabled
//    @RepeatedTest(5)
    public void testSubtraction() {
        assertEquals(8, cal.subtraction(10, 2));
    }
    @Test
    public void testDivision()
    {
        //assertEquals(2, cal.division(10,2));
        assertThrows(ArithmeticException.class, () -> cal.division(5, 0));
    }
    @Test
    @Tag("Slow")
    public void underDevelopment()
    {
        System.out.println("Under progress.....can not be tested");
    }
    @DisplayName("Multi")
    @Test
    @Tag("Slow")
    public void testMulti() {

    	assertEquals(20, cal.multiplication(10, 2));
    }
}
