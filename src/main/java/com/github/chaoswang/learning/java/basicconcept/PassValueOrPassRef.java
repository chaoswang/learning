package com.github.chaoswang.learning.java.basicconcept;

/**
 * @author Administrator 
 * Java到底是传值还是传引用?相信很少有人能完全回答正确。通常的说法是：对于基本数据类型(整型、
 *  浮点型、字符型、布尔型等)，传值;对于引用类型(对象、数组)，传引用。基本类型传值 ，
 *  所有人都不会对此有疑义;问题出在引用类型上。
 */
public class PassValueOrPassRef {
	public <T> void swap(T a, T b) {
		T temp = a;
		a = b;
		b = temp;
	}

	public <T> void swap(T[] t) {
		if (t.length < 2) {
			System.out.println(" error! ");
			return;
		}

		T temp = t[0];
		t[0] = t[1];
		t[1] = temp;
	}
}
