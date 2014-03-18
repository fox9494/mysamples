package com.openframe.webservice;

import java.io.Serializable;

public class TestEntity implements Serializable{
	
	private String name;
	
	private int age;

	public String getName() {
		return name;
	}

	public TestEntity() {
		super();
	}

	public TestEntity(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "TestEntity [name=" + name + ", age=" + age + "]";
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
