package com.junit;
//import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class MyMathTest {
	
	MyMath myMath = new MyMath();
    @BeforeEach
	public void before() {
		System.out.println("Before");
	}
    
    @AfterEach
    public void after() {
		System.out.println("after");
    }
	@Test
	public void sum_with3numbers() {
		//System.out.println("Test1");
		//assertEquals(6, myMath.sum(new int[] {1,2,3})); 
		int result = myMath.sum(new int[] {1,2,3});
		//check that result ==6	
		assertEquals(6, result);
	//	System.out.println(result);
		//fail("Not yet implemented");
		//absence of failure is success*/
	}
	
	@Test
	public void sum_with1numbers() {
		System.out.println("Test2");
		int result = myMath.sum(new int[] {3});
		assertEquals(3, myMath.sum(new int[] {3})); //one line
		
	}
}
