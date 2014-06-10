package com.soarsky.octopus.reports.service;

import com.soarsky.octopus.utils.PageBean;

public interface TInstalledApkService {
	/**
	 * 用户详情，非平台安装应用（根据用户id显示相应的应用）
	 * 
	 * @param maxresult
	 * @param currentpage
	 * @param userId
	 * @return
	 */
	public PageBean findInstalledByUserId(int maxresult, int currentpage,long userId);
			
}