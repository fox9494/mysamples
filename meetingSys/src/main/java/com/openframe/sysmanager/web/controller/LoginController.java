package com.openframe.sysmanager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	
	/**
	 * 初始化登录
	 * @return
	 */
	@RequestMapping(value="/logininit.do")
	public String initLogin(){
		return "login";
	}
	
	
	/**
	 * 登录处理
	 * @return
	 */
	@RequestMapping(value="/login.do")
	public String login(){
		return "main";
	}

}
