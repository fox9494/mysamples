package com.soarsky.octopus.channel.action;

import java.util.Date;
import java.util.List;

import com.soarsky.octopus.channel.contant.ChannelErrorMsg;
import com.soarsky.octopus.channel.service.TChannelIndustryService;
import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.clientuser.service.TAreaService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.service.TManagerInfoService;
import com.soarsky.octopus.mapping.TArea;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TChannelIndustry;
import com.soarsky.octopus.mapping.TManagerInfo;
import com.soarsky.octopus.utils.MD5Util;

public class ChannelManagerEditAction extends BaseAction {
	
private static final long serialVersionUID = -65353324947887960L;
	
	private TChannel channel;
	
	private TChannelService tChannelService;
	
	private TAreaService tAreaService;
	
	private TChannelIndustryService tChannelIndustryService;
	
    private List<TArea>  listArea;
	
	private List<TChannelIndustry>  listIndustry;
	
	private Long channelId;
	
	private TChannel parChannel; //上级渠道
	
	private TManagerInfo tManagerInfo;
	
	private TManagerInfoService tManagerInfoService;
	
	
	/**
	 * 初始化更新渠道界面
	 * @return
	 */
	public String initEditChannel(){
		
		listArea = tAreaService.findLevelArea(JEEContant.ROOTAREA);		
		listIndustry = tChannelIndustryService.findAllChannelIndustry();
		channel=this.tChannelService.findByChannel(channelId);
		parChannel=this.tChannelService.findByParent(channel.getParent().getId());
	    return INPUT;
	}
	
	/**
	 * 更新渠道
	 * @return
	 */
	public String editChannel(){
		
			
		channel.setCreateDate(new Date());
		channel.setIsRemove(JEEContant.NOTROMOVE);
		channel.getTManagerInfo().setIsRemove(JEEContant.NOTROMOVE);
		channel.getTManagerInfo().setUserName(channel.getTManagerInfo().getUserName());
		tChannelService.modifyChannel(channel);
		
	    return SUCCESS;
	}
	
	/**
	 * 修改渠道后台验证
	 * @return
	 */
	public  void validateEditChannel(){		
		
			String newName = channel.getTManagerInfo().getUserName();
			String oldName = tChannelService.getFirstChannelById(channel.getId()).getTManagerInfo().getUserName();
			String newChannelName = channel.getChannelName();
			String oldChannelName = tChannelService.getFirstChannelById(channel.getId()).getChannelName();
			parChannel=this.tChannelService.findByParent(channel.getParent().getId());
		if(channel.getChannelName().trim().length()<1||this.tChannelService.checkChannel(newName, oldName)){
			this.addFieldError(ChannelErrorMsg.CHANNELName,ChannelErrorMsg.CHANNELName_MSG );
		}
		if(channel.getContactPerson().trim().length()<1){
			this.addFieldError(ChannelErrorMsg.CONTACTPERSON, ChannelErrorMsg.CHANNELName_MSG);
			
		}
		if(channel.getMobile().trim().length()<6&&channel.getMobile().trim().length()>13){
			
			this.addFieldError(ChannelErrorMsg.MOBLIE, ChannelErrorMsg.MOBLIE_MSG);
		}
		if(channel.getEmail().trim().length()<1){
			this.addFieldError(ChannelErrorMsg.EMAIL, ChannelErrorMsg.EMAIL_MSG);
		}
		if(!oldName.equals(newName)){
			
			if(tManagerInfoService.judgeUserName(newName)){
				
			   this.addFieldError(ChannelErrorMsg.USERNAME, ChannelErrorMsg.USERNAME_MSG);
			}
		}
		if(channel.getTManagerInfo().getPassword().trim().length()<6){
			this.addFieldError(ChannelErrorMsg.PASSWORD, ChannelErrorMsg.PASSWORD_MSG);
		}
		if(this.hasFieldErrors()){
			listArea = tAreaService.findLevelArea(JEEContant.ROOTAREA);		
			listIndustry = tChannelIndustryService.findAllChannelIndustry();
			
		}
		
			
		
		
		
	}
	

	public TChannelService gettChannelService() {
		return tChannelService;
	}

	public void settChannelService(TChannelService tChannelService) {
		this.tChannelService = tChannelService;
	}



	public TChannel getChannel() {
		return channel;
	}



	public void setChannel(TChannel channel) {
		this.channel = channel;
	}



	public TAreaService gettAreaService() {
		return tAreaService;
	}



	public void settAreaService(TAreaService tAreaService) {
		this.tAreaService = tAreaService;
	}



	public TChannelIndustryService gettChannelIndustryService() {
		return tChannelIndustryService;
	}



	public void settChannelIndustryService(
			TChannelIndustryService tChannelIndustryService) {
		this.tChannelIndustryService = tChannelIndustryService;
	}



	public List<TArea> getListArea() {
		return listArea;
	}



	public void setListArea(List<TArea> listArea) {
		this.listArea = listArea;
	}



	public List<TChannelIndustry> getListIndustry() {
		return listIndustry;
	}



	public void setListIndustry(List<TChannelIndustry> listIndustry) {
		this.listIndustry = listIndustry;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public TChannel getParChannel() {
		return parChannel;
	}



	public void setParChannel(TChannel parChannel) {
		this.parChannel = parChannel;
	}

	public TManagerInfo gettManagerInfo() {
		return tManagerInfo;
	}

	public void settManagerInfo(TManagerInfo tManagerInfo) {
		this.tManagerInfo = tManagerInfo;
	}

	public TManagerInfoService gettManagerInfoService() {
		return tManagerInfoService;
	}

	public void settManagerInfoService(TManagerInfoService tManagerInfoService) {
		this.tManagerInfoService = tManagerInfoService;
	}
	
	
	
	

}
