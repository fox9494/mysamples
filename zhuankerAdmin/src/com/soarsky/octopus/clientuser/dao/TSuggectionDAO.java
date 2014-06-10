package com.soarsky.octopus.clientuser.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TSuggection;
import com.soarsky.octopus.utils.PageBean;

public class TSuggectionDAO extends BaseDAO  {

	
	/**
	 * 分页查询所有反馈信息
	 * @author lw
	 * @param  maxresult  每页最大条数
	 * @param  currentpage 当前页数
	 * @return
	*/
	public PageBean findAllSuggection(int maxresult, int currentpage) {
		
	  Criteria crit=this.getSession().createCriteria(TSuggection.class).addOrder(Order.desc("replayDate"));
		
		return this.queryForPageByParams(maxresult, currentpage, crit);
	}
    
	/**
	 * 根据条件查找反馈信息
	 * @author lw
	 * @param  maxresult  每页最大条数
	 * @param  currentpage 当前页数
	 * @param  suggection  反馈信息对象
	 * @return
	*/
	public PageBean findSuggectionsByConditon(int maxresult, int currentpage,TSuggection suggection,Date startDate,Date endDate) {
		
		Criteria crit=this.getSession().createCriteria(TSuggection.class).addOrder(Order.desc("replayDate"));
		
		Calendar calendar=Calendar.getInstance();
		if(endDate!=null){
			calendar.setTime(endDate);
			calendar.add(Calendar.HOUR,24);	
		}					
	    if(startDate!=null&&endDate==null){
				
			crit.add(Restrictions.ge("replayDate", startDate));
		}
		if(endDate!=null&&startDate==null){
				
			crit.add(Restrictions.le("replayDate", endDate));
		
		}
		if(startDate!=null&&endDate!=null){
			
			crit.add(Restrictions.and(Restrictions.ge("replayDate", startDate), Restrictions.le("replayDate", calendar.getTime())));
			
		}
		if(StringUtils.isNotEmpty(suggection.getTUserClient().getUserName())){
			
			crit.createCriteria("TUserClient").add(Restrictions.like("userName","%"+suggection.getTUserClient().getUserName()+"%"));
		}
		
		return this.queryForPageByParams(maxresult, currentpage, crit);
	}
	
	
}