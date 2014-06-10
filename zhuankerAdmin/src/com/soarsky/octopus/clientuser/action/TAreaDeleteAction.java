package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.service.TAreaService;
import com.soarsky.octopus.common.action.BaseAction;

public class TAreaDeleteAction extends BaseAction {
	
	private Long id;
	
	private TAreaService tAreaService;
	
	
	//删除区域
	public String deleteArea(){
		
		this.tAreaService.deleteArea(id);
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TAreaService gettAreaService() {
		return tAreaService;
	}
	
	public void settAreaService(TAreaService tAreaService) {
		this.tAreaService = tAreaService;
	}
	
	
	
	
	
	
	
	

}
