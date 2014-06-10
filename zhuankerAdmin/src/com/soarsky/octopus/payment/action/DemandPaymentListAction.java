package com.soarsky.octopus.payment.action;

import java.util.List;

import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.mapping.TDemandPayment;
import com.soarsky.octopus.payment.service.TDemandPaymentService;
import com.soarsky.octopus.payment.vo.Company;
import com.soarsky.octopus.utils.PageBean;

/**
 * 分页查询显示已经与需求方完成结算的结算相关数据
 * pageBean：封装分页显示数据的实体
 * tDemandPayment 封装通信传输过程中用到的需求方结算相关数据
 * @author ouyang
 *
 */
public class DemandPaymentListAction extends PageAction {
	private static final long serialVersionUID = 1L;
	
	private TDemandPaymentService demandPaymentService;//处理需求方结算相关数据的业务接口
	
	private TDemandPayment demandPayment;//封装通信传输过程中用到的需求方结算相关数据
	private List<Company> companys;//封装通信传输过程中用到的客户信息列表

	/**
	 * 分页查询后台需求方结算信息表
	 * @return
	 */
	public String searchListPage(){
		
		//根据条件分页查询，如果没有调教自动查询所有		
		pageBean = demandPaymentService.queryListPage(PageBean.DEFAULTPAGESIZE, this.currentPage, demandPayment);
		//查询客户信息列表
		companys = demandPaymentService.queryCustomerList();
		
		return SUCCESS;
	}
	 
	/**
	 * 获得处理需求方结算相关数据的业务接口
	 * @return处理需求方结算相关数据的业务接口
	 */
	public TDemandPaymentService getDemandPaymentService() {
		return demandPaymentService;
	}

	/**
	 * 设定处理需求方结算相关数据的业务接口
	 * @param demandPaymentService处理需求方结算相关数据的业务接口
	 */
	public void setDemandPaymentService(TDemandPaymentService demandPaymentService) {
		this.demandPaymentService = demandPaymentService;
	}

	/**
	 * 获取通信传输过程中用到的需求方结算相关数据
	 * @return 封装通信传输过程中用到的需求方结算相关数据
	 */
	public TDemandPayment getDemandPayment() {
		return demandPayment;
	}

	/**
	 * 设定通信传输过程中用到的需求方结算相关数据
	 * @param tDemandPayment 封装通信传输过程中用到的需求方结算相关数据
	 */
	public void setDemandPayment(TDemandPayment demandPayment) {
		this.demandPayment = demandPayment;
	}

	/**
	 * 获取的客户信息列表
	 * @return 封装通信传输过程中用到的客户信息列表
	 */
	public List<Company> getCompanys() {
		return companys;
	}

	/**
	 * 设定客户信息列表
	 * @param companys 封装通信传输过程中用到的客户信息列表
	 */
	public void setCompanys(List<Company> companys) {
		this.companys = companys;
	}

}
