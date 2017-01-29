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
}
