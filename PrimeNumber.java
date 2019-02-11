package com.omniwyse.assignment.program;

import java.util.Scanner;

/**
 * 
 * @author Rakesh 
 * program to check number is prime or not
 *
 */
public class PrimeNumber {

	public static void main(String[] args) {
		System.out.println("Enter any Number : ");
		int num = new Scanner(System.in).nextInt();
		boolean isPrime = true;
		// checking each number remaindar is 0 or not 
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				isPrime = false;
			}
		}
		if (isPrime) {
			System.out.println("Number is Prime");
		} else {
			System.out.println("Number is not prime");
		}
	

	}// main

}// class
