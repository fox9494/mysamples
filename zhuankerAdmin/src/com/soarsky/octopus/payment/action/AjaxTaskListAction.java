package com.soarsky.octopus.payment.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.payment.service.TDemandPaymentService;
import com.soarsky.octopus.payment.vo.Task;

/**
 * 根据所选择的客户信息，异步处理查询该客户发布的所有任务
 * task 封装页面需要的任务信息列表
 * @author ouyang
 *
 */
public class AjaxTaskListAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Long companyID;//客户信息
	private List<Task> tasks;//任务信息列表
	
	private TDemandPaymentService demandPaymentService;//处理需求方结算相关数据的业务接口
	
	public String ajaxTaskList() {
		
		//根据指定客户company的id号查询该客户提供的所有任务
		//如果没有选择客户则不查询
		if(companyID != null && companyID !=JEEContant.SELECT_DEFAULT_VALUE) {
			tasks = demandPaymentService.queryTaskList(companyID);
		}
		return SUCCESS;
	}

	/**
	 * 提供给页面动态注入页面传输过来的客户信息（id号）
	 * @param company
	 */
	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}
	
	/**
	 * 获取任务简要信息（id号、名字）
	 * @return 任务简要信息（id号、名字）
	 */
	public List<Task> getTasks() {
		return tasks;
	}

	/**
	 * 设定任务简要信息（id号、名字）
	 * @param task 任务简要信息（id号、名字）
	 */
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	/**
	 * 设定处理需求方结算相关数据的业务接口
	 * @param demandPaymentService处理需求方结算相关数据的业务接口
	 */
	public void setDemandPaymentService(TDemandPaymentService demandPaymentService) {
		this.demandPaymentService = demandPaymentService;
	}
	
}
