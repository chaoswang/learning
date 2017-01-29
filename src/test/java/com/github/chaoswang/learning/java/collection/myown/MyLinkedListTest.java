package com.github.chaoswang.learning.java.collection.myown;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest {

	@Test
	public void testAdd(){
		MyLinkedList<String> myList = new MyLinkedList<String>();
		myList.add("1");
		myList.add("2");
		myList.add("3");
		Assert.assertEquals(3, myList.size());
		myList.add("4");
		Assert.assertEquals(4, myList.size());
		String str = myList.get(2);
		Assert.assertEquals("3", str);
		str = myList.remove(2);
		Assert.assertEquals("3", str);
		str = myList.get(2);
		Assert.assertEquals("4", str);
		Assert.assertEquals(3, myList.size());
	}
}
