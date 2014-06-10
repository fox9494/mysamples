package com.soarsky.octopus.channel.action;

import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.utils.PageBean;

public class FirstChannelListAction extends PageAction{

	
	private static final long serialVersionUID = -22916831611594708L;
	
	private TChannelService tChannelService;
	
	public String searchList(){
		pageBean = tChannelService.findAllFirstChannel(PageBean.DEFAULTPAGESIZE, currentPage);
		return SUCCESS;
	}
	public void settChannelService(TChannelService tChannelService) {
		this.tChannelService = tChannelService;
	}
}
