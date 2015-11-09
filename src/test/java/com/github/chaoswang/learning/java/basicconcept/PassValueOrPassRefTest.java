package com.github.chaoswang.learning.java.basicconcept;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Administrator
 *�����������ͣ���ʵ��������ʱ��Ȼ�ǰ�ֵ(���ñ�����ָ���ڴ��ֵַ)���ݵ�;
 *��Ȼ�������ô���Ҳ������ȫû�е���
 *ֻ�ǲο��������������ͱ�����������������ָ��Ķ���
 */
public class PassValueOrPassRefTest {
	PassValueOrPassRef swapper;

	@Before
	public void setUp(){
		
		swapper = new PassValueOrPassRef();
	}
	
	
	/**
	 * ������swap(stra, strb)����ʱ�����ݵ�����������stra��strb�Ŀ���ֵ��
	 * ��˺������κζԲ����ĸı䶼����Ӱ�쵽stra��strb��ֵ
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
	 * ����swap(strArr)ʱ�����ݵ���strArr�Ŀ���ֵ�������жԲ������κθı���Ȼ����Ӱ�쵽strArr��ֵ��
	 * Ȼ��swap(T[] t)�иı�Ĳ�����strArr��ֵ������strArr[0]��strArr[1]��ֵ��
	 * Ҳ������������strArr��ָ��Ķ����ֵ�����strArr[0]��strArr[1]��ֵ�����˱仯��
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
