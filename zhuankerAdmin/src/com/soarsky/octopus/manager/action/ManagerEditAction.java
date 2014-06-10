package com.soarsky.octopus.manager.action;

import java.util.List;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.manager.constant.ManagerErrorMsg;
import com.soarsky.octopus.manager.service.TManagerInfoService;
import com.soarsky.octopus.manager.service.TRoleInfoService;
import com.soarsky.octopus.mapping.TManagerInfo;
import com.soarsky.octopus.mapping.TRoleInfo;

public class ManagerEditAction extends BaseAction {
	
	private TManagerInfoService  tManagerInfoService;
	
	private TRoleInfoService tRoleInfoService;
	
	private List<TRoleInfo>  roleList;
	
	private TManagerInfo  manager;
	
	private Long id;
	
	
	/**
	 * 初始化编辑后台用户界面
	 */
	public String input() {
		manager = tManagerInfoService.findManager(id);
		roleList = tRoleInfoService.findAllRole();
		return super.input();
	}
	
	/**
	 * 编辑后台用户
	 */
	public String save(){
		if (manager!=null){
			tManagerInfoService.editManager(manager);
		}
		return SUCCESS;
	}
	
	/**
	 * 验证用户名是否重复
	 */
	public void validateSave(){
	
		roleList = tRoleInfoService.findAllRole();
	   TManagerInfo tManager=tManagerInfoService.findManager(manager.getId());
	   if(!manager.getUserName().equals(tManager.getUserName())){
		   if(this.tManagerInfoService.judgeUserName(manager.getUserName())){
			   this.addFieldError(ManagerErrorMsg.USERNAME, ManagerErrorMsg.USERNAME_MSG);
		   }
		   
	   }
	   
		
	}
	
	

	public TManagerInfoService gettManagerInfoService() {
		return tManagerInfoService;
	}

	public void settManagerInfoService(TManagerInfoService tManagerInfoService) {
		this.tManagerInfoService = tManagerInfoService;
	}

	public TRoleInfoService gettRoleInfoService() {
		return tRoleInfoService;
	}

	public void settRoleInfoService(TRoleInfoService tRoleInfoService) {
		this.tRoleInfoService = tRoleInfoService;
	}

	public List<TRoleInfo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<TRoleInfo> roleList) {
		this.roleList = roleList;
	}

	public TManagerInfo getManager() {
		return manager;
	}

	public void setManager(TManagerInfo manager) {
		this.manager = manager;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
