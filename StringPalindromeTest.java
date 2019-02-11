package com.omniwyse.assignment.program;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringPalindromeTest {
	public static StringPalindrome stringPalindrome; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
		stringPalindrome = new StringPalindrome();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
		stringPalindrome = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp  or Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown or After");
	}

	@Test
	public void testStringPalindrome() {
		StringPalindrome.isPalindrome("RSR");
		System.out.println("test for String Palindrome");
		
	}

}
