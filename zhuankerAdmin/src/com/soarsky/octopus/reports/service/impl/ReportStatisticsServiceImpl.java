package com.soarsky.octopus.reports.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.reports.dao.TDownloadInstallLogDAO;
import com.soarsky.octopus.reports.dao.TInstalledApkDAO;
import com.soarsky.octopus.reports.dao.TSystemFlowDAO;
import com.soarsky.octopus.reports.dao.UserReportDAO;
import com.soarsky.octopus.reports.service.ReportStatisticsService;
import com.soarsky.octopus.reports.vo.Application;
import com.soarsky.octopus.reports.vo.StatisticsReport;
import com.soarsky.octopus.reports.vo.UserReportVo;
import com.soarsky.octopus.task.dao.TApplicationDAO;
import com.soarsky.octopus.task.dao.TCompanyDAO;
import com.soarsky.octopus.utils.PageBean;

/**
 * 处理报表统计相关业务逻辑接口实现
 * @author ouyang
 *
 */
public class ReportStatisticsServiceImpl implements ReportStatisticsService {
	
	private TCompanyDAO tCompanyDAO; //task任务模块已经实现好的对应用提供方信息进行增删改查等常用数据库操作的持久层对象
	private TApplicationDAO tApplicationDAO;//task任务模块已经实现好的对应应用数据表常用数据持久化操作的dao
	private TDownloadInstallLogDAO tDownloadInstallLogDAO;//对下载安装日志表进行数据持久操作的dao
	private TSystemFlowDAO tSystemFlowDAO;//对T_System_Flow表进行数据持久化操作的dao
	private TInstalledApkDAO tInstalledApkDAO;//对T_Installed_Apk表进行数据持久化操作的dao
 	
	/**
	 * 赚客用户统计DAO
	 */
	private UserReportDAO userReportDao;
	
	/**
	 * 根据客户id与应用id分页查询该应用的累计安装量（companyId、appId为空，或则为下拉列表默认值时，查询所有）
	 * @param currentPage 当前页数
	 * @param pageSize 每页显示条数
	 * @param companyId 客户id号
	 * @param appId 应用id号
	 * @return
	 */
	@Override
	public PageBean appInstallsStatistics(int pageSize, Integer currentPage,
			Long companyId, Long appId) {

		//测试用数据
		PageBean pageBean = new PageBean();
//		pageBean.setCurrentPage(currentPage);
//		pageBean.setPageSize(pageSize);
//		pageBean.setAllRow(100);
//		List<StatisticsReport> list = new ArrayList<StatisticsReport>();
//		list.add(new StatisticsReport(1L, "腾讯", 1L, "qq", 100L, 0L, 0L, 0L));
//		list.add(new StatisticsReport(2L, "腾讯", 2L, "qq空间", 100L, 0L, 0L, 0L));
//		pageBean.setList(list);
		
		if(companyId!= null && companyId == JEEContant.SELECT_DEFAULT_VALUE) {
			companyId = null;
		}
		if(appId != null && appId == JEEContant.SELECT_DEFAULT_VALUE) {
			appId = null;
		}
		//该pageBean。getList()返回的list中存放的是Object[]
		pageBean = tDownloadInstallLogDAO.appInstallsStatistics(pageSize, currentPage, companyId, appId, JEEContant.REPORT_TYPE_INSTALL);
		
		List<StatisticsReport> statisticsReports = new ArrayList<StatisticsReport>();
		List<?> list = pageBean.getList();
		for(int index=0; index<list.size(); index++) {
			 Object[] objs = (Object[]) list.get(index);
			 StatisticsReport statisticsReport = new StatisticsReport();
			 statisticsReport.setCompanyId(((BigDecimal) objs[0]).longValue());
			 statisticsReport.setCompanyName((String) objs[1]);
			 statisticsReport.setAppId(((BigDecimal) objs[2]).longValue());
			 statisticsReport.setAppName((String) objs[3]);
			 statisticsReport.setAppInstalls(((BigDecimal) objs[4]).longValue());
			 
			 statisticsReports.add(statisticsReport);
		}
		pageBean.setList(statisticsReports);
		
		return pageBean;
	}
	
	/**
	 * 根据客户id与应用id分页查询该应用的累计下载量（companyId、appId为空，或则为下拉列表默认值时，查询所有）
	 * @param currentPage 当前页数
	 * @param pageSize 每页显示条数
	 * @param companyId 客户id号
	 * @param appId 应用id号
	 * @return pageBean:list里装的Object[]
	 */
	@Override
	public PageBean appDownloadStatistics(int pageSize, Integer currentPage, 
			Long companyId, Long appId) {

		if(companyId!= null && companyId == JEEContant.SELECT_DEFAULT_VALUE) {
			companyId = null;
		}
		if(appId != null && appId == JEEContant.SELECT_DEFAULT_VALUE) {
			appId = null;
		}
		return tDownloadInstallLogDAO.appInstallsStatistics(pageSize, currentPage, companyId, appId, JEEContant.REPORT_TYPE_DOWNLOAD);
	}
	
	/**
	 * 根据客户id与应用id分页查询该应用使用量（companyId、appId为空，或则为下拉列表默认值时，查询所有）
	 * @param currentPage 当前页数
	 * @param pageSize 每页显示条数
	 * @param companyId 客户id号
	 * @param appId 应用id号
	 * @return pageBean:list里装的Object[]
	 */
	@Override
	public PageBean appFlowStatistics(int pageSize, Integer currentPage,
			Long companyId, Long appId) {
		
		if(companyId!= null && companyId == JEEContant.SELECT_DEFAULT_VALUE) {
			companyId = null;
		}
		if(appId != null && appId == JEEContant.SELECT_DEFAULT_VALUE) {
			appId = null;
		}
		return tSystemFlowDAO.appFlowStatistics(pageSize, currentPage, companyId, appId);
		
	}
	
	/**
	 * 根据应用名字统计该应用有多少用户安装了(无名字统计所有应用)
	 * @param appName 应用名字
	 * @return PageBean：list中装的Object[]
	 */
	@Override
	public PageBean userAppStatistics(int pageSize, Integer currentPage, String appName) {
		//根据应用名字进行统计查询，查询该应用有多少用户安装
		if(appName == null) {
			appName = "";
		}
		return tInstalledApkDAO.statisticsQueryByAppName(pageSize, currentPage, appName);
	}

	/**
	 * 查询所有客户信息
	 * @return List<TCompany>：所有客户信息
	 */
	@Override
	public List<TCompany> queryCompanys() {
		return tCompanyDAO.queryAllCompany();//查询到的所有客户的详细信息
	}
	
	/**
	 * 根据客户id号companyID查询该客户发布的所有应用（如果companyID为空或则下拉列表默认值则查询所有）
	 * @param companyID 客户id号
	 * @return List<TApplication>：该客户发布的所有应用集合
	 */
	@Override
	public List<Application> queryApps(Long companyID) {
		//根据客户id号companyID查询该客户发布的所有应用（如果companyID为空或则下拉列表默认值则查询所有）
		if(companyID != null && companyID == JEEContant.SELECT_DEFAULT_VALUE) {
			companyID = null;
		}
		
		//将List<TApplication>应用详细信息列表转化成简要信息列表
		List<Application> apps = new ArrayList<Application>();
		List<TApplication> tApps =  tApplicationDAO.queryAppsByCompany(companyID);
		for(TApplication tApp : tApps) {
			Application app = new Application(tApp.getAppid(), tApp.getAppName());
			apps.add(app);
		}
		return apps;
	}
	

	public TCompanyDAO gettCompanyDAO() {
		return tCompanyDAO;
	}

	public void settCompanyDAO(TCompanyDAO tCompanyDAO) {
		this.tCompanyDAO = tCompanyDAO;
	}

	public TApplicationDAO gettApplicationDAO() {
		return tApplicationDAO;
	}

	public void settApplicationDAO(TApplicationDAO tApplicationDAO) {
		this.tApplicationDAO = tApplicationDAO;
	}

	public TDownloadInstallLogDAO gettDownloadInstallLogDAO() {
		return tDownloadInstallLogDAO;
	}

	public void settDownloadInstallLogDAO(
			TDownloadInstallLogDAO tDownloadInstallLogDAO) {
		this.tDownloadInstallLogDAO = tDownloadInstallLogDAO;
	}

	public TSystemFlowDAO gettSystemFlowDAO() {
		return tSystemFlowDAO;
	}

	public void settSystemFlowDAO(TSystemFlowDAO tSystemFlowDAO) {
		this.tSystemFlowDAO = tSystemFlowDAO;
	}

	public TInstalledApkDAO gettInstalledApkDAO() {
		return tInstalledApkDAO;
	}

	public void settInstalledApkDAO(TInstalledApkDAO tInstalledApkDAO) {
		this.tInstalledApkDAO = tInstalledApkDAO;
	}

	@Override
	public PageBean userReport(int pageSize, Integer page,
			String statType) {
		PageBean pageBean = null;
		if(statType == null ){
			statType = "1";
		}
	    if(statType.equals("1"))// 渠道用户统计
	    {
	    	pageBean = userReportDao.channelUserStatistics(pageSize, page);
	    }
	    else if(statType.equals("2"))// 区域用户统计
	    {
	    	pageBean = userReportDao.areaUserStatistics(pageSize, page);
	    }
	    else if(statType.equals("3")) // 赚客级别统计
	    {
	    	pageBean = userReportDao.levelUserStatistics(pageSize, page);
	    }
	    
	    List<UserReportVo> userReportVos = new ArrayList<UserReportVo>();
	    List<?> list = pageBean.getList();
	    for(int index = 0;index<list.size();index++) {
	    	Object[] objs = (Object[]) list.get(index);
	    	UserReportVo userReportVo = new UserReportVo();
	    	userReportVo.setStatName((String) objs[0]);
	    	userReportVo.setActiveUser_Count(((BigDecimal) objs[1]).intValue());
	    	userReportVo.setRegisterUser_Count(((BigDecimal) objs[2]).intValue());
	    	
	    	userReportVos.add(userReportVo);
	    }
	    pageBean.setList(userReportVos);
	    
		return pageBean;
	}

	@Override
	public UserReportVo countAllUser() {
		UserReportVo vo = userReportDao.allUserStatistics();
		return vo;
	}

	/**
	 * @return the userReportDao
	 */
	public UserReportDAO getUserReportDao() {
		return userReportDao;
	}

	/**
	 * @param userReportDao the userReportDao to set
	 */
	public void setUserReportDao(UserReportDAO userReportDao) {
		this.userReportDao = userReportDao;
	}

}
