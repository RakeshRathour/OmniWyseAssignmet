package com.omniwyse.OmniWyseAssignment2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringReverseTest {
	public static StringReverse stringReverse;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
		stringReverse = new StringReverse();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		stringReverse = null;
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After ");
	}

	@Test
	public void testStringReverse() {
		String actualResult = stringReverse.wordReverse();
		String expectedResult = "hsekaR";
		assertEquals(actualResult, expectedResult);
		System.out.println("test for String Reverse Class");

	}

}
