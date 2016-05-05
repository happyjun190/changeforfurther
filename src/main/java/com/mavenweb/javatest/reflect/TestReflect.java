package com.mavenweb.javatest.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TestReflect {
	
	
	static class Person {
		private String name;
		private int age;
		
		public void setName(String name) {
			this.name = name;
		}
		public void setAge(int age) {
			this.age = age;
		}
		//public String getName(String params) {
		public String getName() {
			//System.out.println(" --> this is the method's params :  " + params);
			return name;
		}
		public int getAge() {
			return age;
		}
		
	}
	
	
	public static void main(String args[]) {
		
		//===================test1========================
		Person person = new Person();
		person.setName("nameTest");
		person.setAge(111);
		
		Class<? extends Person> class1 = person.getClass();
		try {
			Method method = class1.getDeclaredMethod("getName");
			String name = (String) method.invoke(person);
			System.out.println(name);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		//===================test2========================
		try {
			Class class2 = Class.forName("java.util.Stack");
			Method[] method2 = class2.getDeclaredMethods();
			for(Method method : method2) {
				System.out.println(method.toString());
			}
		} catch (ClassNotFoundException | SecurityException e) {
			e.printStackTrace();
		}
		
		
		//===================test3========================
		try {
			ReflectPointer reflectPointer = new ReflectPointer(3, 4);
			Field fieldx = reflectPointer.getClass().getField("x");
			System.out.println("fieldx's value is ---> " + fieldx.get(reflectPointer));
			
			Field fieldy = reflectPointer.getClass().getDeclaredField("y");
			fieldy.setAccessible(true);
			System.out.println("fieldy's value is ---> " + fieldy.get(reflectPointer));
			
		} catch (NoSuchFieldException | SecurityException | IllegalAccessException | IllegalArgumentException  e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}


class ReflectPointer {
	
	public int x = 0;
	private int y = 0;
	
	public ReflectPointer(int x,int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
