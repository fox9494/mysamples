package com.soarsky.octopus.channel.action;

import com.soarsky.octopus.channel.service.TChannelInviteService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.utils.PageBean;

public class ChannelInviteListAction extends PageAction {

	private static final long serialVersionUID = 2586916557405358334L;
	
	private TChannelInviteService tChannelInviteService;
	
	private Long channelId;
	
	private String modelError;
	/**
	 * 分页查询所有推送信息
	 * @author lw
	 * @return
	*/
	public String searchList() {
		
		pageBean=tChannelInviteService.findAllChannelInvite(PageBean.DEFAULTPAGESIZE, currentPage,channelId);
		
		return SUCCESS;
	}

	public TChannelInviteService gettChannelInviteService() {
		return tChannelInviteService;
	}

	public void settChannelInviteService(TChannelInviteService tChannelInviteService) {
		this.tChannelInviteService = tChannelInviteService;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public String getModelError() {
		return modelError;
	}

	public void setModelError(String modelError) {
		this.modelError = modelError;
	}
}
