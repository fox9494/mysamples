package com.soarsky.octopus.payment.action;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.payment.service.TChannelPaymentService;

/**
 * 处理在指定时间范围内渠道结算相关数据的action
 * @author ouyang
 *
 */
public class AjaxCPStatisticsAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Long channelId;//封装页面异步请求过来的渠道id
	private Date startDate;//封装页面异步请求过来的开始日期
	private Date endDate;//封装页面异步请求过来的结束日期
	private Map<String,Object>  statisticsData;//封装响应给页卖的匹配指定条件的统计结果
	private String erroMsg;//封装响应会页面的错误信息
	
	private TChannelPaymentService channelPaymentService;//处理需求方结算相关数据的业务接口
	
	public String statistics() {
		
		//根据channelId、startDate、endtDate统计指定渠道在startDate、endtDate之间的完成所有任务数、所赚取金币数、等价金额
		if(channelId!=null && channelId!=JEEContant.SELECT_DEFAULT_VALUE && endDate!=null) {
			//判断如果结算的结束日期在当前日期之后则不予以统计
			//if(endDate.before(new Date())) {
				statisticsData = channelPaymentService.statistics(channelId, startDate, endDate);
			//} else {
			//	erroMsg = "只能统计今天之前的数据";
			//}
		} else {
			erroMsg = "无法统计，统计信息不完全";
		}
		return SUCCESS;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Map<String, Object> getStatisticsData() {
		return statisticsData;
	}

	public void setStatisticsData(Map<String, Object> statisticsData) {
		this.statisticsData = statisticsData;
	}

	public String getErroMsg() {
		return erroMsg;
	}

	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}

	public void setChannelPaymentService(
			TChannelPaymentService channelPaymentService) {
		this.channelPaymentService = channelPaymentService;
	}
	
}
