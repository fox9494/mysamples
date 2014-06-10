package com.soarsky.octopus.channel.action;

import com.soarsky.octopus.channel.contant.ChannelIndustryErrorMsg;
import com.soarsky.octopus.channel.service.TChannelIndustryService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TChannelIndustry;

public class ChannelIndustryEditAction extends BaseAction {

	private static final long serialVersionUID = 2754333428215752232L;
	
    private TChannelIndustryService tChannelIndustryService;
	
	private TChannelIndustry channelindustry;
    
	/**
	 * 初始化要查询的行业对象
	 * @author lw
	 * @return
	*/
	public  String initChannelIndustry(){
		
		channelindustry=tChannelIndustryService.initChannelIndustry(channelindustry);
		
		return SUCCESS;
	}
	/**
	 * 修改行业对象
	 * @author lw
	 * @return
	*/
	public String editChannelIndustry(){
		
		tChannelIndustryService.updateChannelIndustry(channelindustry);
		
		return "editsuccess";
	}
	
	public void validateEditChannelIndustry(){
		
		TChannelIndustry oldChannel=tChannelIndustryService.initChannelIndustry(channelindustry);
		
		if(!channelindustry.getName().equals(oldChannel.getName())){
			Boolean isExist=tChannelIndustryService.findChannelIndustryByName(channelindustry);
			if(isExist){
				this.addFieldError(ChannelIndustryErrorMsg.NAMEEXIST, ChannelIndustryErrorMsg.NAMEEXIST_MSG);
			}
		}
		if(channelindustry.getName().length()<1){
			this.addFieldError(ChannelIndustryErrorMsg.NAME, ChannelIndustryErrorMsg.NAME_MSG);
		}
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
