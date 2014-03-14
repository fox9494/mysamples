package com.openframe.webservice.hessian;



public class HelloServiceImpl implements HelloService {

	@Override
	public String getHello(String param) {
		return "hello,i am server,"+param;
	}

	

}
