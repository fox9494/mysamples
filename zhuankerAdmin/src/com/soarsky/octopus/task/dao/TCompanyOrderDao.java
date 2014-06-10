package com.soarsky.octopus.task.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.mapping.TCompanyOrder;
import com.soarsky.octopus.task.constant.TaskContent;
import com.soarsky.octopus.utils.PageBean;

public class TCompanyOrderDao extends BaseDAO {
    
	/**
     *分页得到所有订单信息
     *@author lw
     *@param  maxresult 每页最大条数
     *@param  currentpage 当前页数
     *@return
	*/
	public PageBean findAllOrder(int maxresult, int currentpage) {
		
		Criteria crit=this.getSession().createCriteria(TCompanyOrder.class).add(Restrictions.eq("isRemove", TaskContent.NOTROMOVE)).addOrder(Order.desc("id"));
		
		return this.queryForPageByParams(maxresult, currentpage, crit);
	}
   
	/**
	 *根据客户查询订单
	 *@author lw
	 *@param  maxresult 每页最大条数
     *@param  currentpage 当前页数
     *@param  order  要查询的客户对象
	 *@return
	*/
	public PageBean findOrderByConditions(Integer maxresult,Integer currentPage, TCompanyOrder order) {
		
		Criteria crit=this.getSession().createCriteria(TCompanyOrder.class).add(Restrictions.eq("isRemove", TaskContent.NOTROMOVE)).addOrder(Order.desc("id")).createCriteria("company");
		
		if(StringUtils.isNotEmpty(order.getCompany().getName())){
			
			crit.add(Restrictions.like("name", "%"+order.getCompany().getName()+"%"));
		
		}
		return this.queryForPageByParams(maxresult,currentPage, crit);
	}
	
	/**
	 * 根据订单名查询订单
	 * @author lw
	 * @param order 订单对象
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public Boolean findOrderByName(TCompanyOrder order) {
		
		Criteria crit=this.getSession().createCriteria(TCompanyOrder.class).add(Restrictions.eq("name", order.getName())).add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE));
		
		Iterator<TCompanyOrder>orders=crit.list().iterator();
		
		while(orders.hasNext()){
			
			return true;
		
		}
		
		return false;
	}
	
	/**
     *删除订单
     *@author lw
     *@param  order 要删除的订单对象
	*/
	public void deleteOrder(String info) {
		String sql = "update t_company_order set isremove="+JEEContant.ROMOVE+" where id in ("+info+")";
		this.executeBySql(sql, null);
	}
    
	/**
	 * 根据客户查询订单
	 * @author lw
	 * @return
    */
	@SuppressWarnings("unchecked")
	public List<TCompanyOrder> findOrderByCompany(TCompany company) {
		
		Criteria crit=this.getSession().createCriteria(TCompanyOrder.class).add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE)).createCriteria("company").add(Restrictions.eq("id", company.getId()));
		
		List<TCompanyOrder> orders=crit.list();
		
		if(orders.size()>0){
			
			return orders;
		}
		
		return null;
	}

}
