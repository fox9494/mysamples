package com.soarsky.octopus.reports.action;


import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.reports.service.ReportStatisticsService;
import com.soarsky.octopus.utils.PageBean;

/**
 * 用户安装应用统计
 * @author ouyang
 *
 */
public class UserAppStatisticsAction extends PageAction {
	private static final long serialVersionUID = 1L;

	private String appName;//与页面通信封装查询条件应用名称
	
	private ReportStatisticsService reportStatisticsService;//处理报表统计相关业务逻辑

	
	public String userAppStatistics() {
		
		//根据应用名字统计该应用有多少用户安装了(无名字统计所有应用)
		pageBean = reportStatisticsService.userAppStatistics(PageBean.DEFAULTPAGESIZE, this.currentPage, appName);
		return SUCCESS;
	}
	
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public void setReportStatisticsService(
			ReportStatisticsService reportStatisticsService) {
		this.reportStatisticsService = reportStatisticsService;
	}

}
