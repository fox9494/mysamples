package com.soarsky.octopus.payment.action;

import java.util.Date;
import java.util.List;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TDemandPayment;
import com.soarsky.octopus.payment.service.TDemandPaymentService;
import com.soarsky.octopus.payment.vo.Company;

/**
 * 确定结算时将完成的结算详细信息保存到数据库
 * demandPayment 封装要保存的结算数据信息
 * @author ouyang
 *
 */
public class DemandPaymentAddAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	private TDemandPayment demandPayment;//保存需求方结算数据的实体
	private TDemandPaymentService demandPaymentService;//处理需求方结算相关数据的业务接口
	
	private List<Company> companys;//客户（需求方）信息列表
	private String erroMsg;//封装响应会页面的错误信息
	
	/**
	 * 需求方结算新增结算初始化提供客户简要信息列表
	 * @return 客户简要信息列表
	 */
	public String initCustomerList() {
		companys = demandPaymentService.queryCustomerList();
		return SUCCESS;
	}
	
	/*
	 * 保存新完成的结算数据
	 */
	public String saveDemandPayment() {
		
		if(demandPayment.getTask() != null 
				&& demandPayment.getTask().getTaskid() != null
				&& demandPayment.getTask().getTaskid() != JEEContant.SELECT_DEFAULT_VALUE
				&& demandPayment.getStartDate() != null
				&& demandPayment.getEndDate() != null
				&& demandPayment.getStatisticsAmount() != null
				&& demandPayment.getApprovedAmount() != null
				&& demandPayment.getPaymentMoney() != null) {
			
			
			//如果本次结算的开始日期在上次结算的结束日期之前则会抛出异常信息提示错误，不予结算
			demandPayment.setPaymentDate(new Date());//设定需求方结算的结算时间为当前时间
			//保存新添加的结算信息
			erroMsg = demandPaymentService.saveDemandPayment(demandPayment);
			
		} else {
			erroMsg="结算信息不完整";
		}
		companys = demandPaymentService.queryCustomerList();
		return SUCCESS;
		
	}

	/**
	 * 获得保存需求方结算数据的实体
	 * @return保存需求方结算数据的实体
	 */
	public TDemandPayment getDemandPayment() {
		return demandPayment;
	}

	/**
	 * 保存需求方结算数据的实体
	 * @param demandPayment 保存需求方结算数据的实体
	 */
	public void setDemandPayment(TDemandPayment demandPayment) {
		this.demandPayment = demandPayment;
	}

	/**
	 * 获得处理需求方结算相关数据的业务接口
	 * @return 处理需求方结算相关数据的业务接口
	 */
	public TDemandPaymentService getDemandPaymentService() {
		return demandPaymentService;
	}

	/**
	 * 设定保存需求方结算数据的实体
	 * @param demandPaymentService 保存需求方结算数据的实体
	 */
	public void setDemandPaymentService(TDemandPaymentService demandPaymentService) {
		this.demandPaymentService = demandPaymentService;
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

	public String getErroMsg() {
		return erroMsg;
	}

	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}
	
}
