package com.soarsky.octopus.clientuser.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TGoldChange;
import com.soarsky.octopus.utils.PageBean;

public class TGoldChangeDAO extends BaseDAO {

	public PageBean findAllGoldChange(int maxresult, int currentPage,
			long userId) {
		Criteria crit = this.getSession().createCriteria(TGoldChange.class).addOrder(Order.desc("dealDate")).addOrder(Order.desc("currentGold"));
				
		if (!"".equals(userId)) {
			crit.createCriteria("TUserClient").add(Restrictions.eq("id", userId));
					
		}

		return this.queryForPageByParams(maxresult, currentPage, crit);
	}

}