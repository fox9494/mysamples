package com.soarsky.octopus.manager.action;

import java.util.HashMap;
import java.util.Map;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.service.TRoleInfoService;
import com.soarsky.octopus.mapping.TRoleInfo;

public class RoleDeleteAction extends BaseAction {
	
	
	private TRoleInfoService tRoleInfoService;
	
	
	private Long id;
	
	private String judgeRoleName;
	
	private Map<String,Object> resultMap;
	

	
	
	/**
	 * 删除角色
	 */
	public String delete() {
		tRoleInfoService.deleteRole(id);
		return SUCCESS;
	}
	/**
	 * 判断该角色下是否有用户
	 * @return
	 */
	public String  judgeMgrRole(){
		
		resultMap=new HashMap<String,Object>();
		if(this.tRoleInfoService.judgeRoleUser(id)){
			
			resultMap.put("judgeName", JEEContant.NOTROMOVE);			
		}
		else{			
			resultMap.put("judgeName", JEEContant.ROMOVE);
		}
		
		return SUCCESS;
	}

	public TRoleInfoService gettRoleInfoService() {
		return tRoleInfoService;
	}

	public void settRoleInfoService(TRoleInfoService tRoleInfoService) {
		this.tRoleInfoService = tRoleInfoService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJudgeRoleName() {
		return judgeRoleName;
	}

	public void setJudgeRoleName(String judgeRoleName) {
		this.judgeRoleName = judgeRoleName;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	
	
	

	
	
	

	







	
	
	
	
	

}
