package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.service.TExchangeRuleService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.utils.PageBean;

public class ExchangeRuleListAction extends PageAction {

	private static final long serialVersionUID = -8966713462117826776L;
    
	private TExchangeRuleService tExchangeRuleService;

	/**
	 *分页查询兑换规则信息 
	 *@author lw
	 *@return
	 */
	public String searchList() {
		
		pageBean=tExchangeRuleService.getExchangeRuleList(PageBean.DEFAULTPAGESIZE, currentPage);
		
		return SUCCESS;
	}


	public TExchangeRuleService gettExchangeRuleService() {
		return tExchangeRuleService;
	}


	public void settExchangeRuleService(TExchangeRuleService tExchangeRuleService) {
		this.tExchangeRuleService = tExchangeRuleService;
	}	
}
