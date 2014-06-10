package com.soarsky.octopus.task.action;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TCompanyOrder;
import com.soarsky.octopus.task.service.TCompanyOrderService;

public class CompanyOrderDeleteAction extends BaseAction {

	private static final long serialVersionUID = 1978869413284697373L;
    
    private TCompanyOrderService  tCompanyOrderService;
	
	private TCompanyOrder order;
    
	private String info;
	
	/**
	 * 删除订单信息
	 * @author lw
	 * @return
	*/
	public String delete() {
			
			tCompanyOrderService.deleteOrder(info);
		
		return SUCCESS;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
