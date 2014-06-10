package com.soarsky.octopus.reports.action;


import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.reports.service.ReportStatisticsService;
import com.soarsky.octopus.reports.vo.UserReportVo;
import com.soarsky.octopus.utils.PageBean;

/**
 * 统计赚客网用户的action
 * @author zengganghong
 * @date 2013-5-10
 */
public class UserStatisticsAction extends PageAction {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 统计用VO
	 */
	private UserReportVo userReportVo;
	
	/**
	 * @return the userReportVo
	 */
	public UserReportVo getUserReportVo() {
		return userReportVo;
	}

	/**
	 * @param userReportVo the userReportVo to set
	 */
	public void setUserReportVo(UserReportVo userReportVo) {
		this.userReportVo = userReportVo;
	}

	/**
	 * 用户统计类型：1一级渠道统计,2地区统计,3赚客级别统计
	 */
	private String statType;
	
	/**
	 * 处理报表统计相关业务逻辑
	 */
	private ReportStatisticsService reportStatisticsService;
	
	/**
	 * 赚客用户统计
	 * @return
	 */
	public String userStatistics() {
		
		if(statType == null) {
			statType="1";
		}
		// 统计总用户信息
		userReportVo = reportStatisticsService.countAllUser();
		// 按统计类型统计用户信息
		pageBean = reportStatisticsService.userReport(PageBean.DEFAULTPAGESIZE, currentPage, statType);
		return SUCCESS;
	}

	/**
	 * @return the statType
	 */
	public String getStatType() {
		return statType;
	}

	/**
	 * @param statType the statType to set
	 */
	public void setStatType(String statType) {
		this.statType = statType;
	}

	/**
	 * @param reportStatisticsService the reportStatisticsService to set
	 */
	public void setReportStatisticsService(
			ReportStatisticsService reportStatisticsService) {
		this.reportStatisticsService = reportStatisticsService;
	}
	
}
