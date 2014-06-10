package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.service.TExchangeRuleService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TExchangeRule;

public class ExchangeRuleEditAction extends BaseAction{

	private static final long serialVersionUID = 1405780866847445585L;
	
    private TExchangeRuleService tExchangeRuleService;
	
	private TExchangeRule  exchangRule;
	
	/**
	 * 初始化兑换规则
	 * @author lw
	 * @return 
	*/
	public String input(){
		
		exchangRule=tExchangeRuleService.initExchangeRule(exchangRule);
		
		return SUCCESS;
	}
     
	/**
	 * 修改兑换规则
	 * @author lw
	 * @return
	*/
	public String save() {
		
		tExchangeRuleService.editExchangeRule(exchangRule);
		
		return "editsuccess";
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
