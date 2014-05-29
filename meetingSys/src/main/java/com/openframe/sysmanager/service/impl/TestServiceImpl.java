package com.openframe.sysmanager.service.impl;

import com.openframe.sysmanager.service.TestService;

public class TestServiceImpl implements TestService {
	
	private String  name;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void print() {
		System.out.println("我的名字是:"+name);
		
	}


}
