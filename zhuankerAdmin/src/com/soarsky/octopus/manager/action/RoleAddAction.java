package com.soarsky.octopus.manager.action;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.constant.TRoleInfoErrorMsg;
import com.soarsky.octopus.manager.service.TRoleInfoService;
import com.soarsky.octopus.mapping.TRoleInfo;

public class RoleAddAction extends BaseAction {
	
	
	private TRoleInfoService tRoleInfoService;
	
	private TRoleInfo  role;

	
	/**
	 * 新增角色
	 */
	public String save() {
		if (role!=null){
			role.setIsRemove(JEEContant.NOTROMOVE);
			tRoleInfoService.addRole(role);
		}
		return SUCCESS;
	}
	
	/**
	 * 角色名验证
	 * @return
	 */
	public void validateSave(){
		
		if(this.tRoleInfoService.judgeRoleName(role.getRoleName())){
			
		   this.addFieldError(TRoleInfoErrorMsg.ROLENAME, TRoleInfoErrorMsg.ROLENAME_MSG);
		}
		
	}

	
	

	public TRoleInfoService gettRoleInfoService() {
		return tRoleInfoService;
	}

	public void settRoleInfoService(TRoleInfoService tRoleInfoService) {
		this.tRoleInfoService = tRoleInfoService;
	}




	public TRoleInfo getRole() {
		return role;
	}




	public void setRole(TRoleInfo role) {
		this.role = role;
	}
	
	
	
	
	

}
