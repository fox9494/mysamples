package com.soarsky.octopus.payment.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.payment.service.TDemandPaymentService;

/**
 * 处理统计指定任务在指定时间范围内的完成数量的action
 * @author ouyang
 *
 */
public class AjaxStatisticsAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Long taskId;//封装页面异步请求过来的任务id
	private Date startDate;//封装页面异步请求过来的开始日期
	private Date endtDate;//封装页面异步请求过来的结束日期
	private Long statisticsAmount;//封装响应给页卖的匹配指定条件的统计结果
	private Long taskGoldNum;//与页面通信封装任务单价
	private String erroMsg;//封装响应会页面的错误信息
	
	private TDemandPaymentService demandPaymentService;//处理需求方结算相关数据的业务接口
	
	public String statistics() {
		
		//根据taskId、startDate、endtDate统计指定任务在startDate、endtDate之间的完成量
		if(taskId!=null && taskId!=JEEContant.SELECT_DEFAULT_VALUE && endtDate!=null) {
			//判断如果结算的结束日期在当前日期之后则不予以统计
			if(endtDate.before(new Date())) {
				statisticsAmount = demandPaymentService.statistics(taskId, startDate, endtDate);
				taskGoldNum = demandPaymentService.queryTaskGoleNum(taskId);
			} else {
				erroMsg = "不能统计当前时间之后的任务,原因：任务完成状态未知";
			}
		} else {
			erroMsg = "无法统计，统计信息不完全";
		}
		return SUCCESS;
	}
	
	/**
	 * 设定taskId
	 * @param taskId
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	/**
	 * 设定startDate
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 设定endDate
	 * @param endtDate
	 */
	public void setEndtDate(Date endtDate) {
		this.endtDate = endtDate;
	}
	/**
	 * 获取statisticsAmount
	 * @return statisticsAmount
	 */
	public Long getStatisticsAmount() {
		return statisticsAmount;
	}
	
	public Long getTaskGoldNum() {
		return taskGoldNum;
	}

	public void setTaskGoldNum(Long taskGoldNum) {
		this.taskGoldNum = taskGoldNum;
	}

	/**
	 * 设定处理需求方结算相关数据的业务接口
	 * @param demandPaymentService处理需求方结算相关数据的业务接口
	 */
	public void setDemandPaymentService(TDemandPaymentService demandPaymentService) {
		this.demandPaymentService = demandPaymentService;
	}
	
	public String getErroMsg() {
		return erroMsg;
	}

	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}

}
