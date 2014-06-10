package com.soarsky.octopus.task.action;

import java.util.List;

import com.soarsky.octopus.channel.service.TChannelIndustryService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TArea;
import com.soarsky.octopus.mapping.TChannelIndustry;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.task.constant.CompanyErrorMsg;
import com.soarsky.octopus.task.constant.TaskContent;
import com.soarsky.octopus.task.service.TCompanyService;

public class CompanyAddAction extends BaseAction{

	private static final long serialVersionUID = -2875663482198783296L;
    
	private TCompany company;
	
	private TCompanyService tCompanyService;
	
	private TChannelIndustryService tChannelIndustryService;
	
	private List<TChannelIndustry> channelIndustrys;
	
	private TChannelIndustry channelindustry;
	
	private TArea area;
	/** 
	 * 添加客户
	 * @author lw
	 * @return
	*/
	public String addUserClient(){
		
		company.setChannelIndustry(channelindustry);
		if(area.getId()!=null){
		    company.setArea(area);
		}
		java.util.Date utilDate=new java.util.Date();
		
		company.setCreateDate(utilDate);
		
		company.setIsRemove(TaskContent.NOTROMOVE);
		
		tCompanyService.addUserClient(company);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化添加客户行业属性
	 * @author lw
	 * @return
	*/
	public String initAddUserClient(){
		
		channelIndustrys=tChannelIndustryService.findAllChannelIndustry();
		
		return "initaddsuccess";
	}
    
	/**
	 * 验证添加客户
	 * @author lw
	*/
	public void validateAddUserClient(){
		
		Boolean isExist=tCompanyService.findCompanyByName(company);
		
		//验证名称是否已被使用
		if(isExist){
			channelIndustrys=tChannelIndustryService.findAllChannelIndustry();//初始化行业信息
			this.addFieldError(CompanyErrorMsg.NAMEEXIST, CompanyErrorMsg.NAMEEXIST_MSG);
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
