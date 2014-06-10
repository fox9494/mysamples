package com.soarsky.octopus.manager.action;

import com.soarsky.octopus.manager.service.TVersionService;
import com.soarsky.octopus.mapping.TVersion;
import com.soarsky.octopus.utils.PageBean;
import com.soarsky.octopus.common.action.PageAction;

public class ManagerVersionListAction extends PageAction {
	
	private static final long serialVersionUID = 8004475630111156851L;
	
	private TVersionService tVersionService;
	
	private TVersion tversion;
	
	
	//版本列表
	public String versionList(){
		pageBean=this.tVersionService.getAllVersions(PageBean.DEFAULTPAGESIZE, currentPage, tversion);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	

	public TVersionService gettVersionService() {
		return tVersionService;
	}

	public void settVersionService(TVersionService tVersionService) {
		this.tVersionService = tVersionService;
	}

	public TVersion getTversion() {
		return tversion;
	}

	public void setTversion(TVersion tversion) {
		this.tversion = tversion;
	}
	
	
	

}
