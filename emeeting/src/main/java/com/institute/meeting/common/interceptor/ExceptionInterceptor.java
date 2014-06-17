package com.institute.meeting.common.interceptor;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**
 * 异常拦截器
 * @author chenll
 *
 */
public class ExceptionInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = 595538650741616239L;
	private static Logger logger = Logger.getLogger(ExceptionInterceptor.class);

	@Override
	public String intercept(ActionInvocation action) throws Exception {
		String result="";
		
		try {
			result = action.invoke();
			return result;
		} catch (Exception e) {
			StringWriter stringWriter= new StringWriter();
	        PrintWriter writer= new PrintWriter(stringWriter);
	        e.printStackTrace(writer);
	        StringBuffer buffer= stringWriter.getBuffer();
			logger.error(buffer.toString());
			return "error";
		}
		
	}

}
