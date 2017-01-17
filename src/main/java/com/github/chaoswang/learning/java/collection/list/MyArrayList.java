package com.github.chaoswang.learning.java.collection.list;

import java.util.Arrays;

public class MyArrayList {
	private int size = 0;
	private int initialSize;
	private Object[] elements = null;
	
	public MyArrayList(int initialSize){
		this.initialSize = initialSize;
		elements = new Object[initialSize];
	}
	
	public void add(Object element){
		//达到数组上限，按initialSize扩容
		if(++size == elements.length){
			elements = Arrays.copyOf(elements, size + initialSize);
		}
		elements[size - 1] = element;
	}
	
	public int size(){
		return size;
	}
	
	public Object get(int index){
		return elements[index];
	}
}
