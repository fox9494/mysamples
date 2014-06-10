package com.soarsky.octopus.reports.action;

import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.reports.service.TInstalledApkService;
import com.soarsky.octopus.utils.PageBean;

public class InstalledApkListAction extends PageAction {

	private static final long serialVersionUID = -4194021592479939667L;
	
	private TInstalledApkService tInstalledApkService;
	// 用户id
	private long userId;

	public String findInstalledReportByUserId() {
		pageBean = tInstalledApkService.findInstalledByUserId(PageBean.DEFAULTPAGESIZE, currentPage, userId);				
		return SUCCESS;
	}

	public void settInstalledApkService(
			TInstalledApkService tInstalledApkService) {
		this.tInstalledApkService = tInstalledApkService;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
