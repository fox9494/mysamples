package com.soarsky.octopus.payment.action;

import java.util.List;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.payment.service.TChannelPaymentService;
import com.soarsky.octopus.payment.vo.Channel;

/**
 * 渠道结算任务统计模块初始化提供渠道简要信息列表
 * @author ouyang
 *
 */
public class ChannelPaymentStatisticsAction extends BaseAction  {
	private static final long serialVersionUID = 1L;
	
	private TChannelPaymentService channelPaymentService;//处理渠道结算相关的业务逻辑接口
	
	private List<Channel> channels;//封装通信传输过程中用到的渠道信息列表
	
	/**
	 * 第一次进入统计页面初始化客户信息下拉列表数据
	 * @return
	 */
	public String initCompanyList() {
		
		//查询渠道信息列表
		channels = channelPaymentService.queryChannelList();
		return SUCCESS;
	}


	public void setChannelPaymentService(
			TChannelPaymentService channelPaymentService) {
		this.channelPaymentService = channelPaymentService;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	
}
