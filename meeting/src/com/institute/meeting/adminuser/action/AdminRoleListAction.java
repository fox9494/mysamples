package com.institute.meeting.adminuser.action;

import java.util.List;

import com.institute.meeting.adminuser.service.AdminRoleService;
import com.institute.meeting.adminuser.vo.RoleInfoVO;
import com.institute.meeting.common.action.BaseAction;

public class AdminRoleListAction extends BaseAction {
	
	private static final long serialVersionUID = 1887508375305841865L;

	private AdminRoleService adminRoleService;
	
	private  List<RoleInfoVO>  roleList;
	 

	public String searchAllRole(){
		
		roleList = adminRoleService.findRoleRight();
	
		return SUCCESS;
	}
	

	
	
	public AdminRoleService getAdminRoleService() {
		return adminRoleService;
	}

	public void setAdminRoleService(AdminRoleService adminRoleService) {
		this.adminRoleService = adminRoleService;
	}

	public List<RoleInfoVO> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleInfoVO> roleList) {
		this.roleList = roleList;
	}

}
