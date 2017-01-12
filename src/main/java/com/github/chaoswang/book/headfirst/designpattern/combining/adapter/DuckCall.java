package com.github.chaoswang.book.headfirst.designpattern.combining.adapter;

public class DuckCall implements Quackable {
	public void quack() {
		System.out.println("Kwak");
	}
}
