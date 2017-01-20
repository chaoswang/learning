package com.github.chaoswang.learning.java.collection.list;

import java.util.Arrays;

public class MyArrayList<E> {
	private int size = 0;
	private int initialSize;
	private Object[] elements = null;
	
	public MyArrayList(int initialSize){
		this.initialSize = initialSize;
		elements = new Object[initialSize];
	}
	
	public void add(E element){
		//达到数组上限，按initialSize扩容
		if(++size == elements.length){
			elements = Arrays.copyOf(elements, size + initialSize);
		}
		elements[size - 1] = element;
	}
	
	public int size(){
		return size;
	}
	
	public E get(int index){
		return (E)elements[index];
	}
	
	public E remove(int index){
		 E removed = (E)elements[index];
		 for(int i=index; i<size -1; i++){
			 elements[i] = elements[i+1];
		 }
		 elements[size -1] = null;
		 return removed;
	}
}
