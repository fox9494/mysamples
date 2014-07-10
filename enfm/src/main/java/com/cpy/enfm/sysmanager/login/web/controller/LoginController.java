package com.cpy.enfm.sysmanager.login.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Constants;

@Controller
public class LoginController {

	
	/**
	 * 登录验证
	 * @return
	 */
	@RequestMapping(value="/login.do")
	public String loginOn(HttpServletRequest request){
		//获取验证码
		request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		return "frame/index.jsp";
	}

}
