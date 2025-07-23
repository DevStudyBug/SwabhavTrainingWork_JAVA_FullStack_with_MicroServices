package com.aurionpro.test;

import java.lang.reflect.Method;

import com.aurionpro.model.HiddenOps;

public class hiddenOpsTest {
	public static void main(String[] args) throws Exception{
		HiddenOps hiddenops = new HiddenOps();
		Class c = HiddenOps.class;
		Method secretMethod = c.getDeclaredMethod("secretCode", String.class);
		
		secretMethod.setAccessible(true);

		System.out.println("Output: " + secretMethod.invoke(hiddenops, "Hello"));
	}
}
