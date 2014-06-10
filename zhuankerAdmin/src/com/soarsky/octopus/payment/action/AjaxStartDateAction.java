package com.soarsky.octopus.payment.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.payment.service.TDemandPaymentService;

/**
 * 异步处理页面选择任务后，查询指定任务的最末次结算的结束时间
 * @author ouyang
 *
 */
public class AjaxStartDateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Long taskId;//封装异步请求页面传递过来的参数任务id号
	private Date startDate;//封装响应给页面的指定任务的最后一次结算的结束时间
	
	private TDemandPaymentService demandPaymentService;//处理需求方结算相关数据的业务接口

	public String ajaxStartDate() {
		
		//根据任务idtaskId号查询该任务最后一次结算的结束时间
		//如果没有选择任务则不查询
		if(taskId != null && taskId != JEEContant.SELECT_DEFAULT_VALUE) {
			startDate = demandPaymentService.queryDateByTask(taskId);
		}
		return SUCCESS;
	}
	
	/**
	 * 设定任务id号
	 * @param taskId 任务id号
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	
	/**
	 * 获取指定任务的最末次结算时间
	 * @return 任务的最末次结算时间
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 设定处理需求方结算相关数据的业务接口
	 * @param demandPaymentService处理需求方结算相关数据的业务接口
	 */
	public void setDemandPaymentService(TDemandPaymentService demandPaymentService) {
		this.demandPaymentService = demandPaymentService;
	}
	
}
