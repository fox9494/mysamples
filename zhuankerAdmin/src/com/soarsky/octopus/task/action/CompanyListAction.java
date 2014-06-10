package com.soarsky.octopus.task.action;

import java.util.List;

import com.soarsky.octopus.channel.service.TChannelIndustryService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.mapping.TChannelIndustry;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.task.service.TCompanyService;
import com.soarsky.octopus.utils.PageBean;

public class CompanyListAction extends PageAction {
	
	private static final long serialVersionUID = 1809387213022095591L;
	
    private TCompanyService tCompanyService;
    
    private TChannelIndustryService tChannelIndustryService;
    
    private List<TChannelIndustry> channelIndustrys;
    
    private TChannelIndustry channelindustry;
    
    private TCompany company;

	/**
	 * 分页查询所有客户
	 * @author lw
	 * @return
	*/
	public String  getUserList(){
		
		channelIndustrys=tChannelIndustryService.findAllChannelIndustry();
		
		pageBean=tCompanyService.queryPageList(PageBean.DEFAULTPAGESIZE, currentPage, company);
		
		return SUCCESS;
	}
    
	/**
	 * 根据客户名和职业进行模糊查询
	 * @author lw
	 * @return
	*/
	public String findByConditions(){
		
		company.setChannelIndustry(channelindustry);
		
		pageBean=tCompanyService.queryByNameOrProfession(PageBean.DEFAULTPAGESIZE, currentPage, company);
		
		channelIndustrys=tChannelIndustryService.findAllChannelIndustry();
		
		return "findbynameorprofession";
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public TCompanyService gettCompanyService() {
		return tCompanyService;
	}

	public void settCompanyService(TCompanyService tCompanyService) {
		this.tCompanyService = tCompanyService;
	}


	public TCompany getCompany() {
		return company;
	}

	public void setCompany(TCompany company) {
		this.company = company;
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
}
