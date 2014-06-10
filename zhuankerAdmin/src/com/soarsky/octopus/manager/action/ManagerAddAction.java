package com.soarsky.octopus.manager.action;

import java.util.Date;
import java.util.List;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.constant.ManagerErrorMsg;
import com.soarsky.octopus.manager.service.TManagerInfoService;
import com.soarsky.octopus.manager.service.TRoleInfoService;
import com.soarsky.octopus.mapping.TManagerInfo;
import com.soarsky.octopus.mapping.TRoleInfo;
import com.soarsky.octopus.utils.MD5Util;

public class ManagerAddAction extends BaseAction {
	
	private TManagerInfoService  tManagerInfoService;
	
	private TRoleInfoService tRoleInfoService;
	
	private List<TRoleInfo>  roleList;
	
	private TManagerInfo  manager;
	
	
	/**
	 * 初始化后台用户
	 */
	public String input() {
		roleList = tRoleInfoService.findAllRole();
		return super.input();
	}
	
	
	/**
	 * 增加后台用户
	 */
	public String save() {
		if (manager!=null){
			manager.setPassword(MD5Util.getMD5(JEEContant.initPassword));
			manager.setCreateDate(new Date());
			manager.setIsRemove(JEEContant.NOTROMOVE);
			tManagerInfoService.save(manager);
			
		}
		return super.save();
	}
	/**
	 * 验证后台用户
	 * @return
	 */
	public void validateSave(){
		
		if(tManagerInfoService.judgeUserName(manager.getUserName())){
			
			this.addFieldError(ManagerErrorMsg.USERNAME, ManagerErrorMsg.USERNAME_MSG);
		
		}
		this.input();
		
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





	

	

}
