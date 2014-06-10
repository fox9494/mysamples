package com.soarsky.octopus.manager.action;

import java.util.List;

import com.soarsky.octopus.clientuser.vo.TreeData;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.manager.service.TModelInfoService;

public class TModelInfoListAction extends BaseAction {
	
	private TModelInfoService  tModelInfoService;
	
	private List<TreeData> resultList;
	

	public TModelInfoService gettModelInfoService() {
		return tModelInfoService;
	}

	public void settModelInfoService(TModelInfoService tModelInfoService) {
		this.tModelInfoService = tModelInfoService;
	}
	
	
	public List<TreeData> getResultList() {
		return resultList;
	}

	public void setResultList(List<TreeData> resultList) {
		this.resultList = resultList;
	}

	public String tModelList(){
		
//		resultList=this.tModelInfoService.findAllModel();
		resultList = tModelInfoService.findAllModelForTree();
		return SUCCESS;
	}
	

}
