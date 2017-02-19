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
	
	//慢
	public void add(E element){
		//达到数组上限，按initialSize扩容50%
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
	
	//快
	public E get(int index){
		return (E)elements[index];
	}
	
	//慢
	public E remove(int index){
		 E removed = (E)elements[index];
		 for(int i=index; i<size -1; i++){
			 elements[i] = elements[i+1];
		 }
		 elements[size -1] = null;
		 size--;
		 return removed;
	}
	
	//好处在于隐藏内部实现，只对外暴露hasnext和next
	public MyIterator iterator(){
		return new ArrayListIterator();
	}
	
	//这个地方千万不能用static，因为要和实例绑定
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
