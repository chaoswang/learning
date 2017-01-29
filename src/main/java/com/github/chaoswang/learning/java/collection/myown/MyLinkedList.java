package com.github.chaoswang.learning.java.collection.myown;

public class MyLinkedList<E> {
	private int size = 0;
	private OneElement first = null;
	private OneElement last = null;
	
	//¿ì
	public void add(E element){
		OneElement tmp = new OneElement(element, null);
		if(last == null){
			first = tmp;
		}else{
			last.next = tmp;;
		}
		last = tmp;
		size++;
	}
	
	//¿ì
	public E remove(int index){
		OneElement tmpBeore = this.getElement(index-1);
		OneElement tmp = this.getElement(index);
		OneElement tmpNext = this.getElement(index+1);
		tmpBeore.next = tmpNext;
		size--;
		return tmp.element;
	}
	
	public int size() {
		return size;
	}
	
	private OneElement getElement(int index) {
		OneElement tmp = first.next;
		for(int i=0;i<index-1;i++){
			tmp = tmp.next;
		}
		return tmp;
	}
	
	//Âý
	public E get(int index){
		return this.getElement(index).element;
	}
	
	private class OneElement{
		private E element = null;
		private OneElement next = null;

		public OneElement(E element, OneElement next) {
			this.element = element;
			this.next = next;
		}
	}
}
