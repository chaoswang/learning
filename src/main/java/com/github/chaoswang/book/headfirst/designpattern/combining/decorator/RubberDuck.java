package com.github.chaoswang.book.headfirst.designpattern.combining.decorator;

public class RubberDuck implements Quackable {
 
	public void quack() {
		System.out.println("Squeak");
	}
  
	public String toString() {
		return "Rubber Duck";
	}
}
