package com.soarsky.octopus.channel.action;

import com.soarsky.octopus.channel.constant.ChannelContent;
import com.soarsky.octopus.channel.contant.ChannelIndustryErrorMsg;
import com.soarsky.octopus.channel.service.TChannelIndustryService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TChannelIndustry;

public class ChannelIndustryAddAction extends BaseAction {

	private static final long serialVersionUID = 660959921478496778L;
    
	private TChannelIndustry channelindustry;
	
	private TChannelIndustryService tChannelIndustryService;
	
	/**
	 * 添加行业
	 * @author lw
	 * @return
	*/
	public String addChannelIndustry(){
		
		channelindustry.setIsRemove(ChannelContent.NOTROMOVE);
		
		tChannelIndustryService.addChannelIndustry(channelindustry);
		
		return SUCCESS;
	}
    
	/**
	 * 验证添加行业信息
	 * @author lw
	*/
	public void validateAddChannelIndustry(){
		
		Boolean isExist=tChannelIndustryService.findChannelIndustryByName(channelindustry);
		
		if(isExist){
			this.addFieldError(ChannelIndustryErrorMsg.NAMEEXIST, ChannelIndustryErrorMsg.NAMEEXIST_MSG);
		}
		if(channelindustry.getName().length()<1){
			this.addFieldError(ChannelIndustryErrorMsg.NAME, ChannelIndustryErrorMsg.NAME_MSG);
		}
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
