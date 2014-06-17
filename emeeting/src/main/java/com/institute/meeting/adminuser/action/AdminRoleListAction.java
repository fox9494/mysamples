package com.institute.meeting.adminuser.action;

import java.util.List;

import com.institute.meeting.adminuser.entity.TAdminRole;
import com.institute.meeting.adminuser.service.AdminRoleService;
import com.institute.meeting.adminuser.vo.RoleInfoVO;
import com.institute.meeting.common.action.BaseAction;
import com.institute.meeting.utils.PageBean;

public class AdminRoleListAction extends BaseAction {
	
	private static final long serialVersionUID = 1887508375305841865L;

	private AdminRoleService adminRoleService;
	
	private  List<RoleInfoVO>  roleList;
	
	private PageBean pageBean; 
	
	private int currentPage;
	
	private TAdminRole role;
	 

	public String searchAllRole(){
		
		roleList = adminRoleService.findRoleRight();
	
		return SUCCESS;
	}
	
	/**
	 * 分页查找
	 * @return
	 */
	public String searchListPage(){
		pageBean = adminRoleService.queryListPage(PageBean.DEFAULTPAGESIZE, currentPage, role);
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




	public PageBean getPageBean() {
		return pageBean;
	}




	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public TAdminRole getRole() {
		return role;
	}

	public void setRole(TAdminRole role) {
		this.role = role;
	}

}
