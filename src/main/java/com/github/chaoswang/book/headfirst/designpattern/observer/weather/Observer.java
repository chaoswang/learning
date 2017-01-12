package com.github.chaoswang.book.headfirst.designpattern.observer.weather;

public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
