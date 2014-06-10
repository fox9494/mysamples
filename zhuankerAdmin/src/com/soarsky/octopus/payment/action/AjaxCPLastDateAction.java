package com.soarsky.octopus.payment.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.payment.service.TChannelPaymentService;

/**
 * 异步处理页面选择渠道后，查询指定渠道的最末次结算的结束时间，用该时间作为本次结算的开始时间
 * @author ouyang
 *
 */
public class AjaxCPLastDateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Long channelId;//封装异步请求页面传递过来的参数渠道id号
	private Date startDate;//封装响应给页面的指定渠道的最后一次结算的结束时间
	
	private TChannelPaymentService channelPaymentService;//处理渠道结算相关数据的业务接口

	public String ajaxStartDate() {
		
		//根据渠道id查询该渠道最后一次结算的结束时间
		//如果没有选择渠道则不查询
		if(channelId != null && channelId != JEEContant.SELECT_DEFAULT_VALUE) {
			startDate = channelPaymentService.queryLastDate(channelId);
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

	public void setChannelPaymentService(
			TChannelPaymentService channelPaymentService) {
		this.channelPaymentService = channelPaymentService;
	}
	
}
