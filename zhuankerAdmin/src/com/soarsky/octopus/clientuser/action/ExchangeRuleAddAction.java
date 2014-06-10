package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.constant.ClientUserContent;
import com.soarsky.octopus.clientuser.service.TExchangeRuleService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TExchangeRule;

public class ExchangeRuleAddAction extends BaseAction {

	private static final long serialVersionUID = 4554484897705793497L;
	
	private TExchangeRuleService tExchangeRuleService;
	
	private TExchangeRule  exchangRule;
    
	/**
	 *添加兑换规则 
	 *@author lw
	 *@return
	 */
	public String save() {
		
		exchangRule.setIsRemove(ClientUserContent.NOTROMOVE);
		
		tExchangeRuleService.addExchangeRule(exchangRule);
		
		return SUCCESS;
	}

	public TExchangeRuleService gettExchangeRuleService() {
		return tExchangeRuleService;
	}

	public void settExchangeRuleService(TExchangeRuleService tExchangeRuleService) {
		this.tExchangeRuleService = tExchangeRuleService;
	}

	public TExchangeRule getExchangRule() {
		return exchangRule;
	}

	public void setExchangRule(TExchangeRule exchangRule) {
		this.exchangRule = exchangRule;
	}
}   
