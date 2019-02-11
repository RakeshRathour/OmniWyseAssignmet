package com.omniwyse.assignment.program;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SearchElementTest {
	public static SearchElement searchElement;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
		searchElement = new SearchElement();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
		searchElement = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp or Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown or After");
	}

	@Test
	public void testSearchElement() {
		System.out.println("test for SearchElement");
		SearchElement.main(null);
	}

}
