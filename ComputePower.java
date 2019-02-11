package com.omniwyse.assignment.program;

import java.util.Scanner;

/**
 * 
 * @author Rakesh 
 * program to compute power of given number
 *
 */

public class ComputePower {

	public static void main(String[] args) {
		System.out.println("Enter number for base :  ");
		int base = new Scanner(System.in).nextInt();
		System.out.println("Enter number for raised power : ");
		int powerRaised = new Scanner(System.in).nextInt();
		int result = power(base, powerRaised);
		System.out.printf("Result = : "+"%d^%d = %d", base, powerRaised, result);
		System.out.println();
		
		// through  math method
		int pow = (int) Math.pow(base, powerRaised);
		System.out.println("Result : "+ pow);

	}

	// function to return power
	public static int power(int base, int powerRaised) {
		if (powerRaised != 0) {
			return base * power(base, powerRaised - 1);
		} else {
			return 1;
		}

	}// method
}// class
