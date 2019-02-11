package com.omniwyse.assignment.program;

/**
 * 
 * @author Rakesh
 * program to checking string is palindrome or not
 *  
 */
public class StringPalindrome {
	public static boolean isPalindrome(String str) {
		// checking string is null or empty and returing true
		if (str.length() == 0 || str.length() == 1) {
			return true;
		}
		// comparing first character with last character if and return substring
		if (str.charAt(0) == str.charAt(str.length() - 1)) {
			return isPalindrome(str.substring(1, str.length() - 1));
		}
		return false;
	}

	public static void main(String args[]) {
		String string = "RSR";
		if (isPalindrome(string)) {
			System.out.println("String is a Palindrome");
		} else {
			System.out.println("String is not a Palindrome");
		}
	}// main
}// class