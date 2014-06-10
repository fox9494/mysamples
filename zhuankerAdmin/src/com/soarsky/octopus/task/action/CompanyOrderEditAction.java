package com.soarsky.octopus.task.action;

import java.util.List;

import com.soarsky.octopus.channel.service.TChannelIndustryService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.mapping.TChannelIndustry;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.mapping.TCompanyOrder;
import com.soarsky.octopus.task.constant.CompanyOrderErrorMsg;
import com.soarsky.octopus.task.service.TCompanyOrderService;
import com.soarsky.octopus.task.service.TCompanyService;
import com.soarsky.octopus.utils.PageBean;

public class CompanyOrderEditAction extends PageAction {

	private static final long serialVersionUID = 2560516215085062598L;
    
    private TCompanyOrderService  tCompanyOrderService;
    
    private TCompanyService tCompanyService;
	
    private TChannelIndustryService tChannelIndustryService;
	
    private List<TChannelIndustry> channelIndustrys;
    
    private TChannelIndustry channelindustry;
	
	private TCompanyOrder order;
	
	private TCompany company;
	
	private String info;
	
    /**
     * 初始化要修改的订单对象
     * @author lw
     * @return
	*/
	public String input() {
		
		TCompanyOrder initorder=new TCompanyOrder();
		
		initorder.setId(Long.valueOf(info));
		
		order=tCompanyOrderService.initOrder(initorder);
		
		company=order.getCompany();  //初始化客户
		
		return SUCCESS;
	}
	/**
	 * 修改订单对象
	 * @author lw
	 * @return
	*/
	public String save() {
		
		order.setCompany(company);
	    
        Double totalNumber=(order.getTotalmoney()/order.getUnitprice());
		
		order.setTotalNumber(totalNumber.longValue());
		
		tCompanyOrderService.editOrder(order);
		
		return "editsuccess";
	}
	
	/**
	 * 验证修改订单
	 * @author lw
	*/
    public void validateSave(){
    	
    	TCompanyOrder oldOrder=tCompanyOrderService.initOrder(order);
    	
    	if(!order.getName().equals(oldOrder.getName())){
    		Boolean isExist=tCompanyOrderService.findOrderByName(order);
    		if(isExist){
    			this.addFieldError(CompanyOrderErrorMsg.NAMEEXIST, CompanyOrderErrorMsg.NAMEEXIST_MSG);
    		}
    	}
    	if(order.getName().length()<1){
    		this.addFieldError(CompanyOrderErrorMsg.NAME, CompanyOrderErrorMsg.NAME_MSG);
    	}
    	if(company.getName().length()<1){
    		this.addFieldError(CompanyOrderErrorMsg.COMPANYNAME, CompanyOrderErrorMsg.COMPANYNAME_MSG);
    	}
    	if(order.getStartDate()==null){
    		this.addFieldError(CompanyOrderErrorMsg.STARTDATE, CompanyOrderErrorMsg.STARTDATE_MSG);
    	}
    	if(order.getEndDate()==null){
    		this.addFieldError(CompanyOrderErrorMsg.ENDDATE, CompanyOrderErrorMsg.ENDDATE_MSG);
    	}
    	if(order.getTotalmoney()==null){
    		this.addFieldError(CompanyOrderErrorMsg.TOTALMONEY, CompanyOrderErrorMsg.TOTALMONEY_MSG);
    	}
    	if(order.getUnitprice()==null){
    		this.addFieldError(CompanyOrderErrorMsg.UNITPRICE, CompanyOrderErrorMsg.UNITPRICE_MSG);
    	}
    	if(order.getUnitprice()!=null&&order.getTotalmoney()!=null){
	    	if(order.getUnitprice()>order.getTotalmoney()){
	    		this.addFieldError(CompanyOrderErrorMsg.TOTALMONEY_UTILPRICE, CompanyOrderErrorMsg.TOTALMONEY_UTILPRICE_MSG);
	    	}
    	}
    	
    }
	/**
	 * 得到所有客户信息
	 * @author lw
	 * @return
	*/
    public String  getAllCompany(){
		
    	channelIndustrys=tChannelIndustryService.findAllChannelIndustry();
    	
    	pageBean=tCompanyService.queryPageList(PageBean.DEFAULTPAGESIZE, currentPage, company);
    	
    	return "initsuccess";
	}
    
    /**
     * 根据条件查询客户
     * @author lw
     * @return
    */
    public String  getCompanyByConditions(){
    	
        company.setChannelIndustry(channelindustry);
		
		pageBean=tCompanyService.queryByNameOrProfession(PageBean.DEFAULTPAGESIZE, currentPage, company);
		
		channelIndustrys=tChannelIndustryService.findAllChannelIndustry();
		
		return "findbyconditions";
    }
	
    /**
     * 确认客户
     * @author lw
     * @return
    */
    public String  confirmCompany(){
    	
       company=tCompanyService.findUserById(company);
       
       order=tCompanyOrderService.initOrder(order); //重新初始化订单信息
    	
       return "confirmsuccess";	
    }

	public TCompanyOrderService gettCompanyOrderService() {
		return tCompanyOrderService;
	}

	public void settCompanyOrderService(TCompanyOrderService tCompanyOrderService) {
		this.tCompanyOrderService = tCompanyOrderService;
	}

	public TCompanyOrder getOrder() {
		return order;
	}

	public void setOrder(TCompanyOrder order) {
		this.order = order;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
