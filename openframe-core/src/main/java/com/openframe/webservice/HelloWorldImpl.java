package com.openframe.webservice;

import javax.jws.WebService;


@WebService(endpointInterface="com.openframe.webservice.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorld(String param,TestEntity entity) {
		return "Hello World JAX-WS:"+param+",object:"+entity.toString();
	}

}
