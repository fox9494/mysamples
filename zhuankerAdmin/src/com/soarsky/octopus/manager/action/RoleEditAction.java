package com.soarsky.octopus.manager.action;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.constant.TRoleInfoErrorMsg;
import com.soarsky.octopus.manager.service.TRoleInfoService;
import com.soarsky.octopus.mapping.TRoleInfo;

public class RoleEditAction extends BaseAction {
	
	
	private TRoleInfoService tRoleInfoService;
	
	private TRoleInfo  role;
	
	private Long id;

	/**
	 * 编辑角色名
	 * @return
	 */
	public String edit() {
		if (role!=null){
			tRoleInfoService.editRole(role);
		}
		return SUCCESS;
	}

	
	/**
	 * 初始化角色信息
	 */
	public String input() {
		role = tRoleInfoService.findRole(id);
		return INPUT;
	}
	
	/**
	 * 验证角色名
	 * @return
	 */
	public void validateEdit(){
		
		TRoleInfo tRole=this.tRoleInfoService.findRole(role.getId());
		if(!role.getRoleName().equals(tRole.getRoleName())){
			if(this.tRoleInfoService.judgeRoleName(role.getRoleName())){
				this.addFieldError(TRoleInfoErrorMsg.ROLENAME, TRoleInfoErrorMsg.ROLENAME_MSG);
			}
			
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}







	
	
	
	
	

}
