package com.github.chaoswang.learning.java.collection.myown;

public class MyLinkedList<E> {
	private int size = 0;
	private Node head = null;
	private Node tail = null;
	
	//快
	public void add(E element){
		Node tmp = new Node(element, null);
		if(tail == null){
			head = tmp;
		}else{
			tail.next = tmp;;
		}
		tail = tmp;
		size++;
	}
	
	public void add(int index, E element){
		
	}
	
	public void addFirst(){
		
	}
	
	public void removeFirst(){
		
	}
	
	//快
	public E remove(int index){
		Node tmpBeore = this.getElement(index-1);
		Node tmp = this.getElement(index);
		Node tmpNext = this.getElement(index+1);
		tmpBeore.next = tmpNext;
		size--;
		return tmp.element;
	}
	
	public int size() {
		return size;
	}
	
	//慢
	public E get(int index){
		return this.getElement(index).element;
	}
	
	private Node getElement(int index) {
		Node tmp = head.next;
		for(int i=0;i<index-1;i++){
			tmp = tmp.next;
		}
		return tmp;
	}
	
	//不加static就和实例绑定了
	private /*static*/ class Node{
		private E element = null;
		private Node next = null;
		/*双向链表*/
//		private Node previos = null;

		public Node(E element, Node next) {
			this.element = element;
			this.next = next;
		}
	}
}
