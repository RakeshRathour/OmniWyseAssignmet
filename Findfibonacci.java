package com.omniwyse.assignment.program;

import java.util.Scanner;

/**
 * 
 * @author Rakesh 
 * program to find Fibonacci recursive and iterative version
 * 
 */

public class Findfibonacci {

	public static void main(String[] args) {
		System.out.println("enter any number for last sequence of series :  ");
		int num = new Scanner(System.in).nextInt();
		int f1 = 0, f2 = 1, fibonacci;
		System.out.print(f1 + " " + f2);
		// iterative method
		for (int i = 0; i <= num; i++) {
			fibonacci = f1 + f2;
			System.out.print(" " + fibonacci);
			f1 = f2;
			f2 = fibonacci;

		}
		// Recursive Printing
		System.out.println();
		System.out.println("Enter any Number : ");
		Scanner Sc = new Scanner(System.in);
		int n = Sc.nextInt();
		Findfibonacci fib = new Findfibonacci();
		for(int i =0;i<n;i++){
			System.out.print(" "+fib.fibonacci(i));
		}

	}// main

	// Recursive method
	 int fibonacci(int n)
	 {
	  if(n==0)
	   return 0;
	  if(n==1)
	   return 1;
	  else
	   return fibonacci(n-1)+fibonacci(n-2);
	 }
	

}// class
