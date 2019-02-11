package com.omniwyse.assignment.program;

import java.util.Scanner;

/**
 * 
 * @author Rakesh 
 * program to solve Tower of Hanoi problem
 *
 */

public class TowerOfHanoi {
	public void solveTowerOfHanoi(int n, String source, String auxi, String destination) {
		// If only 1 disk, make the move and return.
		if (n == 1) {
			System.out.println("Move Disk from "+source +" To "+"--> " + destination);
			return;
		}

		// Move top n-1 disks from A to B using C as auxiliary.
		solveTowerOfHanoi(n - 1, source, destination, auxi);

		// Move remaining disks from A to C
		System.out.println("Move Disk from "+source +" To "+"--> " + destination);

		// Move n-1 disks from B to C using A as auxiliary
		solveTowerOfHanoi(n - 1, auxi, source, destination);

	}

	public static void main(String[] args) {
		TowerOfHanoi obj = new TowerOfHanoi();

		System.out.println("Enter number of disks : ");

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();

		System.out.println("Move disks as below illustration");
		obj.solveTowerOfHanoi(n, "A", "B", "C");

	}

}
