package com.soarsky.octopus.task.action;

import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.mapping.TCompanyOrder;
import com.soarsky.octopus.task.service.TCompanyOrderService;
import com.soarsky.octopus.utils.PageBean;

public class CompanyOrderListAction extends PageAction {

	private static final long serialVersionUID = 3858361444411141647L;
    
	private TCompanyOrderService  tCompanyOrderService;
	
	private TCompanyOrder order;
    
	/**
	 * 分页得到所有订单信息
	 * @author lw
	 * @return
	*/
	public String searchList() {
		
		pageBean=tCompanyOrderService.getOrderList(PageBean.DEFAULTPAGESIZE, currentPage);
		
		return SUCCESS;
	}
	
	/**
	 * 根据客户查询订单
	 * @author lw
	 * @return
	*/
	public String findByConditons() {
		
		pageBean=tCompanyOrderService.findOrderByName(PageBean.DEFAULTPAGESIZE, currentPage,order);
		
		return "findbyconditions";
	}
	
	public TCompanyOrderService gettCompanyOrderService() {
		return tCompanyOrderService;
	}

	public void settCompanyOrderService(TCompanyOrderService tCompanyOrderService) {
		this.tCompanyOrderService = tCompanyOrderService;
	}

	public TCompanyOrder getOrder() {
		return order;
	}

	public void setOrder(TCompanyOrder order) {
		this.order = order;
	}
}
