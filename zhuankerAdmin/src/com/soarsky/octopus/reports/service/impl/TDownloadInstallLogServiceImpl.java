package com.soarsky.octopus.reports.service.impl;

import java.util.List;

import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.reports.dao.TDownloadInstallLogDAO;
import com.soarsky.octopus.reports.service.TDownloadInstallLogService;
import com.soarsky.octopus.utils.PageBean;

public class TDownloadInstallLogServiceImpl implements TDownloadInstallLogService {
		

	private TDownloadInstallLogDAO tDownloadInstallLogDAO;

	/**
	 * 分页显示
	 * 
	 * @author yl
	 */
	public PageBean findDownloadLog(int maxresult, int currentpage) {

		return tDownloadInstallLogDAO.findAllDownloadLog(maxresult, currentpage);
				
	}

	/**
	 * 根据条件进行分页显示
	 * 
	 * @author yl
	 */
	public PageBean findDownloadLogByConditions(int maxresult, int currentpage,TUserClient user, TApplication  app) {			
		return tDownloadInstallLogDAO.findAllDowloadLogConditions(maxresult,
				currentpage, user, app);
	}

	/**
	 * 用户详情，下载量统计，（根据当前用户显示应用）
	 * 
	 * @author yl
	 */
	public PageBean findDownloadByUserId(int maxresult, int currentpage,long userId) {			
		return tDownloadInstallLogDAO.findDownloadByUserId(maxresult,
				currentpage, userId);
	}

	/**
	 * 用户详情，安装量
	 * 
	 * @author yl
	 * 
	 */
	public PageBean findInstallReportByUserId(int maxresult, int currentpage,long userId) {			
		return tDownloadInstallLogDAO.findInstallReportByUserId(maxresult,
				currentpage, userId);
	}
		
    
	/**
	 * 根据应用对下载量以及安装量进行统计
	 * @author lw
	 * @param maxresult 每页最大条数
	 * @param currentpage 当前页数
	 * @param app 应用对象
	 * @return
	*/
	public PageBean findDownInstallByApplication(int maxresult, int currentpage,TApplication app,Integer type) {
		
		return tDownloadInstallLogDAO.findReportByApplication(maxresult,currentpage,app,type);
	}
	
	
	/**
	 * 分页查看下载详情
	 * @author lw
	 * @param maxresult 每页最大条数
	 * @param currentpage 当前页数
	 * @param app 应用对象
	 * @return
	*/
	public PageBean findDownInstallByApplicationJson(int maxresult,Integer currentPage, TApplication app, Integer type) {
		
		return tDownloadInstallLogDAO.findReportByApplicationJson(maxresult, currentPage, app, type);
	}

	/**
	 * 查找所有客户
	 * @author yl
	 */
	public List<TUserClient> findAllClient() {		
		return tDownloadInstallLogDAO.findAllClient();
	}
	public TDownloadInstallLogDAO gettDownloadInstallLogDAO() {
		return tDownloadInstallLogDAO;
	}

	public void settDownloadInstallLogDAO(
			TDownloadInstallLogDAO tDownloadInstallLogDAO) {
		this.tDownloadInstallLogDAO = tDownloadInstallLogDAO;
	}

	


}
