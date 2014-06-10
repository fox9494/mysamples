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
import com.soarsky.octopus.manager.service.TRoleInfoService;
import com.soarsky.octopus.mapping.TArea;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TChannelIndustry;
import com.soarsky.octopus.mapping.TRoleInfo;
import com.soarsky.octopus.utils.MD5Util;

public class ChannelManagerAddChannelAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -65353324947887960L;
	
	private TChannel channel;
	
	private TChannelService tChannelService;
	
	private TAreaService tAreaService;
	
	private TChannelIndustryService tChannelIndustryService;
	
    private List<TArea>  listArea;
	
	private List<TChannelIndustry>  listIndustry;
	
	private Long channelId;
	
	private TChannel parChannel; //上级渠道
	
	private TRoleInfoService  tRoleInfoService;
	
	private TManagerInfoService  tManagerInfoService;
	
	

	/*
	 * 初始化新增渠道页面
	 */
	public String initAddChannel(){
		
		listArea = tAreaService.findLevelArea(JEEContant.ROOTAREA);		
		listIndustry = tChannelIndustryService.findAllChannelIndustry();
		parChannel=this.tChannelService.findByChannel(channelId);
		parChannel.setLevelCode(this.tChannelService.getChannelCode(this.tChannelService.findByRow(channelId), JEEContant.OTHERCHANNEL_NUMBER,this.tChannelService.findByCode(channelId)));
		return INPUT;
	}
    
	/*
	 * 新增渠道
	 */
	public String addChannel(){
		
		channel.setCreateDate(new Date());
		channel.setIsRemove(JEEContant.NOTROMOVE);
		channel.getTManagerInfo().setRealName(channel.getChannelName());
		channel.getTManagerInfo().setPassword(MD5Util.getMD5(channel.getTManagerInfo().getPassword()));
		channel.getTManagerInfo().setIsRemove(JEEContant.NOTROMOVE);
		TRoleInfo tRole=this.tRoleInfoService.findRole(JEEContant.INITROLEID);
		channel.getTManagerInfo().setTRoleInfo(tRole);
		tChannelService.addChannel(channel);
		return SUCCESS;
	}
	/**
	 * 查询上级渠道名字
	 * @return
	 */
	public String findByParent(){
		parChannel=this.tChannelService.findByParent(channelId);
		return SUCCESS;
	}
	
	/**
	 * 增加渠道后台验证
	 * @return
	 */
	public void validateAddChannel(){
		
		
		
		if(channel.getChannelName().trim().length()<1||this.tChannelService.findJudgeChannel(channel)){
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
		if(channel.getTManagerInfo().getUserName().trim().length()<1||this.tManagerInfoService.judgeUserName(channel.getTManagerInfo().getUserName())){
			this.addFieldError(ChannelErrorMsg.USERNAME, ChannelErrorMsg.USERNAME_MSG);
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

	public TRoleInfoService gettRoleInfoService() {
		return tRoleInfoService;
	}

	public void settRoleInfoService(TRoleInfoService tRoleInfoService) {
		this.tRoleInfoService = tRoleInfoService;
	}

	public TManagerInfoService gettManagerInfoService() {
		return tManagerInfoService;
	}

	public void settManagerInfoService(TManagerInfoService tManagerInfoService) {
		this.tManagerInfoService = tManagerInfoService;
	}
	
	

	
	
	
	
	
	
}
