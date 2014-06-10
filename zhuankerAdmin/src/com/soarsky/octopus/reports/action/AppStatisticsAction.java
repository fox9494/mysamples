package com.soarsky.octopus.reports.action;

import java.util.List;

import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.reports.service.ReportStatisticsService;
import com.soarsky.octopus.reports.vo.StatisticsReport;
import com.soarsky.octopus.utils.PageBean;

/**
 * 处理应用下载安装量统计的action
 * @author ouyang
 *
 */
public class AppStatisticsAction extends PageAction {
	private static final long serialVersionUID = 1L;
	
	private StatisticsReport statisticsReport;//与页面通信封装下载量统计显示列表相关数据
	private List<TCompany> companys;//与页面通信封装客户信息简要列表
	
	private ReportStatisticsService reportStatisticsService;//处理报表统计相关业务逻辑
	
	/**
	 * 调用sercvice层相关方法查询统计某客户的某应用的安装量，如无条件则查询所有
	 * @return
	 */
	public String appInstallsStatistics() {
		
		//查询统计某客户的某应用的安装量，如无条件则查询所有
		if(statisticsReport == null){
			pageBean = reportStatisticsService.appInstallsStatistics(PageBean.DEFAULTPAGESIZE, this.currentPage, null, null);
		} else {
			pageBean = reportStatisticsService.appInstallsStatistics(PageBean.DEFAULTPAGESIZE, this.currentPage, statisticsReport.getCompanyId(), statisticsReport.getAppId());
		}
		//查询所有客户信息列表
		companys = reportStatisticsService.queryCompanys();
		return SUCCESS;
	}
	
	/**
	 * 调用sercvice层相关方法查询统计某客户的某应用的下载量，如无条件则查询所有
	 * @return
	 */
	public String appDownloadStatistics() {
		
		//查询统计某客户的某应用的安装量，如无条件则查询所有
		if(statisticsReport == null){
			pageBean = reportStatisticsService.appDownloadStatistics(PageBean.DEFAULTPAGESIZE, this.currentPage, null, null);
		} else {
			pageBean = reportStatisticsService.appDownloadStatistics(PageBean.DEFAULTPAGESIZE, this.currentPage, statisticsReport.getCompanyId(), statisticsReport.getAppId());
		}
		//查询所有客户信息列表
		companys = reportStatisticsService.queryCompanys();
		return SUCCESS;
	}
	
	/**
	 * 调用sercvice层相关方法查询统计某客户的某应用的使用流量情况，如无条件则查询所有
	 * @return
	 */
	public String appFlowStatistics() {
		
		//查询统计某客户的某应用的安装量，如无条件则查询所有
		if(statisticsReport == null){
			pageBean = reportStatisticsService.appFlowStatistics(PageBean.DEFAULTPAGESIZE, this.currentPage, null, null);
		} else {
			pageBean = reportStatisticsService.appFlowStatistics(PageBean.DEFAULTPAGESIZE, this.currentPage, statisticsReport.getCompanyId(), statisticsReport.getAppId());
		}
		//查询所有客户信息列表
		companys = reportStatisticsService.queryCompanys();
		return SUCCESS;
	}
	

	public StatisticsReport getStatisticsReport() {
		return statisticsReport;
	}

	public void setStatisticsReport(StatisticsReport statisticsReport) {
		this.statisticsReport = statisticsReport;
	}

	public List<TCompany> getCompanys() {
		return companys;
	}

	public void setCompanys(List<TCompany> companys) {
		this.companys = companys;
	}

	public void setReportStatisticsService(
			ReportStatisticsService reportStatisticsService) {
		this.reportStatisticsService = reportStatisticsService;
	}
	
}
