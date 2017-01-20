package com.github.chaoswang.learning.java.collection.list;


import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest {
	
	@Test
	public void testAdd(){
		MyArrayList<String> myList = new MyArrayList<String>(3);
		myList.add("1");
		myList.add("2");
		myList.add("3");
		Assert.assertEquals(3, myList.size());
		myList.add("4");
		Assert.assertEquals(4, myList.size());
		String str = (String)myList.get(2);
		Assert.assertEquals("3", str);
		str = (String)myList.remove(2);
		Assert.assertEquals("3", str);
		str = (String)myList.get(2);
		Assert.assertEquals("4", str);
	}
}
