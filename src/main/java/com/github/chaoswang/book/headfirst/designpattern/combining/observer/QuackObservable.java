package com.github.chaoswang.book.headfirst.designpattern.combining.observer;

public interface QuackObservable {
	public void registerObserver(Observer observer);
	public void notifyObservers();
}
