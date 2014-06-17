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

public class AdminUserEditAction extends BaseAction {
       private TAdminusers adminUser; 
       private AdminUserService adminUserService;
       private int userId;
       private AdminRoleService adminRoleService;   	
       private List<TAdminRole>   roleList;
       private String oldAdminUser;
       public String EditAdminUser(){
    	   if (this.hasValidatorErrors()){
   			roleList = adminRoleService.findAll();
   			return INPUT;
   		   }
    	   adminUser.setEditDate(new Date());
    	   this.adminUserService.updateAdminUser(adminUser);
    	   return SUCCESS;
       }
       
       public String initEditAdmin(){
    	   adminUser=this.adminUserService.findByAdminUser(userId);
    	   roleList=this.adminRoleService.findAll();
    	   oldAdminUser=adminUser.getUserAccount();
    	   return INPUT;
       }
       
       public boolean hasValidatorErrors(){
    	if(!adminUser.getUserAccount().equals(oldAdminUser)){
   		  if(adminUserService.findByName(adminUser.getUserAccount())){
   			this.addFieldError("adminUser.hasExist", "该用户名已被使用");
   		  }
   		}
   		if (StringUtils.isBlank(adminUser.getUserAccount())){
   			this.addFieldError("adminUser.userAccount", "请输入用户名");
   		}
   		if (!Validate.isAllowRegisterName(adminUser.getUserAccount())){
   			this.addFieldError("adminUser.userAccount", "用户名只能输入汉字或者字母或者数字");
   		}
   		
   		return this.hasFieldErrors();
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getOldAdminUser() {
		return oldAdminUser;
	}

	public void setOldAdminUser(String oldAdminUser) {
		this.oldAdminUser = oldAdminUser;
	}   
       
}
