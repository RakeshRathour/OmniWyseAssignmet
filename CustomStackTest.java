package com.omniwyse.OmniWyseAssignment2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomStackTest {
	public static CustomStack customStack;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customStack = new CustomStack(2);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		customStack = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPush() {
		customStack.push(10);
		customStack.push(22);
		customStack.push(33);
		customStack.push(55);
		
	}

}
