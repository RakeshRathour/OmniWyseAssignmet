package com.omniwyse.assignment.program;

public class PrimeNumberThroughMethod {
	static void checkPrime(int n) {
		int i, modulo = 0, flag = 0;
		modulo = n / 2;
		if (n == 0 || n == 1) {
			System.out.println(n + " is not prime number");
		} else {
			for (i = 2; i <= modulo; i++) {
				if (n % i == 0) {
					System.out.println(n + " is not prime number");
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println(n + " is prime number");
			}
		} // end of else
	}

	public static void main(String args[]) {
		/*checkPrime(1);
		checkPrime(3);
		checkPrime(10);
		checkPrime(9);
*/
	}
}
