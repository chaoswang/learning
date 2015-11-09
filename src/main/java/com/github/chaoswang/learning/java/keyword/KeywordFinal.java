package com.github.chaoswang.learning.java.keyword;


/**
 * @author Administrator
 *java关键字final，final修饰的引用变量不能置为空，也不能重新指向其他对象
 */
public class KeywordFinal {
	
	
	final Integer a = new Integer(1);
	
	public Integer getA() {
		return a;
	}
	
	public static void main(String[] args) {
		//常量存储在方法区，在程序运行过程中非必要不进行回收搜索，在程序运行结束时再回收
		//以下两种赋值都会报错
//		a = null;
//		a = new Integer(2);
		
	}
	
}
