package com.soarsky.octopus.reports.service.impl;

import com.soarsky.octopus.reports.dao.TInstalledApkDAO;
import com.soarsky.octopus.reports.service.TInstalledApkService;
import com.soarsky.octopus.utils.PageBean;

public class TInstalledApkServiceImpl implements TInstalledApkService {

	private TInstalledApkDAO tInstalledApkDAO;

	public PageBean findInstalledByUserId(int maxresult, int currentpage,long userId) {
		return tInstalledApkDAO.findInstalledByUserId(maxresult, currentpage,userId);
				
	}

	public TInstalledApkDAO gettInstalledApkDAO() {
		return tInstalledApkDAO;
	}

	public void settInstalledApkDAO(TInstalledApkDAO tInstalledApkDAO) {
		this.tInstalledApkDAO = tInstalledApkDAO;
	}

}
