package com.soarsky.octopus.reports.action;

import java.util.List;

import com.soarsky.octopus.clientuser.service.TUserClientService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.reports.service.TDownloadInstallLogService;
import com.soarsky.octopus.utils.PageBean;

public class DownloadLogListAction extends PageAction {

	private static final long serialVersionUID = 4665088100990731037L;
	
	private TDownloadInstallLogService tDownloadInstallLogService;
	
	private TUserClient user;
	
	private TApplication app;

	private long userId;
	
	private List<TUserClient> userList;

	/**
	 * 分页显示
	 */
	public String searchList() {
		userList = tDownloadInstallLogService.findAllClient();
		pageBean = tDownloadInstallLogService.findDownloadLog(pageBean.DEFAULTPAGESIZE, currentPage);				
		return SUCCESS;

	}

	/**
	 * 条件查询
	 * 
	 * @return
	 */
	public String searchListByParams() {
		userList = tDownloadInstallLogService.findAllClient();
		pageBean = tDownloadInstallLogService.findDownloadLogByConditions(pageBean.DEFAULTPAGESIZE, currentPage, user, app);				
		return SUCCESS;
	}

	/**
	 * 用户详情，下载统计，（根据当前用户的应用）
	 * 
	 * @return
	 */
	public String findDownloadReportById() {
		pageBean = tDownloadInstallLogService.findDownloadByUserId(PageBean.DEFAULTPAGESIZE, currentPage, userId);
				
		return SUCCESS;
	}

	public void settDownloadInstallLogService(
			TDownloadInstallLogService tDownloadInstallLogService) {
		this.tDownloadInstallLogService = tDownloadInstallLogService;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public TUserClient getUser() {
		return user;
	}

	public void setUser(TUserClient user) {
		this.user = user;
	}

	public TApplication getApp() {
		return app;
	}

	public void setApp(TApplication app) {
		this.app = app;
	}
	public List<TUserClient> getUserList() {
		return userList;
	}

	public void setUserList(List<TUserClient> userList) {
		this.userList = userList;
	}

}
