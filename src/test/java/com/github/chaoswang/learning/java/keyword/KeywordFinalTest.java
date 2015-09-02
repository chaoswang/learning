package com.github.chaoswang.learning.java.keyword;

import org.junit.Assert;
import org.junit.Test;

public class KeywordFinalTest {

	@Test
	public void testKeywordFinal(){
		KeywordFinal keywordFinal = new KeywordFinal();
		Integer a = keywordFinal.getA();
		Assert.assertEquals(1, a.intValue());
		//常量存储在方法区，在程序运行过程中非必要不进行回收搜索，在程序运行结束时再回收
		//以下两种赋值都会报错
		a = null;
		Assert.assertNull(a);
		a = new Integer(2);
		Assert.assertEquals(2, a.intValue());
	}
}
