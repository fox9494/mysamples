package com.soarsky.octopus.payment.action;

import java.util.List;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.payment.service.TDemandPaymentService;
import com.soarsky.octopus.payment.vo.Company;

/**
 * 需求方结算任务统计模块初始化提供客户简要信息列表
 * @author ouyang
 *
 */
public class DemandPaymentStatisticsAction extends BaseAction  {
	
	private static final long serialVersionUID = 1L;
	
	private List<Company> companys;//客户（需求方）信息列表
	private TDemandPaymentService demandPaymentService;//处理需求方结算相关数据的业务接口
	
	/**
	 * 第一次进入统计页面初始化客户信息下拉列表数据
	 * @return
	 */
	public String initCompanyList() {
		
		companys = demandPaymentService.queryCustomerList();
		return SUCCESS;
	}

	/**
	 * 获取客户公司（需求方）列表
	 * @return 客户公司（需求方）列表
	 */
	public List<Company> getCompanys() {
		return companys;
	}
	/**
	 * 设定客户公司（需求方）列表
	 * @param companys 客户公司（需求方）列表
	 */
	public void setCompanys(List<Company> companys) {
		this.companys = companys;
	}
	
	/**
	 * 获取处理需求方结算相关数据的业务接口
	 * @return 处理需求方结算相关数据的业务接口
	 */
	public TDemandPaymentService getDemandPaymentService() {
		return demandPaymentService;
	}

	/**
	 * 设定处理需求方结算相关数据的业务接口
	 * @param demandPaymentService 处理需求方结算相关数据的业务接口
	 */
	public void setDemandPaymentService(TDemandPaymentService demandPaymentService) {
		this.demandPaymentService = demandPaymentService;
	}

}
