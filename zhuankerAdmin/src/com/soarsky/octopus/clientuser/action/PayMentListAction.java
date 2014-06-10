package com.soarsky.octopus.clientuser.action;



import com.soarsky.octopus.clientuser.service.TExchangeLogService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.mapping.TExchangeLog;
import com.soarsky.octopus.utils.PageBean;

public class PayMentListAction extends PageAction{

	private static final long serialVersionUID = 2303890472850832805L;
	
	private TExchangeLogService tExchangeLogService;
	
	private TExchangeLog exLog;
	
	private String startyear;
	
	private String endyear;
	
	/**
	 * 用户结算
	 */
	public String searchList(){		
		pageBean = tExchangeLogService.findAllPayMent(PageBean.DEFAULTPAGESIZE, currentPage);
		return SUCCESS;
	}
	/**
	 * 
	 * 用户结算，条件查询
	 *  
	 */
	public String searchPayMentByParams() {		
		pageBean = tExchangeLogService.findPayMentByParams(PageBean.DEFAULTPAGESIZE, currentPage, startyear, endyear,exLog);
		return SUCCESS;
	}
	public void settExchangeLogService(TExchangeLogService tExchangeLogService) {
		this.tExchangeLogService = tExchangeLogService;
	}
	public TExchangeLog getExLog() {
		return exLog;
	}
	public void setExLog(TExchangeLog exLog) {
		this.exLog = exLog;
	}
	public String getStartyear() {
		return startyear;
	}
	public void setStartyear(String startyear) {
		this.startyear = startyear;
	}
	public String getEndyear() {
		return endyear;
	}
	public void setEndyear(String endyear) {
		this.endyear = endyear;
	}
	


}
