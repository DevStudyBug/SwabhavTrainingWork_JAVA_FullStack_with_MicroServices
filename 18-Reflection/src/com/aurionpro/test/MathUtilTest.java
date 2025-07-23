package com.aurionpro.test;

import java.lang.reflect.Method;

import com.aurionpro.model.MathUtil;

public class MathUtilTest {
public static void main(String[] args) throws Exception {
	MathUtil mathUtil = new MathUtil();
	
	Class<MathUtil> c = MathUtil.class;
	
	Method squareMethod = c.getMethod("square",int.class);
	
	System.out.println("Result of square(5): "+ squareMethod.invoke(mathUtil, 5));
	
}
}
