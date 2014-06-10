package com.soarsky.octopus.reports.action;

import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.reports.service.TDownloadInstallLogService;
import com.soarsky.octopus.utils.PageBean;

public class InstallReportListAction extends PageAction {

	private static final long serialVersionUID = 8993719103884817859L;
	
	private TDownloadInstallLogService tDownloadInstallLogService;
	
	private long userId;

	public String findInstallReport() {
		pageBean = tDownloadInstallLogService.findInstallReportByUserId(PageBean.DEFAULTPAGESIZE, currentPage, userId);				
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

}
