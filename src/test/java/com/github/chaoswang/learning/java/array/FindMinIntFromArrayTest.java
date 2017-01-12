package com.github.chaoswang.learning.java.array;

import org.junit.Assert;
import org.junit.Test;


public class FindMinIntFromArrayTest {
	@Test
	public void testFindMinInt(){
		Assert.assertEquals(1, FindMinIntFromArray.findMinInt(new int[]{5,2,1,3,4}));
	}
	
	@Test
	public void testFindMinIntUsingSort(){
		Assert.assertEquals(1, FindMinIntFromArray.findMinIntUsingSort(new int[]{5,2,1,3,4}));
	}
	
	@Test
	public void testreverseArray(){
		Assert.assertArrayEquals(new int[]{4,3,1,2,5}, FindMinIntFromArray.reverseArray(new int[]{5,2,1,3,4}));
		Assert.assertArrayEquals(new int[]{4,3,6,1,2,5}, FindMinIntFromArray.reverseArray(new int[]{5,2,1,6,3,4}));
	}
	
	@Test
	public void testReverseArrayUsingCollection(){
		Assert.assertArrayEquals(new Integer[]{4,3,1,2,5}, FindMinIntFromArray.reverseArrayUsingCollection(new Integer[]{5,2,1,3,4}));
		Assert.assertArrayEquals(new Integer[]{4,3,6,1,2,5}, FindMinIntFromArray.reverseArrayUsingCollection(new Integer[]{5,2,1,6,3,4}));
	}
}
