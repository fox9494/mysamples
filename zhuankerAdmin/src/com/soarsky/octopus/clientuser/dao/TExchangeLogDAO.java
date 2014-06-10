package com.soarsky.octopus.clientuser.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.clientuser.vo.ExchangeMsg;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TExchangeLog;
import com.soarsky.octopus.utils.PageBean;

public class TExchangeLogDAO extends BaseDAO {
	/**
	 * 兑换记录日志列表
	 * 
	 * @param maxResult
	 *            最大记录数
	 * @param currentPage
	 *            当前页数
	 * @param userId
	 *            当前用户id
	 * @return
	 */
	public PageBean findAllExchangeLog(int maxResult, int currentPage,
			long userId) {
		Criteria crit = this.getSession().createCriteria(TExchangeLog.class).addOrder(Order.desc("submitDate"));				
		if (!"".equals(userId)) {
			crit.createCriteria("TUserClient").add(Restrictions.eq("id", userId));
		}		
		return this.queryForPageByParams(maxResult, currentPage, crit);
	}
	/**
	 * 用户结算
	 * @param maxResult
	 * @param currentPage
	 * @return
	 */
	public PageBean findAllPayMent(int maxResult,int currentPage){
		Criteria crit = this.getSession().createCriteria(TExchangeLog.class).addOrder(Order.desc("submitDate"));
		return this.queryForPageByParams(maxResult, currentPage, crit);
	}
	/**
	 * 条件查询，用户结算
	 * @param maxResult
	 * @param currentPage
	 * @param startYear 开始日期
	 * @param endYear 结算日期
	 * @param status 状态
	 * @param account 帐户
	 * @return
	 */
	public PageBean findPayMentByParams(int maxResult,int currentPage,Date startYear,Date endYear,TExchangeLog exLog){
		Criteria crit = this.getSession().createCriteria(TExchangeLog.class).addOrder(Order.desc("submitDate"));
		Calendar calendar=Calendar.getInstance();
			if(endYear!=null){
				calendar.setTime(endYear);
				calendar.add(Calendar.HOUR,24);
			}								
			if(startYear!=null&&endYear!=null){				
				crit.add(Restrictions.ge("submitDate", startYear)).add(Restrictions.le("submitDate", calendar.getTime()));
			}
			if(exLog.getStatus()!=JEEContant.STATUS){				
				crit.add(Restrictions.eq("status", exLog.getStatus()));
			}
			if(StringUtils.isNotEmpty(exLog.getTUserClient().getUserName())){				
				crit.createCriteria("TUserClient").add(Restrictions.like("userName", "%"+exLog.getTUserClient().getUserName()+"%"));
			}
			
		return this.queryForPageByParams(maxResult, currentPage, crit);
	}
	
	/**
	 * 批量审核通过
	 * @param idList
	 */
	public void savePayMentChecked(List<Long> idList){
		String sql = "update t_exchange_log set status=:status,approvalDate=:approvalDate where id in :idList";
		int status = JEEContant.CHECKED;
		Date approvalDate = new Date();
		this.getSession().createSQLQuery(sql).setParameter("status", status).setParameter("approvalDate", approvalDate).setParameterList("idList", idList).executeUpdate();
	}
	/**
	 * 批量支付完成
	 * @param idList
	 */
	public void savePayMentPayed(Map<Long,String> map){
		String sql = "update t_exchange_log set status=:status,finishDate=:finishDate,result_desc=:result_desc where id=:id";
		int status = JEEContant.SUCCESSED;
		Date finishDate = new Date();				
		Set set =map.entrySet();
		Iterator it=set.iterator();      
		while(it.hasNext()){         
			Map.Entry<Long, String>  entry=  (Entry<Long, String>) it.next();           
			this.getSession().createSQLQuery(sql).setParameter("status", status).setParameter("finishDate", finishDate).setParameter("result_desc", entry.getValue()).setParameter("id", entry.getKey()).executeUpdate();	
		}
		
	}
	/**
	 * 批量取消兑换
	 * @param idList
	 */
	public void savePayMentUnChecked(Map<Long,String> map){
		String sql = "update t_exchange_log set status=:status,approvalDate=:approvalDate,finishDate=:finishDate,result_desc=:result_desc where id=:id";
		int status = JEEContant.UNCHECKED;
		Date approvalDate=new Date();
		Set set =map.entrySet();
		Iterator it=set.iterator();      
		while(it.hasNext()){         
			Map.Entry<Long, String>  entry=  (Entry<Long, String>) it.next();           
			this.getSession().createSQLQuery(sql).setParameter("status", status).setParameter("approvalDate", approvalDate).setParameter("finishDate", "").setParameter("result_desc", entry.getValue()).setParameter("id", entry.getKey()).executeUpdate();
		}								
	}
	/**
	 * 筛选符合条件的id集合
	 * @param idList 传入的id集合
	 * @param status 当前状态
	 * @return
	 */
	public List<Long> getAllId(List<Long> idList,int status){		
		List<TExchangeLog> exchangeLogList = this.getSession().createCriteria(TExchangeLog.class).add(Restrictions.eq("status", status)).add(Restrictions.in("id", idList)).list();
		List<Long> idList1 = new ArrayList<Long>();
		for(TExchangeLog log:exchangeLogList){
			idList1.add(log.getId());
		}
		return idList1;
	}
	/**
	 * 根据id集合查找物品的类型，价格，兑换日期，或者失败日期
	 * @param idList
	 * @return
	 */
	public List<TExchangeLog> getExchangeLog(List<Long> idList){
		
		List<TExchangeLog> exchangeLogList = this.getSession().createCriteria(TExchangeLog.class).add(Restrictions.in("id", idList)).list();		
		
		return exchangeLogList;
	}
	/**
	 * 根据用户的id，结算失败,返回扣除的金币
	 * @author yl
	 */
	public void deductGold(Map<Long,Long> map){
		String sql = "update t_user_gold_count set current_gold=:result where user_id=:id";
		if(map!=null){
			Set set = map.entrySet();
			Iterator iter = set.iterator();
			while(iter.hasNext()){
				Map.Entry<Long, Long> entry = (Entry<Long, Long>) iter.next();
				this.getSession().createSQLQuery(sql).setParameter("result", entry.getValue()).setParameter("id", entry.getKey()).executeUpdate();
			}
		}
		
		
	}
	
}