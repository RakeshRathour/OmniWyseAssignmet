package com.omniwyse.assignment.program;

/**
 * 
 * @author Rakesh 
 * program to print all permutation of given string
 *
 */

public class PermutationOfString {
	static public void StringPermutation(String input) {
		strPermutation("", input);
	}

	public static void strPermutation(String permutation, String input) {

		if (input.length() == 0) {
			System.out.println(permutation);
		} else {
			for (int i = 0; i < input.length(); i++) {
				strPermutation(permutation + input.charAt(i),
						input.substring(0, i) + input.substring(i + 1, input.length()));
			}

		}

	}

	public static void main(String[] args) {
		StringPermutation("RAKESH");

	}

}
