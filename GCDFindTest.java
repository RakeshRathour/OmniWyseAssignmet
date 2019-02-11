package com.omniwyse.assignment.program;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GCDFindTest {
	public static GCDFind gcdFind;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
		gcdFind = new GCDFind();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
		gcdFind = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before ");

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After ");

	}

	@Test
	public void testGCD() {
		GCDFind.gcd(96, 56);
		System.out.println("test for Greatest Common Divisor ");
	}

}
