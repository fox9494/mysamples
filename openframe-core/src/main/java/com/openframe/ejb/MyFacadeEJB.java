package com.openframe.ejb;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;


@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class MyFacadeEJB   implements MyFacadeLocal {
	
	
	@Autowired
	private MyComponent myComponent;


	@Override
	public void myFacadeMethod() {
		 myComponent.myMethod();
	}

}
