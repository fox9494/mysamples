package com.soarsky.octopus.reports.service;

import java.util.List;

import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.reports.vo.Application;
import com.soarsky.octopus.reports.vo.UserReportVo;
import com.soarsky.octopus.utils.PageBean;

/**
 * 处理报表统计相关业务逻辑接口
 * @author ouyang
 *
 */
public interface ReportStatisticsService {

	/**
	 * 根据客户id与应用id分页查询该应用的累计安装量（companyId、appId为空，或则为下拉列表默认值时，查询所有）
	 * @param currentPage 当前页数
	 * @param pageSize 每页显示条数
	 * @param companyId 客户id号
	 * @param appId 应用id号
	 * @return pageBean:list里装的StatisticsReport
	 */
	public PageBean appInstallsStatistics(int pageSize, Integer currentPage, Long companyId, Long appId);

	/**
	 * 根据客户id与应用id分页查询该应用的累计下载量（companyId、appId为空，或则为下拉列表默认值时，查询所有）
	 * @param currentPage 当前页数
	 * @param pageSize 每页显示条数
	 * @param companyId 客户id号
	 * @param appId 应用id号
	 * @return pageBean:list里装的Object[]
	 */
	public PageBean appDownloadStatistics(int pageSize,
			Integer currentPage, Long companyId, Long appId);
	
	/**
	 * 根据客户id与应用id分页查询该应用使用量（companyId、appId为空，或则为下拉列表默认值时，查询所有）
	 * @param currentPage 当前页数
	 * @param pageSize 每页显示条数
	 * @param companyId 客户id号
	 * @param appId 应用id号
	 * @return pageBean:list里装的Object[]
	 */
	public PageBean appFlowStatistics(int pageSize, Integer currentPage,
			Long companyId, Long appId);
	
	/**
	 * 查询所有客户信息
	 * @return List<TCompany>：所有客户信息
	 */
	public List<TCompany> queryCompanys();

	/**
	 * 根据客户id号companyID查询该客户发布的所有应用（如果companyID为空或则下拉列表默认值则查询所有）
	 * @param companyID 客户id号
	 * @return List<TApplication>：该客户发布的所有应用集合
	 */
	public List<Application> queryApps(Long companyID);

	/**
	 * 根据应用名字统计该应用有多少用户安装了(无名字统计所有应用)
	 * @param appName 应用名字
	 * @return PageBean：list中装的Object[]
	 */
	public PageBean userAppStatistics(int pageSize, Integer currentPage, String appName);

	/**
	 * 根据统计类型统计用户信息
	 * @param pageSize
	 * @param currentPage
	 * @param statType
	 * @return
	 */
    public PageBean userReport(int pageSize, Integer page,String statType);
    
    /**
     * 统计总注册用户与总活跃用户
     * @return
     */
    public UserReportVo countAllUser();
    
}
