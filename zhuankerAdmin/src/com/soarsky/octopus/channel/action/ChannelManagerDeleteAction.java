package com.soarsky.octopus.channel.action;

import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.common.action.BaseAction;

public class ChannelManagerDeleteAction extends BaseAction {

	private TChannelService tChannelService;
	
	private Long id;

	
	
	/**
	 * 删除渠道
	 */
	public String deleteChannel(){
		this.tChannelService.deleteChannel(id);
		
		return SUCCESS;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public TChannelService gettChannelService() {
		return tChannelService;
	}

	public void settChannelService(TChannelService tChannelService) {
		this.tChannelService = tChannelService;
	}
	
	
}
