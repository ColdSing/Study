package com.fxx.test;

import java.lang.reflect.Field;

@SuppressWarnings("all")
public class TestReflect {

	public static void main(String[] args) {
		String path = "com.fxx.test.Demo1";
		try {
			Class<Demo1> clazz = (Class<Demo1>)Class.forName(path);
			try {
				Demo1 d = clazz.newInstance();
				Field f = clazz.getDeclaredField("studentName");
				f.setAccessible(true);
				f.set(d, "fxx");
				System.out.println(d.getStudentName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
