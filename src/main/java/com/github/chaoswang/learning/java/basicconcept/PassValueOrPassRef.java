package com.github.chaoswang.learning.java.basicconcept;

/**
 * @author Administrator 
 * Java�����Ǵ�ֵ���Ǵ�����?���ź�����������ȫ�ش���ȷ��ͨ����˵���ǣ����ڻ�����������(���͡�
 *  �����͡��ַ��͡������͵�)����ֵ;������������(��������)�������á��������ʹ�ֵ ��
 *  �����˶�����Դ�������;����������������ϡ�
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
