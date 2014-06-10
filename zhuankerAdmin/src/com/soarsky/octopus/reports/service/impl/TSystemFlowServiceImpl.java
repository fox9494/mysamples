package com.soarsky.octopus.reports.service.impl;

import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.reports.dao.TSystemFlowDAO;
import com.soarsky.octopus.reports.service.TSystemFlowService;
import com.soarsky.octopus.utils.PageBean;

public class TSystemFlowServiceImpl implements TSystemFlowService {

	private TSystemFlowDAO tSystemFlowDAO;

	/**
	 * 分页显示使用量统计
	 * 
	 * @author yl
	 * @param maxresult
	 *            最大记录数
	 * @param currentPage
	 *            当前页数
	 */
	public PageBean getSystemFlowList(int maxresult, int currentPage) {

		return tSystemFlowDAO.findAllSystemFlow(maxresult, currentPage);
	}

	/**
	 * 条件查询
	 * 
	 * @author yl
	 * @param maxresult
	 *            最大记录数
	 * @param currentPage
	 *            当前页数
	 * @param user
	 *            用户
	 * @param appName
	 *            应用名字
	 */
	public PageBean findSysFlowByConditions(int maxresult, int currentPage,String userName, String appName) {
			

		return tSystemFlowDAO.findAllSystemFlowByConditions(maxresult,currentPage, userName, appName);

				
	}

	/**
	 * 用户详情，根据userid查询流量
	 * 
	 * @author yl
	 * @param maxresult
	 *            最大记录数
	 * @param currentPage
	 *            当前页数
	 * @param userId
	 *            用户id
	 * 
	 * 
	 */
	public PageBean findSysFlowByUserId(int maxresult, int currentPage,long userId) {
			

		return tSystemFlowDAO.findAllSystemFlowById(maxresult, currentPage,userId);
				
	}
    
	/**
	 * 根据应用查询流量信息
	 * @author lw
	 * @param maxresult  每页最大条数
	 * @param currentPage 当前页数
	 * @param app 应用对象
	*/
	public PageBean findSysFlowByApplication(int maxresult, int currentPage,TApplication app) {
		
		return tSystemFlowDAO.findSysFlowByApp(maxresult,currentPage,app);
	}
    
	/**
	 * 执行分页操作
	 * @param maxresult  每页最大条数
	 * @param currentPage 当前页数
	 * @param app 应用对象
	*/
	public PageBean findSysFlowByApplicationJson(int maxresult,Integer currentPage, TApplication app) {
		
		return tSystemFlowDAO.findSysFlowByAppJson(maxresult,currentPage,app);
	}

	public TSystemFlowDAO gettSystemFlowDAO() {
		return tSystemFlowDAO;
	}

	public void settSystemFlowDAO(TSystemFlowDAO tSystemFlowDAO) {
		this.tSystemFlowDAO = tSystemFlowDAO;
	}

}
