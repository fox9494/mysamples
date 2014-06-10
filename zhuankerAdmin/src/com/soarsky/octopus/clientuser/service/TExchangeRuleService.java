package com.soarsky.octopus.clientuser.service;

import com.soarsky.octopus.mapping.TExchangeRule;
import com.soarsky.octopus.utils.PageBean;

public interface TExchangeRuleService {
	
	public void addExchangeRule(TExchangeRule exchangeRule);
	
	public void deleteExchangeRule(TExchangeRule exchangeRule);
	
	public PageBean getExchangeRuleList(int maxresult,int currentPage);
	
	public TExchangeRule initExchangeRule(TExchangeRule exchangeRule);
	
	public void editExchangeRule(TExchangeRule exchangeRule);	

}
