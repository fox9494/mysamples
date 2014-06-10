package com.soarsky.octopus.manager.action;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.manager.service.TModelInfoService;

public class TModelInfoDeleteAction extends BaseAction {

	
	private TModelInfoService  tModelInfoService;

	private Long id;

	
	//删除model
	public String deleteModel(){
		
		tModelInfoService.deleteModel(id);
		
		return SUCCESS;
	}
	
	
	public TModelInfoService gettModelInfoService() {
		return tModelInfoService;
	}

	public void settModelInfoService(TModelInfoService tModelInfoService) {
		this.tModelInfoService = tModelInfoService;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
}
