package com.soarsky.octopus.clientuser.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.clientuser.constant.ClientUserContent;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TExchangeRule;
import com.soarsky.octopus.utils.PageBean;

public class TExchangeRuleDAO extends BaseDAO  {
	
	
	/**
	 *分页查询所有兑换规则
	 *@author lw
	 *@param  maxresult 每页的最大条数
	 *@param  currentPage 当前页数
	 *@return
	 */
	public PageBean findAllExchangeRule(int maxresult, int currentPage) {
		
		Criteria crit=this.getSession().createCriteria(TExchangeRule.class).add(Restrictions.eq("isRemove", ClientUserContent.NOTROMOVE));
		
	    return this.queryForPageByParams(maxresult, currentPage, crit);
	}
	
	
}