package com.soarsky.octopus.task.action;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.task.service.TCompanyService;

public class CompanyDeleteAction extends BaseAction {

	private static final long serialVersionUID = -8562745511121980797L;
	
    private TCompany tCompany;
	
	private TCompanyService tCompanyService;
	
	private String info;
    
	/**
	 * 删除对象
	 * @author lw
	 * @return
	*/
	public String removeUserClient(){
		
	    tCompanyService.deleteUser(info);
	
		return SUCCESS;
	}

	public TCompany gettCompany() {
		return tCompany;
	}

	public void settCompany(TCompany tCompany) {
		this.tCompany = tCompany;
	}

	public TCompanyService gettCompanyService() {
		return tCompanyService;
	}

	public void settCompanyService(TCompanyService tCompanyService) {
		this.tCompanyService = tCompanyService;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
