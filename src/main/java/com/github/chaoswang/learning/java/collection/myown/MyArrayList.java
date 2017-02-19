package com.github.chaoswang.learning.java.collection.myown;

import java.util.Arrays;

public class MyArrayList<E> {
	private int size = 0;
	private int initialSize;
	private Object[] elements = null;
	
	public MyArrayList(int initialSize){
		this.initialSize = initialSize;
		elements = new Object[initialSize];
	}
	
	//��
	public void add(E element){
		//�ﵽ�������ޣ���initialSize����50%
		if(++size == elements.length){
			elements = Arrays.copyOf(elements, size + (int)Math.round(initialSize * 0.5));
		}
		elements[size - 1] = element;
	}
	
	public void add(int index, E element){
		
	}
	
	public int size(){
		return size;
	}
	
	//��
	public E get(int index){
		return (E)elements[index];
	}
	
	//��
	public E remove(int index){
		 E removed = (E)elements[index];
		 for(int i=index; i<size -1; i++){
			 elements[i] = elements[i+1];
		 }
		 elements[size -1] = null;
		 size--;
		 return removed;
	}
	
	//�ô����������ڲ�ʵ�֣�ֻ���Ⱪ¶hasnext��next
	public MyIterator iterator(){
		return new ArrayListIterator();
	}
	
	//����ط�ǧ������static����ΪҪ��ʵ����
	private class ArrayListIterator implements MyIterator{
		int position;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return position == size ? false : true;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return elements[position];
		}
	}
}
