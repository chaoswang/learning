package com.github.chaoswang.learning.java.keyword;

import org.junit.Assert;
import org.junit.Test;

public class KeywordFinalTest {

	@Test
	public void testKeywordFinal(){
		KeywordFinal keywordFinal = new KeywordFinal();
		Integer a = keywordFinal.getA();
		Assert.assertEquals(1, a.intValue());
		//�����洢�ڷ��������ڳ������й����зǱ�Ҫ�����л����������ڳ������н���ʱ�ٻ���
		//�������ָ�ֵ���ᱨ��
		a = null;
		Assert.assertNull(a);
		a = new Integer(2);
		Assert.assertEquals(2, a.intValue());
	}
}
