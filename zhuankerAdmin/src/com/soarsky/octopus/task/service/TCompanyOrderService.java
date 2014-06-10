package com.soarsky.octopus.task.service;

import java.util.List;

import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.mapping.TCompanyOrder;
import com.soarsky.octopus.utils.PageBean;

public interface TCompanyOrderService {
	
	/**
	 * 添加订单
	 * @param order 订单对象
	*/
	public void addOrder(TCompanyOrder order);
	
	/**
	 * 分页查询所有订单
	 * @param maxresult 每页最大条数
	 * @param currentpage 当前页数
	 * @return
	*/
	public PageBean getOrderList(int maxresult,int currentpage);
	
	/**
	 * 删除订单
	 * @param info 要删除的订单对象
	*/
	public void deleteOrder(String info);
	
	/**
	 * 根据ID查询订单
	 * @param order 订单对象
	 * @return
	*/
	public TCompanyOrder initOrder(TCompanyOrder order);
	
	/**
	 * 编辑订单
	 * @param order 订单对象
	*/
	public void editOrder(TCompanyOrder order);
    
	/**
	 * 根据订单名分页查询订单
	 * @param maxresult 每页最大条数
	 * @param currentpage 当前页数
	 * @param order 订单对象
	 * @return
	*/
	public PageBean findOrderByName(Integer maxresult, Integer currentPage,TCompanyOrder order);
	
	/**
	 * 根据客户查询订单
	 * @return
	*/
	public List<TCompanyOrder> getOrderByCompany(TCompany company);
   
	/**
	 * 根据订单名查询订单
	 * @param order 订单对象
	 * @return
	*/
	public Boolean findOrderByName(TCompanyOrder order);

}
