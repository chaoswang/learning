package com.github.chaoswang.book.headfirst.designpattern.strategy;

public class Squeak implements QuackBehavior {
	public void quack() {
		System.out.println("Squeak");
	}
}