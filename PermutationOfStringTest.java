/**
 * 
 */
package com.omniwyse.assignment.program;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Rakesh
 *
 */
public class PermutationOfStringTest {
	public  static PermutationOfString permutation ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		permutation=new PermutationOfString();
	System.out.println("Before Class");
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		permutation=null;
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Setup");
	}

	
	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	@Test
	public void test() {
		System.out.println("Test");
		PermutationOfString.StringPermutation("abc");
		
		
	}

}
