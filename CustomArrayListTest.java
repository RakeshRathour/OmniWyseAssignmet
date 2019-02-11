package com.omniwyse.OmniWyseAssignment2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomArrayListTest {
	public static CustomArrayList customArrayList;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customArrayList = new CustomArrayList();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		customArrayList = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		customArrayList.add("Rakesh");
		customArrayList.add("Imran");
		customArrayList.add("OmniWyse");
		customArrayList.add(10);
		customArrayList.add(20);
		// checking Capacity
		int actualCapacity = customArrayList.capacity();
		int expectedCapacity = 10;
		assertEquals(expectedCapacity, actualCapacity);

		// checking size
		int actualSize = customArrayList.size();
		int expectedSize = 5;
		assertEquals(expectedSize, actualSize);

	}

	@Test
	public void testGet() {
		Object actualGet = customArrayList.get(2);
		String expectedGet = "OmniWyse";
		assertEquals(expectedGet, actualGet);

	}

}
