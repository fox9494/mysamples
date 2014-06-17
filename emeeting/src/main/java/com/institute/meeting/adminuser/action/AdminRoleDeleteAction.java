package com.institute.meeting.adminuser.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;

import com.institute.meeting.adminuser.entity.TAdminRole;
import com.institute.meeting.adminuser.service.AdminRightService;
import com.institute.meeting.adminuser.service.AdminRoleService;
import com.institute.meeting.adminuser.service.ModelService;
import com.institute.meeting.common.action.BaseAction;
import com.institute.meeting.common.entity.TreeModel;

public class AdminRoleDeleteAction extends BaseAction {
	
	private static final long serialVersionUID = -1562408777273473400L;

	private AdminRoleService adminRoleService;
	
	private ModelService  modelService;
	
	private AdminRightService adminRightService;
	
	private TAdminRole role;
	
	
	
	
	public String deleteRole(){
		
		return SUCCESS;
	}
	
	public boolean hasValidatorErrors(){
		
		
		
		
		return this.hasFieldErrors();
	}
	
	/**
	 * 编辑角色
	 * @return
	 */

	public AdminRoleService getAdminRoleService() {
		return adminRoleService;
	}

	public void setAdminRoleService(AdminRoleService adminRoleService) {
		this.adminRoleService = adminRoleService;
	}

	public ModelService getModelService() {
		return modelService;
	}

	public void setModelService(ModelService modelService) {
		this.modelService = modelService;
	}

	public TAdminRole getRole() {
		return role;
	}

	public void setRole(TAdminRole role) {
		
		this.role = role;
	}


	public AdminRightService getAdminRightService() {
		return adminRightService;
	}

	public void setAdminRightService(AdminRightService adminRightService) {
		this.adminRightService = adminRightService;
	}



}
