package com.soarsky.octopus.manager.service.impl;

import com.soarsky.octopus.common.service.PackageApkService;
import com.soarsky.octopus.manager.dao.TVersionDAO;
import com.soarsky.octopus.manager.service.TVersionService;
import com.soarsky.octopus.mapping.TVersion;
import com.soarsky.octopus.utils.PageBean;

public class TVersionServiceImpl implements TVersionService {
	
	private TVersionDAO tVersionDAO;
	
	private PackageApkService packageApkService;
	
	
	
    //增加版本
	public void versionAdd(TVersion tversion) {
		 this.tVersionDAO.save(tversion);
		 
		 if (tversion!=null){
			   //重新打包以前渠道的apk
			   packageApkService.batchPackageApk(tversion.getApkUrl());
		 }
		 
		 
		
	}
	
	//获得版本列表信息
	public PageBean getAllVersions(int maxresult, int currentPage,TVersion tversion) {
		
		return this.tVersionDAO.findAllVersion(maxresult, currentPage,tversion);
	}

		
		

	public TVersionDAO gettVersionDAO() {
		return tVersionDAO;
	}

	public void settVersionDAO(TVersionDAO tVersionDAO) {
		this.tVersionDAO = tVersionDAO;
	}

	/**
	 * 判断版本是否重复
	 */
	public boolean judgeName(String versionName) {
	  
		return this.tVersionDAO.judgeVersionName(versionName);
	}

	public PackageApkService getPackageApkService() {
		return packageApkService;
	}

	public void setPackageApkService(PackageApkService packageApkService) {
		this.packageApkService = packageApkService;
	}


	

	

}
