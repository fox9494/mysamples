package com.soarsky.octopus.reports.action;

import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.reports.service.TSystemFlowService;
import com.soarsky.octopus.task.service.TApplicationService;

public class SystemFlowListAction extends PageAction {

	private static final long serialVersionUID = -4962059136228315265L;
	private TSystemFlowService tSystemFlowService;
	
	private TApplicationService tApplicationService;
	// 用户名字
	private String userName;
	// 应用名字
	private String appName;
	// 用户id
	private long userId;

	

	/**
	 * 分页显示所有的使用量统计
	 * 
	 * @author yl
	 */
	public String searchList() {
		pageBean = tSystemFlowService.getSystemFlowList(pageBean.DEFAULTPAGESIZE, currentPage);				
		return SUCCESS;
	}

	/**
	 * 条件查询显示分页
	 * 
	 * @return
	 */
	public String findAllSysFlowByConditions() {
		String name = appName.substring(0, appName.indexOf(","));
		pageBean = tSystemFlowService.findSysFlowByConditions(pageBean.DEFAULTPAGESIZE, currentPage, userName, name);				
		return SUCCESS;
	}

	/**
	 * 用户详情使用量统计
	 * 
	 * @return
	 */
	public String findAllSystemFlowByUserId() {		
		
		pageBean = tSystemFlowService.findSysFlowByUserId(pageBean.DEFAULTPAGESIZE, currentPage, userId);
				
		return SUCCESS;
	}

	public String findSysFlowByConditions() {
		return SUCCESS;
	}

	public void settSystemFlowService(TSystemFlowService tSystemFlowService) {
		this.tSystemFlowService = tSystemFlowService;
	}

	public void settApplicationService(TApplicationService tApplicationService) {
		this.tApplicationService = tApplicationService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
