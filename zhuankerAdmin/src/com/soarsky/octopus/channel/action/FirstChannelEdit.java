package com.soarsky.octopus.channel.action;

import java.util.Date;
import java.util.List;

import com.soarsky.octopus.channel.service.TChannelIndustryService;
import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.clientuser.service.TAreaService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.service.TRoleInfoService;
import com.soarsky.octopus.mapping.TArea;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TChannelIndustry;
import com.soarsky.octopus.mapping.TManagerInfo;
import com.soarsky.octopus.mapping.TRoleInfo;
import com.soarsky.octopus.utils.MD5Util;

public class FirstChannelEdit extends BaseAction{


	private static final long serialVersionUID = -5112518367756143520L;
	
	private TAreaService tAreaService;
			
	private TChannelIndustryService tChannelIndustryService;
	
	private TRoleInfoService  tRoleInfoService;
		
	private List<TArea>  listArea;
	
	private List<TChannelIndustry>  listIndustry;
	
	private List<TRoleInfo>  listRole;
	
	private TChannel channel;
	
	private TChannelService tChannelService;
	
	private TChannelIndustry channelIndustry;
	
	private TArea area;
	
	private String ids; 
	
	/**
	 * 更新一级渠道
	 * @return
	 */
	public String editFirstChannel(){
		//删除以前的账号密码
		TChannel old = tChannelService.getFirstChannelById(channel.getId());
		//逻辑删除
		tChannelService.deleteOldManageinfo(old.getTManagerInfo().getId());		
		channel.setCreateDate(new Date());		
		channel.setIsRemove(JEEContant.NOTROMOVE);
		channel.getTManagerInfo().setCreateDate(new Date());
		channel.getTManagerInfo().setIsRemove(JEEContant.NOTROMOVE);
		channel.getTManagerInfo().setPassword(MD5Util.getMD5(channel.getTManagerInfo().getPassword()));
		tChannelService.editFirstChannel(channel);
		return SUCCESS;
	}
	/**
	 * 更新一级渠道初始化
	 */
	public String input(){			
		channel = tChannelService.getFirstChannelById(Long.valueOf(ids));
		listArea = tAreaService.findLevelArea(JEEContant.ROOTAREA);
		listIndustry = tChannelIndustryService.findAllChannelIndustry();
		listRole = tRoleInfoService.findAllRole();
		return super.input();
	}
	public TArea getArea() {
		return area;
	}
	public void setArea(TArea area) {
		this.area = area;
	}

	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}

	public void settAreaService(TAreaService tAreaService) {
		this.tAreaService = tAreaService;
	}

	public TChannelIndustryService gettChannelIndustryService() {
		return tChannelIndustryService;
	}

	public void settChannelIndustryService(TChannelIndustryService tChannelIndustryService) {			
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

	public List<TRoleInfo> getListRole() {
		return listRole;
	}

	public void setListRole(List<TRoleInfo> listRole) {
		this.listRole = listRole;
	}

	public TRoleInfoService gettRoleInfoService() {
		return tRoleInfoService;
	}

	public void settRoleInfoService(TRoleInfoService tRoleInfoService) {
		this.tRoleInfoService = tRoleInfoService;
	}
	public TChannel getChannel() {
		return channel;
	}
	public void setChannel(TChannel channel) {
		this.channel = channel;
	}
	
	public void settChannelService(TChannelService tChannelService) {
		this.tChannelService = tChannelService;
	}
	public TChannelIndustry getChannelIndustry() {
		return channelIndustry;
	}
	public void setChannelIndustry(TChannelIndustry channelIndustry) {
		this.channelIndustry = channelIndustry;
	}

	
}
