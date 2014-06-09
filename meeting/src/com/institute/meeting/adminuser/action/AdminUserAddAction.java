package com.institute.meeting.adminuser.action;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.institute.meeting.adminuser.entity.TAdminRole;
import com.institute.meeting.adminuser.entity.TAdminusers;
import com.institute.meeting.adminuser.service.AdminRoleService;
import com.institute.meeting.adminuser.service.AdminUserService;
import com.institute.meeting.common.action.BaseAction;
import com.institute.meeting.utils.Validate;

public class AdminUserAddAction extends BaseAction {
	
	private static final long serialVersionUID = 3518354908523976019L;

	private TAdminusers   adminUser;
	
	private AdminUserService adminUserService;
	
	private AdminRoleService adminRoleService;
	
	private List<TAdminRole>   roleList;
	
	
	
	
	public String addUser(){
		if (this.hasValidatorErrors()){
			roleList = adminRoleService.findAllRole();
			return INPUT;
		}
		
		adminUser.setCreateDate(new Date());
		adminUserService.addUser(adminUser);
		
		return SUCCESS;
	}
	
	public boolean hasValidatorErrors(){
		if(adminUserService.findByName(adminUser.getUserAccount())){
			this.addFieldError("adminUser.hasExist", "该用户名已被使用");
		}
		if (StringUtils.isBlank(adminUser.getUserAccount())){
			this.addFieldError("adminUser.userAccount", "请输入用户名");
		}
		
		if (!Validate.isAllowRegisterName(adminUser.getUserAccount())){
			this.addFieldError("adminUser.userAccount", "用户名只能输入汉字或者字母或者数字");
		}
		
		return this.hasFieldErrors();
	}
	
	public String initAddAdmin(){
		roleList = adminRoleService.findAllRole();
		return INPUT;
	}

	public TAdminusers getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(TAdminusers adminUser) {
		this.adminUser = adminUser;
	}

	public AdminUserService getAdminUserService() {
		return adminUserService;
	}

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	 
	

	public AdminRoleService getAdminRoleService() {
		return adminRoleService;
	}


	public void setAdminRoleService(AdminRoleService adminRoleService) {
		this.adminRoleService = adminRoleService;
	}


	public List<TAdminRole> getRoleList() {
		return roleList;
	}


	public void setRoleList(List<TAdminRole> roleList) {
		this.roleList = roleList;
	}
	
	
	

}
