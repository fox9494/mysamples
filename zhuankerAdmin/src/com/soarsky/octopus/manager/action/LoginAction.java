package com.soarsky.octopus.manager.action;


import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.service.TManagerInfoService;
import com.soarsky.octopus.mapping.TManagerInfo;
import com.soarsky.octopus.utils.CodeLevelUtil;
import com.soarsky.octopus.utils.MD5Util;

public class LoginAction extends BaseAction {
	
	private static final long serialVersionUID = -5618671706912529539L;
	
	private static Logger logger = Logger.getLogger(LoginAction.class);

	private TManagerInfoService  tManagerInfoService;
	
	private String userName;
	
	private String password;
	
	
	
	
	/**
	 * 登录验证
	 * @return
	 */
	public String login(){
		logger.info("the user["+userName+"] is logining");
		if(!checkParameter()){
			return INPUT;
		}
		TManagerInfo user = tManagerInfoService.login(userName,MD5Util.getMD5(password));
		if (user!=null&&user.getIsRemove()==JEEContant.NOTROMOVE){
			Map<String, Object> session = this.getSession();
			session.put(JEEContant.SESSION_LOGIN_TOKENNAME, user.getUserName());
			session.put(JEEContant.SESSION_LOGIN_TOKENID, user.getId());
			session.put(JEEContant.SESSION_LOGIN_TOKENREAL, user.getRealName());
			return SUCCESS;
		}else{
			this.addFieldError("failed", "用户名不存在或者密码错误");
			return INPUT;
		}
	}
	
	/**
	 * 注销登录
	 * @return
	 */
	public String loginOut(){
		Map<String, Object> session = this.getSession();
		logger.info("the user["+session.get(JEEContant.SESSION_LOGIN_TOKENNAME)+"] loginOut");
		session.remove(JEEContant.SESSION_LOGIN_TOKENNAME);
		session.remove(JEEContant.SESSION_LOGIN_TOKENID);
		return SUCCESS;
	}
	
	/**
	 * 退出系统
	 * 
	 * @return
	 */
	public String exit() {
		request.getSession().invalidate();
		return "exit_success";
	}
	

	


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public TManagerInfoService gettManagerInfoService() {
		return tManagerInfoService;
	}

	public void settManagerInfoService(TManagerInfoService tManagerInfoService) {
		this.tManagerInfoService = tManagerInfoService;
	}
    
	private boolean checkParameter(){
		boolean isCheck = true;
		if(StringUtils.isBlank(userName)){
			this.addFieldError("failed","请输入用户名");
			isCheck = false;
		}
        if(StringUtils.isBlank(password)){
        	this.addFieldError("failed","请输入密码");
        	isCheck = false;
		}
		return isCheck;
	}
}
