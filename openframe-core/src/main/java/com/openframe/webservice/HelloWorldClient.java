package com.openframe.webservice;

public class HelloWorldClient {
	
	private HelloWorld service;
	
	
	
	public String printHello(){
		return service.getHelloWorld("test",new TestEntity("jon",78));
	}

	public HelloWorld getService() {
		return service;
	}

	public void setService(HelloWorld service) {
		this.service = service;
	}
	
	

}
