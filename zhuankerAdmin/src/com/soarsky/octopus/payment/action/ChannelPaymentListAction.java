package com.soarsky.octopus.payment.action;

import java.util.Date;
import java.util.List;

import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.payment.service.TChannelPaymentService;
import com.soarsky.octopus.payment.vo.Channel;
import com.soarsky.octopus.utils.PageBean;

/**
 * 分页查询显示已经与渠道方完成结算的结算相关数据
 * @author ouyang
 *
 */
public class ChannelPaymentListAction extends PageAction {
	private static final long serialVersionUID = 1L;
	
	private TChannelPaymentService channelPaymentService;//处理渠道结算相关的业务逻辑接口
	
	private List<Channel> channels;//封装通信传输过程中用到的渠道信息列表

	private Long channelId;
	private Date startDate;
	private Date endDate;
	/**
	 * 分页查询后台需求方结算信息表
	 * @return
	 */
	public String searchListPage(){
		
		//根据条件分页查询，如果没有调教自动查询所有		
		pageBean = channelPaymentService.queryListPage(PageBean.DEFAULTPAGESIZE, this.currentPage, channelId, startDate, endDate);
		//查询渠道信息列表
		channels = channelPaymentService.queryChannelList();
		
		return SUCCESS;
	}


	public void setChannelPaymentService(TChannelPaymentService channelPaymentService) {
		this.channelPaymentService = channelPaymentService;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
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

}
