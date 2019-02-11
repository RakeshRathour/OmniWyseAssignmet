package com.omniwyse.assignment.program;

import java.util.Scanner;

/**
 * 
 * @author Rakesh 
 * program to searching element in array
 *
 */

public class SearchElement {

	public static void main(String[] args) {
		boolean flag = false;
		int n, i, S;
		Scanner Sc = new Scanner(System.in);
		Sc.close();
		System.out.println("Enter Number for total Element : ");
		n = Sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter all Element : ");
		// storing each element in array and assigning to i
		for (i = 0; i < n; i++) {
			arr[i] = Sc.nextInt();
		}
		System.out.println("Enter element for Seaching : ");
		S = Sc.nextInt();
		// comparing each element with searching element
		for (i = 0; i < n; i++) {
			if (arr[i] == S) {
				flag = true;
				break;
			} else {
				flag = false;
			}

		}
		if (flag) {
			System.out.println("Element is Present in array at Position " + (i + 1));
		} else {
			System.out.println("Element is not present in array");
		}
	} // main
}// class