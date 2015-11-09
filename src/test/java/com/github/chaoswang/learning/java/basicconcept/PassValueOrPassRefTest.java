package com.github.chaoswang.learning.java.basicconcept;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Administrator
 *对于引用类型，其实参数传递时仍然是按值(引用变量所指的内存地址值)传递的;
 *当然，按引用传递也不是完全没有道理，
 *只是参考对象不是引用类型本身，而是引用类型所指向的对象。
 */
public class PassValueOrPassRefTest {
	PassValueOrPassRef swapper;

	@Before
	public void setUp(){
		
		swapper = new PassValueOrPassRef();
	}
	
	
	/**
	 * 当调用swap(stra, strb)函数时，传递的是引用类型stra、strb的拷贝值，
	 * 因此函数中任何对参数的改变都不会影响到stra和strb的值
	 */
	@Test
	public void testPassRef(){
		String strA = "strA";
		String strB = "strB";
		swapper.swap(strA, strB);
		Assert.assertEquals("strA", strA);
		Assert.assertEquals("strB", strB);
	}
	
	/**
	 * 调用swap(strArr)时，传递的是strArr的拷贝值，程序中对参数的任何改变仍然不会影响到strArr的值，
	 * 然而swap(T[] t)中改变的并不是strArr的值，而是strArr[0]和strArr[1]的值，
	 * 也就是引用类型strArr所指向的对象的值，因而strArr[0]和strArr[1]的值发生了变化。
	 */
	@Test
	public void testPassValue(){
		String[] strArray  =   new  String[]{"strA", "strB"} ;  
        swapper.swap(strArray);  
		Assert.assertArrayEquals(new String[]{"strB", "strA"}, strArray);
	}
	
	@Test
	public void testIntAndInteger(){
		Integer b = new Integer(1);
		Integer c = b;
		b = new Integer(2);
		Assert.assertEquals(1,c.intValue());
		
		int d = 1;
		int e = d;
		d=2;
		Assert.assertEquals(1,e);
	}
}
