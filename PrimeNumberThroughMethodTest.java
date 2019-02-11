package com.omniwyse.assignment.program;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PrimeNumberThroughMethodTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void testPrimeMethod() {
		PrimeNumberThroughMethod.checkPrime(33);
		PrimeNumberThroughMethod.main(null);
		System.out.println("@Test for Prime Number through Method");
	}

}
