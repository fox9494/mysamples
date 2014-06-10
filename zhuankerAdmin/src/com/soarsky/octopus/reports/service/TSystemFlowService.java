package com.soarsky.octopus.reports.service;

import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.utils.PageBean;

public interface TSystemFlowService {

	/**
	 * 分页显示
	 * @param maxresult
	 * @param currentPage
	 * @return
	 */
	public PageBean getSystemFlowList(int maxresult,int currentPage);
	/**
	 * 根据条件分页查询
	 * @param maxresult 最大记录数
	 * @param currentPage 当前页数
	 * @param user 用户对象
	 * @param appName 应用名称
	 * @return
	 */
	public PageBean findSysFlowByConditions(int maxresult,int currentPage,String userName,String appName);
	/**
	 * 用户详情，流量统计
	 * @param maxresult
	 * @param currentPage
	 * @param userId
	 * @return
	 */
	public PageBean findSysFlowByUserId(int maxresult,int currentPage,long userId);
	
	/**
	 * 根据应用查询流量信息
	 * @param maxresult  每页最大条数
	 * @param currentPage 当前页数
	 * @param app 应用对象
	*/
	public PageBean findSysFlowByApplication(int maxresult,int currentPage, TApplication app);
	
	/**
	 * 执行分页操作
	 * @param maxresult  每页最大条数
	 * @param currentPage 当前页数
	 * @param app 应用对象
	*/
	public PageBean findSysFlowByApplicationJson(int maxresult,Integer currentPage, TApplication app);
	
}
