package com.soarsky.octopus.demo;

import com.opensymphony.xwork2.ActionSupport;

public class DemoAction2 extends ActionSupport {
	
	private String test;
	
	private String fk;

	@Override
	public String execute() throws Exception {
		test="hello";
		fk="this is test";
		return SUCCESS;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getFk() {
		return fk;
	}

	public void setFk(String fk) {
		this.fk = fk;
	}
	
	
	

}
