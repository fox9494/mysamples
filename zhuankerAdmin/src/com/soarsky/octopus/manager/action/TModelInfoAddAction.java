package com.soarsky.octopus.manager.action;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.manager.service.TModelInfoService;
import com.soarsky.octopus.mapping.TModelInfo;

public class TModelInfoAddAction extends BaseAction {
	
	private TModelInfoService  tModelInfoService;
	
	private TModelInfo tmodel;
	
	private Long parentId;
	
	private TModelInfo tmodelx;

	

	//添加Model
	public String addModel()
	{
		
		tModelInfoService.addModel(parentId, tmodel);
		return SUCCESS;
	}
	
	//根据Id查询modelinfo
	public String findModelInfo(){
		
		tmodelx=tModelInfoService.findModelInfo(tmodelx.getId());
		
		return INPUT;
	}
	
	
	
	
	public TModelInfoService gettModelInfoService() {
		return tModelInfoService;
	}

	public void settModelInfoService(TModelInfoService tModelInfoService) {
		this.tModelInfoService = tModelInfoService;
	}
	
	
	
	public TModelInfo getTmodel() {
		return tmodel;
	}

	public void setTmodel(TModelInfo tmodel) {
		this.tmodel = tmodel;
	}	

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public TModelInfo getTmodelx() {
		return tmodelx;
	}

	public void setTmodelx(TModelInfo tmodelx) {
		this.tmodelx = tmodelx;
	}

}
