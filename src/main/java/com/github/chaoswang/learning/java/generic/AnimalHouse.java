package com.github.chaoswang.learning.java.generic;

public class AnimalHouse<E> {
	private E animal;
	public AnimalHouse(){
		animal = (E)new Object();
	}
}
