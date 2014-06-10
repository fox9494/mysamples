package com.soarsky.octopus.channel.action;

import com.soarsky.octopus.channel.service.TChannelIndustryService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.mapping.TChannelIndustry;
import com.soarsky.octopus.utils.PageBean;

public class ChannelIndustryListAction extends PageAction {
	
	private static final long serialVersionUID = 8004475630111156851L;
    
	private TChannelIndustryService tChannelIndustryService;
	
	private TChannelIndustry channelindustry;
    
	/**
	 * 分页查询所有行业
	 * @author lw
	 * @return
	*/
    public String getChannelIndustryList(){
    	
    	pageBean=tChannelIndustryService.getChannelIndustryList(PageBean.DEFAULTPAGESIZE, currentPage, channelindustry);
    	
    	return SUCCESS;
    }
	public TChannelIndustryService gettChannelIndustryService() {
		return tChannelIndustryService;
	}

	public void settChannelIndustryService(
			TChannelIndustryService tChannelIndustryService) {
		this.tChannelIndustryService = tChannelIndustryService;
	}
	
	public TChannelIndustry getChannelindustry() {
		return channelindustry;
	}
	public void setChannelindustry(TChannelIndustry channelindustry) {
		this.channelindustry = channelindustry;
	}
}
