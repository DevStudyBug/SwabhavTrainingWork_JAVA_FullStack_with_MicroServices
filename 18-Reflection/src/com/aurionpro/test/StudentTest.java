package com.aurionpro.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.aurionpro.model.Student;

public class StudentTest {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		// method1
		Student student = new Student();
		System.out.println("get class: " + student.getClass());
		// method 2
		Class c = Student.class;
		System.out.println("Get name of class: " + c.getName());

		System.out.println("----");

		System.out.println("------------Fields are---------- ");
		Field[] fields = c.getDeclaredFields();
		for (Field result : fields) {
			System.out.println(result.getName());
		}

		System.out.println("---------Methods are:---------- ");
		for (Method methods : c.getDeclaredMethods()) {
			System.out.println(methods.getName());
			System.out.println("type " + methods.getReturnType());
			System.out.println("Modifier: " + Modifier.toString(methods.getModifiers()));

		}

		System.out.println("----------------------------");
		System.out.println("Constuctors are :");
		Constructor[] construct = c.getConstructors();
		for (Constructor reuslts : construct) {
			System.out.println("Constructor name: ]" + reuslts.getName());
		}

		System.out.println("------cgpa-------");
		Field fields1 = c.getDeclaredField("cgpa");
		fields1.setAccessible(true);
		System.out.println("cgpa is: " + fields1.get(student));

		Method method = c.getDeclaredMethod("Greet");
		method.setAccessible(true);
		method.invoke(student);
		System.out.println("-----final-----");

		System.out.println("------cgpa-------");
		Field fields2 = c.getDeclaredField("marks");
		fields2.setAccessible(true);
		System.out.println("marks is: " + fields2.get(student));
		fields2.set(student, 30);
		System.out.println("modified marks : "+ fields2.get(student));
		
		System.out.println("interface"+c.isInterface());
		System.out.println(c.isEnum());
		System.out.println(c.isArray());
		System.out.println(c.isLocalClass());
		
		System.out.println(c.getSuperclass());
	}
}
