package com.openframe.webservice.hessian;

import com.openframe.webservice.TestEntity;



public class HelloServiceImpl implements HelloService {

	@Override
	public String getHello(String param,TestEntity entity) {
		return "Hello World Hessian:"+param+",object:"+entity.toString();
	}

	

}
