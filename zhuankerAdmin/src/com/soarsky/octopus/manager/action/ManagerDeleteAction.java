package com.soarsky.octopus.manager.action;

import java.util.HashMap;
import java.util.Map;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.service.TManagerInfoService;

public class ManagerDeleteAction extends BaseAction {
	
	private TManagerInfoService  tManagerInfoService;
	
	private String ids;
	
	private Map<String,Object> resultMap;
	
	

	//删除用户
	public String delete() {
		tManagerInfoService.deleteManagers(ids);
		return SUCCESS;
	}
	
	//验证用户下面是否有渠道
	public String judgeMgrChannel(){
		
		resultMap=new HashMap<String,Object>();
		boolean flag=this.tManagerInfoService.judgeMgrChannel(ids);
		if(flag){
			resultMap.put("judgeName", JEEContant.NOTROMOVE);
		}
		else{
			
			resultMap.put("judgeName", JEEContant.ROMOVE);
		}
		return SUCCESS;
	}

	public TManagerInfoService gettManagerInfoService() {
		return tManagerInfoService;
	}

	public void settManagerInfoService(TManagerInfoService tManagerInfoService) {
		this.tManagerInfoService = tManagerInfoService;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	

	
	

}
