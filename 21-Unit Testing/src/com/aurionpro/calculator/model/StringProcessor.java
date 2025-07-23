package com.aurionpro.calculator.model;

public class StringProcessor {
	public boolean isPalindrome(String str) {
        if (str == null)
            return false;
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversed);
    }

    public String reverse(String str) {
        if (str == null)
            return null;
        return new StringBuilder(str).reverse().toString();
    }
}
