package com.openframe.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


@WebService
@SOAPBinding(style=Style.RPC)
public interface HelloWorld {
	
	@WebMethod
	public String getHelloWorld(String param);

}