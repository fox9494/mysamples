package com.soarsky.octopus.payment.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TChannelPayment;
import com.soarsky.octopus.mapping.TDemandPayment;
import com.soarsky.octopus.utils.PageBean;

public class TChannelPaymentDAO extends BaseDAO {

	/**
	 * 查询渠道结算表中渠道id等于channelId的记录中的最大endDate
	 * @param channelId 查询条件
	 * @return 渠道结算表中指定渠道的最大endDate
	 */
	public Date queryMaxEndDate(Long channelId) {

		String hql = " select max(endDate) from TChannelPayment where channel.id=:channelId ";
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("channelId", channelId);
		Date date = (Date) this.queryUniqueResult(hql, paramMap);
		return date;
	}

	/**
	 * 分页查询已经与渠道结算过的详细信息
	 * @param dEFAULTPAGESIZE 默认煤业显示记录数
	 * @param currentPage 当前页数
	 * @param channelId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public PageBean queryForPage(int dEFAULTPAGESIZE, Integer currentPage, Long channelId, Date startDate, Date endDate)  {

		Criteria crit=this.getSession().createCriteria(TChannelPayment.class).addOrder(Order.desc("paymentDate"));
		//构造条件，如果查询条件中渠道id不为空就添加条件根据渠道id查询(注意这里的id为Long型，所以要先判断是否为空，再判断是否为默认的下拉表妹选择时的值)
		if(channelId != null && channelId != JEEContant.SELECT_DEFAULT_VALUE) {
			crit.createCriteria("channel").add(Restrictions.eq("id", channelId));
		}
		if(startDate != null) {
			crit.add(Restrictions.ge("startDate", startDate));
		}
		if(endDate != null) {
			crit.add(Restrictions.le("endDate", endDate));
		}
		
		return this.queryForPageByParams(dEFAULTPAGESIZE, currentPage, crit);
		
	}

}
