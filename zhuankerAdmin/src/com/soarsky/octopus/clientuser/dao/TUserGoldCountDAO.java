package com.soarsky.octopus.clientuser.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.mapping.TUserGoldCount;

public class TUserGoldCountDAO extends BaseDAO {
	/**
	 * 得到用户详情，用户金币信息
	 * 
	 * @param userId
	 * @return
	 */
	public TUserGoldCount findUserGoldCountByUserId(long userId) {
		Criteria crit = this.getSession().createCriteria(TUserGoldCount.class);
		if (!"".equals(userId)) {
			crit.createCriteria("TUserClient").add(	Restrictions.eq("id", userId));				
		}

		return (TUserGoldCount) crit.uniqueResult();
	}

	// 根据当前的用户查找奴隶数
	public long findChildrenByUserId(long userId) {
		Criteria crit = this.getSession().createCriteria(TUserClient.class);
		if (!"".equals(userId)) {
			crit.add(Restrictions.eq("parentId", userId));
		}
		long count = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();				
		return count;
	}

	// 查看当前用户排名
	public long findRankingByUserGold(long userId) {
		TUserGoldCount userGoldCount = findUserGoldCountByUserId(userId);
		Criteria crit = this.getSession().createCriteria(TUserGoldCount.class).add(Restrictions.ge("total_gold",userGoldCount.getTotal_gold()));
		long ranking = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();				
		return ranking;
	}
}