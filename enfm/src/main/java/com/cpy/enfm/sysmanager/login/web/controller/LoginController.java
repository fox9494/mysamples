package com.cpy.enfm.sysmanager.login.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpy.enfm.sysmanager.user.service.AdminUserService;
import com.google.code.kaptcha.Constants;

@Controller
public class LoginController {
	
	
	@Autowired
	private AdminUserService adminUserService;

	
	/**
	 * 登录验证
	 * @return
	 */
	@RequestMapping(value="/login.do")
	public String loginOn(HttpServletRequest request){
		//获取验证码
		String kaptcha=(String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		System.out.print(kaptcha);
		return "frame/index.jsp";
	}

}
