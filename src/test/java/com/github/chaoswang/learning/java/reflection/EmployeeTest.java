package com.github.chaoswang.learning.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testCreateEmployee() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//通过反射的方式创建Employee的实例
//		Class<?> employeeClass = Class.forName("com.github.chaoswang.learning.java.reflection.Employee");
//		Class<?> employeeClass = Employee.class;
		Employee employeeObject = new Employee("wc", 31);
		Class<?> employeeClass = employeeObject.getClass();
		Constructor<?> employeeConstructor = employeeClass.getConstructor(String.class, int.class);
		Employee employee = (Employee)employeeConstructor.newInstance("wangchao", 31);
		employee.sayHello();
		
		//通过反射调用sayHello()方法
		Method sayHelloMethod = employeeClass.getMethod("sayHello");
		sayHelloMethod.invoke(employeeObject);
		
		//通过反射调用getID()方法
		Method getIdMethod = employeeClass.getDeclaredMethod("getId");
		getIdMethod.setAccessible(true);
		getIdMethod.invoke(employeeObject);
		
		//打印出每个字段
		for(Field field : employeeClass.getDeclaredFields()){
			System.out.println(field.getModifiers() + " " + field.getType() + " " + field.getName());
		}
	}
	
	@Test
	public void testPutStringIntoIntegerArrayList() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//通过反射向该ArrayList<Integer>中加入一个String类型的元素
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.getClass().getMethod("add", Object.class).invoke(list, "String");
		System.out.println(list);
	}
}
    
  