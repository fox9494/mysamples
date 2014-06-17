package com.institute.meeting.adminuser.action;

import java.util.List;

import com.institute.meeting.adminuser.service.AdminUserService;
import com.institute.meeting.adminuser.vo.MenuVO;
import com.institute.meeting.common.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

public class MenuAction extends BaseAction {

	private static final long serialVersionUID = 8896783550508727136L;
	
	
	
	private AdminUserService adminUserService;
	
	private List<MenuVO>   list;
	
	public String getMenus(){
		Integer uid = (Integer)ActionContext.getContext().getSession().get("userId");
		list = adminUserService.getAdminUserMenus(uid);
		return SUCCESS;
		
	}


	


	public List<MenuVO> getList() {
		return list;
	}

	public void setList(List<MenuVO> list) {
		this.list = list;
	}





	public AdminUserService getAdminUserService() {
		return adminUserService;
	}





	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	

	
	
}
