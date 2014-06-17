package com.institute.meeting.adminuser.action;

import java.util.List;

import com.institute.meeting.adminuser.entity.TAdminRole;
import com.institute.meeting.adminuser.service.AdminRoleService;
import com.institute.meeting.adminuser.service.AdminUserService;
import com.institute.meeting.common.action.BaseAction;
import com.institute.meeting.utils.PageBean;

public class AdminUserListAction extends BaseAction {
	
	private PageBean pageBean;
	
	private AdminUserService adminUserService;
	
	private int currentPage;
	
	private List<TAdminRole>roles;
    
	private AdminRoleService adminRoleService;
	
	/**
	 * 分页查询后台用户
	 * @return
	 */
	public String searchListPage(){
		pageBean = adminUserService.queryPageList(10, currentPage);
		roles=adminRoleService.findAll();
		return SUCCESS;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public AdminUserService getAdminUserService() {
		return adminUserService;
	}

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<TAdminRole> getRoles() {
		return roles;
	}

	public void setRoles(List<TAdminRole> roles) {
		this.roles = roles;
	}

	public void setAdminRoleService(AdminRoleService adminRoleService) {
		this.adminRoleService = adminRoleService;
	}
}
