package com.soarsky.octopus.clientuser.service.impl;

import com.soarsky.octopus.clientuser.constant.ClientUserContent;
import com.soarsky.octopus.clientuser.dao.TExchangeRuleDAO;
import com.soarsky.octopus.clientuser.service.TExchangeRuleService;
import com.soarsky.octopus.mapping.TExchangeRule;
import com.soarsky.octopus.utils.PageBean;

public class TExchangeRuleServiceImpl implements TExchangeRuleService {
	
	private TExchangeRuleDAO tExchangeRuleDAO;
    
	/**
	 *添加兑换规则
	 *@author lw
	 *@param  exchangeRule 要添加的兑换规则对象
	 */
	public void addExchangeRule(TExchangeRule exchangeRule) {
		
		tExchangeRuleDAO.save(exchangeRule);
	}

   /**
	 *删除兑换规则
	 *@author lw
	 *@param  exchangeRule 要添加的兑换规则对象
	 */
	public void deleteExchangeRule(TExchangeRule exchangeRule) {
		
		TExchangeRule oldExchangeRule=initExchangeRule(exchangeRule);
		
		oldExchangeRule.setIsRemove(ClientUserContent.ROMOVE);
		
		tExchangeRuleDAO.update(oldExchangeRule);
	}

	/**
	 *分页查询所有兑换规则
	 *@author lw
	 *@param  maxresult 每页的最大条数
	 *@param  currentPage 当前页数
	 *@return
	 */
	public PageBean getExchangeRuleList(int maxresult, int currentPage) {
		
		return tExchangeRuleDAO.findAllExchangeRule(maxresult,currentPage);
	}
	
   /**
    * 初始化要修改的兑换规则对象
    * @author lw
    * @param  exchangeRule 要添加的兑换规则对象
    * @return
	*/
	public TExchangeRule initExchangeRule(TExchangeRule exchangeRule) {
		
		return tExchangeRuleDAO.getById(TExchangeRule.class, exchangeRule.getId());
	}

   /**
    * 修改兑换规则
    * @author lw
    * @param  exchangeRule 要添加的兑换规则对象
	*/
	public void editExchangeRule(TExchangeRule exchangeRule) {
		
		tExchangeRuleDAO.update(exchangeRule);
	}

	public TExchangeRuleDAO gettExchangeRuleDAO() {
		return tExchangeRuleDAO;
	}

	public void settExchangeRuleDAO(TExchangeRuleDAO tExchangeRuleDAO) {
		this.tExchangeRuleDAO = tExchangeRuleDAO;
	}
}
