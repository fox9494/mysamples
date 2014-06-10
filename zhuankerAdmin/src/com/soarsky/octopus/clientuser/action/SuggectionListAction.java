package com.soarsky.octopus.clientuser.action;

import java.util.Date;

import com.soarsky.octopus.clientuser.service.TSuggectionService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.mapping.TSuggection;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.utils.PageBean;

public class SuggectionListAction extends PageAction {

	private static final long serialVersionUID = -1005025586741253950L;
    
	private TSuggectionService  tSuggectionService;
	
	private TSuggection suggection;
	
	private TUserClient userClient;
	
	private Date startDate;
	
	private Date endDate;
	/**
	 * 分页查询所有反馈信息
	 * @author lw
	 * @return
	*/
	public String  searchList(){
		
	    pageBean=tSuggectionService.getSuggectionList(PageBean.DEFAULTPAGESIZE, currentPage);
		
		return SUCCESS;
	}
	
    /**
     * 根据条件查询反馈信息
     * @author lw
     * @return
	*/
	public String  findSuggectionByCondition(){
		
		TSuggection  newSuggection=new TSuggection();
		
		newSuggection.setTUserClient(userClient);
		
		pageBean=tSuggectionService.getSuggectionByConditions(PageBean.DEFAULTPAGESIZE, currentPage, newSuggection,startDate,endDate);
		
		return "findbyconditions";
	}
	public TSuggectionService gettSuggectionService() {
		return tSuggectionService;
	}

	public void settSuggectionService(TSuggectionService tSuggectionService) {
		this.tSuggectionService = tSuggectionService;
	}

	public TSuggection getSuggection() {
		return suggection;
	}

	public void setSuggection(TSuggection suggection) {
		this.suggection = suggection;
	}

	public TUserClient getUserClient() {
		return userClient;
	}

	public void setUserClient(TUserClient userClient) {
		this.userClient = userClient;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
