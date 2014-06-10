package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.service.TExchangeRuleService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TExchangeRule;

public class ExchangeRuleDeleteAction extends BaseAction {

	private static final long serialVersionUID = 653829207461450347L;
    
    private TExchangeRuleService tExchangeRuleService;
	
	private TExchangeRule  exchangRule;
	
   /**
    * 删除兑换规则
    * @author lw
    * @return
	*/
	public String delete() {
		
		tExchangeRuleService.deleteExchangeRule(exchangRule);
		
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
