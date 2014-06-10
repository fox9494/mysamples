package com.soarsky.octopus.reports.service;

import java.util.List;

import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.utils.PageBean;

public interface TDownloadInstallLogService {
	/**
	 * 分页显示
	 * 
	 * @param maxresult
	 * @param currentpage
	 * @return
	 */
	public PageBean findDownloadLog(int maxresult, int currentpage);
	/**
	 * 根据条件进行分页查询
	 * 
	 * @param maxresult
	 * @param currentpage
	 * @return
	 */
	public PageBean findDownloadLogByConditions(int maxresult, int currentpage,TUserClient user, TApplication  app);
	/**
	 * 用户详情，下载量分页显示（根据当前用户对应的应用）
	 * 
	 * @param maxresult
	 * @param current
	 * @param userId
	 *            当前用户id
	 * @return
	 */
	public PageBean findDownloadByUserId(int maxresult, int currentpage,long userId);
			
	/**
	 * 用户详情，安装量
	 * @param maxresult
	 * @param currentpage
	 * @param userId
	 * @return
	 */
	public PageBean findInstallReportByUserId(int maxresult, int currentpage,
			long userId);
    
	
	/**
	 * 根据应用对下载量以及安装量进行统计
	 * @param maxresult 每页最大条数
	 * @param currentpage 当前页数
	 * @param app 应用对象
	 * @return
	*/
	public PageBean findDownInstallByApplication(int maxresult, int currentpage,TApplication app,Integer type);
	/**
	 * 查找所有的客户
	 * @return
	 */
	public List<TUserClient> findAllClient();
	
	/**
	 * 分页查看下载详情
	 * @param maxresult 每页最大条数
	 * @param currentpage 当前页数
	 * @param app 应用对象
	 * @return
	*/
	public PageBean findDownInstallByApplicationJson(int dEFAULTPAGESIZE,Integer currentPage, TApplication app,Integer type);
}
