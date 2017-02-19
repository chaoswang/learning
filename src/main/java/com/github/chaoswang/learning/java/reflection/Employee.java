package com.github.chaoswang.learning.java.reflection;

public class Employee {
	private String id;
	private String name;
	private int age;
	
	public Employee(String name, int age) {
		this.id = "1001";
		this.name = name;
		this.age = age;
	}
	
	private String getId(){
		return id;
	}
	
	public void sayHello(){
		System.out.println("hello, name:" + name + ", age:"+age);
	}
}
