package com.soarsky.octopus.task.action;

import java.util.List;

import com.soarsky.octopus.channel.service.TChannelIndustryService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TArea;
import com.soarsky.octopus.mapping.TChannelIndustry;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.task.constant.CompanyErrorMsg;
import com.soarsky.octopus.task.service.TCompanyService;

public class CompanyEditAction extends BaseAction {

	private static final long serialVersionUID = -8873760458629723977L;
    
    private TCompany company;
	
	private TCompanyService tCompanyService;
	
    private TChannelIndustryService tChannelIndustryService;
	
	private List<TChannelIndustry> channelIndustrys;
	
	private TChannelIndustry channelindustry;
	
	private TArea area;
	
	private String info;
	/**
	 * 初始化客户对象
	 * @author lw
	 * @return
	*/
	public String initUserClient(){
	    
		channelIndustrys=tChannelIndustryService.findAllChannelIndustry();
		
		TCompany inituser=new TCompany();
		
		inituser.setId(Long.valueOf(info));
		
		company=tCompanyService.findUserById(inituser);
		
		return SUCCESS;
	}
    
	/**
	 * 修改客户
	 * @author lw
	 * @return
	*/
	public String editUserClient(){
	   
		company.setChannelIndustry(channelindustry);
		
		company.setArea(area);
		
		tCompanyService.updateUser(company);
		
		return "editsuccess";
	}
    
	/**
	 * 验证修改客户
	 * @author lw
	*/
	public void validateEditUserClient(){
		
		TCompany oldCompany=tCompanyService.findUserById(company);
		
		//验证名称是否已被使用
		if(!company.getName().equals(oldCompany.getName())){
			Boolean isExist=tCompanyService.findCompanyByName(company);
			if(isExist){
				channelIndustrys=tChannelIndustryService.findAllChannelIndustry();////初始化行业信息
				this.addFieldError(CompanyErrorMsg.NAMEEXIST, CompanyErrorMsg.NAMEEXIST_MSG);
			}
		}
		if(company.getName().length()<1){
			this.addFieldError(CompanyErrorMsg.NAME, CompanyErrorMsg.NAME_MSG);
		}
		if(company.getContactName().length()<1){
			this.addFieldError(CompanyErrorMsg.CONTACTNAME, CompanyErrorMsg.CONTACTNAME_MSG);
		}
		if(company.getPhone().length()<1||company.getPhone().length()>12){
			this.addFieldError(CompanyErrorMsg.PHONE, CompanyErrorMsg.PHONE_MSG);
		} 
		if(company.getEmail().length()<1){
			this.addFieldError(CompanyErrorMsg.EMAIL, CompanyErrorMsg.EMAIL_MSG);
		}
		if(company.getAddress().length()<1){
			this.addFieldError(CompanyErrorMsg.ADDRESS, CompanyErrorMsg.ADDRESS_MSG);
		}	
	}
	
	public TCompany getCompany() {
		return company;
	}

	public void setCompany(TCompany company) {
		this.company = company;
	}

	public TCompanyService gettCompanyService() {
		return tCompanyService;
	}

	public void settCompanyService(TCompanyService tCompanyService) {
		this.tCompanyService = tCompanyService;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public TChannelIndustryService gettChannelIndustryService() {
		return tChannelIndustryService;
	}

	public void settChannelIndustryService(
			TChannelIndustryService tChannelIndustryService) {
		this.tChannelIndustryService = tChannelIndustryService;
	}

	public List<TChannelIndustry> getChannelIndustrys() {
		return channelIndustrys;
	}

	public void setChannelIndustrys(List<TChannelIndustry> channelIndustrys) {
		this.channelIndustrys = channelIndustrys;
	}

	public TChannelIndustry getChannelindustry() {
		return channelindustry;
	}

	public void setChannelindustry(TChannelIndustry channelindustry) {
		this.channelindustry = channelindustry;
	}

	public TArea getArea() {
		return area;
	}

	public void setArea(TArea area) {
		this.area = area;
	}
}
