package com.github.chaoswang.learning.java.generic;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class GenericTest {

	@Test
	public void testGenericEquals(){
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		Assert.assertEquals(list1.getClass(), list2.getClass());
	}
	
	@Test
	public void testGenericNumber(){
		ArrayList<Number> numbers = new ArrayList<Number>();
		numbers.add(new Integer(10));
		numbers.add(new Double(10.0d));
		System.out.println(numbers);
		
					
	}
	
}
