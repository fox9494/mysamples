package com.soarsky.octopus.channel.action;

import com.soarsky.octopus.channel.service.TChannelIndustryService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TChannelIndustry;

public class ChannelIndustryDeleteAction extends BaseAction{

	private static final long serialVersionUID = 8208156543760236029L;
    
    private TChannelIndustry channelindustry;
	
	private TChannelIndustryService tChannelIndustryService;
	
	/**
	 * 删除行业
	 * @author lw
	 * @return
	*/
	public String deleteChannelIndustry(){
		
		tChannelIndustryService.deleteChannelIndustry(channelindustry);
		
		return SUCCESS;
	}

	public TChannelIndustry getChannelindustry() {
		return channelindustry;
	}

	public void setChannelindustry(TChannelIndustry channelindustry) {
		this.channelindustry = channelindustry;
	}

	public TChannelIndustryService gettChannelIndustryService() {
		return tChannelIndustryService;
	}

	public void settChannelIndustryService(
			TChannelIndustryService tChannelIndustryService) {
		this.tChannelIndustryService = tChannelIndustryService;
	}
}
