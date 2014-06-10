package com.soarsky.octopus.channel.action;


import java.util.Date;
import java.util.List;



import com.soarsky.octopus.channel.contant.FirstChannelErrorMsg;
import com.soarsky.octopus.channel.service.TChannelIndustryService;
import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.clientuser.service.TAreaService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.service.TRoleInfoService;
import com.soarsky.octopus.mapping.TArea;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TChannelIndustry;
import com.soarsky.octopus.mapping.TRoleInfo;
import com.soarsky.octopus.utils.MD5Util;

public class ChannelFirstLevelAddAction extends BaseAction {


	private static final long serialVersionUID = -8559384639990358863L;

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
	
	private String province;
	


	/**
	 * 初始化
	 */
	public String input() {
		listArea = tAreaService.findLevelArea(JEEContant.ROOTAREA);		
		listIndustry = tChannelIndustryService.findAllChannelIndustry();
		listRole = tRoleInfoService.findAllRole();
		return super.input();
	}
	/**
	 * 添加一级渠道
	 * @return
	 */
	public String saveFirstChannel(){				
				channel.setCreateDate(new Date());
				channel.setIsRemove(JEEContant.NOTROMOVE);
				
				channel.getTManagerInfo().setCreateDate(new Date());
				channel.getTManagerInfo().setIsRemove(JEEContant.NOTROMOVE);
				channel.getTManagerInfo().setPassword(MD5Util.getMD5(channel.getTManagerInfo().getPassword()));
				channel.getTManagerInfo().setRealName(channel.getChannelName());
				tChannelService.saveFirstChannel(channel);
				return SUCCESS;			
	}
	//校验
	public void validateSaveFirstChannel(){
		if(channel.getChannelName().trim().length()<1){
			this.addFieldError(FirstChannelErrorMsg.CHANNELNAME, FirstChannelErrorMsg.CHANNELNAME_MSG);
		}
		if(!tChannelService.findFirstChannelByName(channel.getChannelName())){
			this.addFieldError(FirstChannelErrorMsg.CHANNELNAME, FirstChannelErrorMsg.CHANNELNAME_MSG1);
		}
		if(channel.getTManagerInfo().getUserName().trim().length()<1){
			this.addFieldError(FirstChannelErrorMsg.USERNAME, FirstChannelErrorMsg.USERNAME_MSG);
		}
		if(!tChannelService.checkManageinfo(channel.getTManagerInfo().getUserName())){
			this.addFieldError(FirstChannelErrorMsg.USERNAME, FirstChannelErrorMsg.USERNAME_MSG1);
		}
		if(channel.getContactPerson().trim().length()<1){
			this.addFieldError(FirstChannelErrorMsg.CONTACTPERSON, FirstChannelErrorMsg.CONTACTPERSON_MSG);
		}
		if(channel.getMobile().trim().length()<1){
			this.addFieldError(FirstChannelErrorMsg.MOBLIE, FirstChannelErrorMsg.MOBLIE_MSG);
		}
		if(channel.getEmail().trim().length()<1){
			this.addFieldError(FirstChannelErrorMsg.EMAIL, FirstChannelErrorMsg.EMAIL_MSG);
		}
		if(channel.getBank().trim().length()<1){
			this.addFieldError(FirstChannelErrorMsg.BANK, FirstChannelErrorMsg.BANK_MSG);			
		}
		if(channel.getBankName().trim().length()<1){
			this.addFieldError(FirstChannelErrorMsg.BANKNAME, FirstChannelErrorMsg.BANKNAME_MSG);
		}
		if(channel.getBankAccount().trim().length()<1){
			this.addFieldError(FirstChannelErrorMsg.BANKACCOUNT, FirstChannelErrorMsg.BANKACCOUNT_MSG);
		}
		if(channel.getPaylevel().toString().trim().length()<1){
			this.addFieldError(FirstChannelErrorMsg.PAYLEVEL, FirstChannelErrorMsg.PASSWORD_MSG);
		}
		if(channel.getTManagerInfo().getPassword().trim().length()<1){
			this.addFieldError(FirstChannelErrorMsg.PASSWORD, FirstChannelErrorMsg.PASSWORD_MSG);
		}
		if(this.hasFieldErrors()){
			listArea = tAreaService.findLevelArea(JEEContant.ROOTAREA);
			listIndustry = tChannelIndustryService.findAllChannelIndustry();
		}
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

	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
}
