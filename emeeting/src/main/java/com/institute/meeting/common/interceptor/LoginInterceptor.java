package com.institute.meeting.common.interceptor;

import java.util.Map;

import org.apache.log4j.Logger;

import com.institute.meeting.adminuser.action.LoginAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	final static private Logger logger = Logger
			.getLogger(LoginInterceptor.class);

	public LoginInterceptor() {
		super();
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		
		if ((invocation.getAction() instanceof LoginAction) || isLogined()){
			return invocation.invoke();
		}
		else
			return "notLogin";
	}

	/**
	 * 判断是否登录过
	 * 
	 * @return
	 */
	private boolean isLogined() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		return session.get("username") == null ? false : true;
	}

	public void destroy() {
		logger.info("the logininterceptor destroied");
	}

	public void init() {
		logger.info("the logininterceptor is starting");
	}

}
