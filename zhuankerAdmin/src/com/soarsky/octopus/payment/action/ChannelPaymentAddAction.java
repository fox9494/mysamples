package com.soarsky.octopus.payment.action;

import java.util.Date;
import java.util.List;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TChannelPayment;
import com.soarsky.octopus.payment.service.TChannelPaymentService;
import com.soarsky.octopus.payment.vo.Channel;

public class ChannelPaymentAddAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private TChannelPaymentService channelPaymentService;//处理渠道结算相关数据的业务接口
	
	private TChannelPayment channelPayment;//封装渠道结算相关数据
	private List<Channel> channels;//客户（需求方）信息列表
	private String erroMsg;//封装响应会页面的错误信息
	
	/**
	 * 渠道结算新增结算初始化提供渠道简要信息列表
	 * @return 客户简要信息列表
	 */
	public String initChannelList() {
		channels = channelPaymentService.queryChannelList();
		return SUCCESS;
	}
	
	/*
	 * 保存新完成的结算数据
	 */
	public String saveChannelPayment() {
		
		if(channelPayment.getChannel() != null 
				&& channelPayment.getChannel().getId() != null
				&& channelPayment.getChannel().getId()  != JEEContant.SELECT_DEFAULT_VALUE
				&& channelPayment.getEndDate() != null
				&& channelPayment.getTaskStatistics() != null
				&& channelPayment.getCoinStatistics() != null
				&& channelPayment.getPaymentMoney() != null) {
			
			//查询该渠道最后一次结算的结束日期
			Date payDate = channelPaymentService.queryLastDate(channelPayment.getChannel().getId());
			//如果本次结算的开始日期在上次结算的结束日期之前则提示错误，不予结算
			if(payDate != null && channelPayment.getStartDate().before(payDate)) {
				erroMsg = "结算范围内，包含已结算数据";
			} else {
				channelPayment.setPaymentDate(new Date());//设定需求方结算的结算时间为当前时间
				channelPaymentService.saveChannelPayment(channelPayment);//保存新添加的结算信息
				erroMsg = "成功添加结算";
			}
		} else {
			erroMsg="结算信息不完整";
		}
		channels = channelPaymentService.queryChannelList();
		return SUCCESS;
		
	}

	
	public void setChannelPaymentService(
			TChannelPaymentService channelPaymentService) {
		this.channelPaymentService = channelPaymentService;
	}

	public TChannelPayment getChannelPayment() {
		return channelPayment;
	}

	public void setChannelPayment(TChannelPayment channelPayment) {
		this.channelPayment = channelPayment;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public String getErroMsg() {
		return erroMsg;
	}

	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}

}
