package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.service.TExchangeLogService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.utils.PageBean;

public class ExchangeLogListAction extends PageAction {

	private static final long serialVersionUID = 2462888422988412991L;
	
	private TExchangeLogService tExchangeLogService;
	
	private long userId;
	
	public String searchList() {
		pageBean = tExchangeLogService.findAllExchangeLog(PageBean.DEFAULTPAGESIZE, currentPage, userId);			
		return SUCCESS;
	}

	public void settExchangeLogService(TExchangeLogService tExchangeLogService) {
		this.tExchangeLogService = tExchangeLogService;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
