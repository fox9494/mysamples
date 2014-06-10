package com.soarsky.octopus.reports.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.soarsky.octopus.reports.service.ReportStatisticsService;
import com.soarsky.octopus.reports.service.impl.ReportStatisticsServiceImpl;
import com.soarsky.octopus.reports.vo.Application;

/**
 * 处理异步请求指定客户发布的所有应用信息列表的action
 * @author ouyang
 *
 */
public class AjaxAppListAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Long companyID;//客户信息
	private List<Application> apps;//与页面通信封装指定客户发布的应用列表
	
	private ReportStatisticsService reportStatisticsService = new ReportStatisticsServiceImpl();//处理报表统计相关业务逻辑	
	
	public String ajaxAppList() {
		//根据companyID查询该客户发布的所有应用
		apps = reportStatisticsService.queryApps(companyID);
		return SUCCESS;
	}

	public Long getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}

	public List<Application> getApps() {
		return apps;
	}

	public void setApps(List<Application> apps) {
		this.apps = apps;
	}

	public void setReportStatisticsService(
			ReportStatisticsService reportStatisticsService) {
		this.reportStatisticsService = reportStatisticsService;
	}
	
}
