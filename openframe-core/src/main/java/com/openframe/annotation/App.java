package com.openframe.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {

	/**
	 * @param args
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		App app = new App();
		Method[] methods = App.class.getDeclaredMethods();
		
		for (Method method : methods) {
			Hello anno = method.getAnnotation(Hello.class);
			if (anno!=null){
				System.out.println(anno.value());
				method.invoke(app,null);
			}
			
		}
	}
	
	
	@Hello(value="22")
	public void ab(){
		System.out.println("hello");
	}

}
