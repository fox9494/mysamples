package com.soarsky.octopus.task.service.impl;

import java.util.List;

import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.mapping.TCompanyOrder;
import com.soarsky.octopus.task.dao.TCompanyOrderDao;
import com.soarsky.octopus.task.service.TCompanyOrderService;
import com.soarsky.octopus.utils.PageBean;

public class TCompanyOrderServiceImpl implements TCompanyOrderService {

	private TCompanyOrderDao tCompanyOrderDao;
	
	/**
	 *添加客户订单
	 *@author lw
	 *@param  order 要添加的订单对象
	*/
	public void addOrder(TCompanyOrder order) {
		
		tCompanyOrderDao.save(order);
	}

    /**
     *分页得到所有订单信息
     *@author lw
     *@param  maxresult 每页最大条数
     *@param  currentpage 当前页数
     *@return
	*/
	public PageBean getOrderList(int maxresult, int currentpage) {
		
	    return tCompanyOrderDao.findAllOrder(maxresult,currentpage);
	}

    /**
     *删除订单
     *@author lw
     *@param  order 要删除的订单对象
	*/
	public void deleteOrder(String info) {
		
		tCompanyOrderDao.deleteOrder(info);
	}

	/**
	 * 初始化要修改的订单对象
	 * @author lw
	 * @param  order 要修改的订单对象
	 * @return
	*/
	public TCompanyOrder initOrder(TCompanyOrder order) {
		
		return tCompanyOrderDao.getById(TCompanyOrder.class, order.getId());
	}

	/**
	 * 修改订单对象
	 * @author lw
	 * @param  order 修改的订单对象
	*/
	public void editOrder(TCompanyOrder order) {
		
		tCompanyOrderDao.update(order);
	}
    
	/**
	 *根据客户查询订单
	 *@author lw
	 *@param  maxresult 每页最大条数
     *@param  currentpage 当前页数
     *@param  order  要查询的客户对象
	 *@return
	*/
	public PageBean findOrderByName(Integer maxresult, Integer currentPage,TCompanyOrder order) {
		
		return tCompanyOrderDao.findOrderByConditions(maxresult,currentPage,order);
	}

	/**
	 * 根据客户查询订单
	 * @author lw
	 * @return
    */
	public List<TCompanyOrder> getOrderByCompany(TCompany company) {
		
		return tCompanyOrderDao.findOrderByCompany(company);
	}
    	
	/**
	 * 根据订单名查询订单
	 * @author lw
	 * @param order 订单对象
	 * @return
	*/
	public Boolean findOrderByName(TCompanyOrder order) {
		
		return tCompanyOrderDao.findOrderByName(order);
	}

	public TCompanyOrderDao gettCompanyOrderDao() {
		return tCompanyOrderDao;
	}


	public void settCompanyOrderDao(TCompanyOrderDao tCompanyOrderDao) {
		this.tCompanyOrderDao = tCompanyOrderDao;
	}
}
