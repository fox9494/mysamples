package com.institute.meeting.adminuser.action;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.institute.meeting.adminuser.entity.TAdminusers;
import com.institute.meeting.adminuser.service.AdminUserService;
import com.institute.meeting.common.action.BaseAction;

public class LoginAction extends BaseAction {
	
	private static final long serialVersionUID = -5618671706912529539L;
	
	private static Logger logger = Logger.getLogger(LoginAction.class);

	private AdminUserService  adminUserService;
	
	private String userName;
	
	private String password;
	
	
	
	/**
	 * 登录验证
	 * @return
	 */
	public String login(){
		logger.info("the userName:"+userName+" is logging");
		TAdminusers adminUser = adminUserService.login(userName, password);
		if (adminUser!=null){
			HttpSession session = request.getSession();
			session.setAttribute("username", adminUser.getUserAccount());
			session.setAttribute("userId", adminUser.getUserId());
			return SUCCESS;
		}else{
			this.addFieldError("failed", "用户名或者密码错误");
			return INPUT;
		}
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
	

	public AdminUserService getAdminUserService() {
		return adminUserService;
	}

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
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

}
