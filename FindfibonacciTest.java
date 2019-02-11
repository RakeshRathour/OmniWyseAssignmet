package com.omniwyse.assignment.program;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindfibonacciTest {
	//public static Findfibonacci fibonacci;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	//	fibonacci = new Findfibonacci();
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	//	fibonacci=null;
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before or setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After or tearDown");
	}

	@Test
	public void testFibonacci() {
		Findfibonacci.main(null);
		System.out.println("test for Fibonacci");
	}

}
