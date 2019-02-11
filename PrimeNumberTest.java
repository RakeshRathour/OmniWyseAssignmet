package com.omniwyse.assignment.program;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PrimeNumberTest extends PrimeNumberThroughMethod{
	public static  PrimeNumber primeNumber;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		primeNumber = new PrimeNumber();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		primeNumber = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrime() {
		PrimeNumber.main(null);
		
	}

}
