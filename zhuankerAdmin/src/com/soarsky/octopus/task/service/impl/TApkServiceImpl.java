package com.soarsky.octopus.task.service.impl;

import com.soarsky.octopus.mapping.TApk;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.task.dao.TApkDAO;
import com.soarsky.octopus.task.service.TApkService;
import com.soarsky.octopus.utils.PageBean;

public class TApkServiceImpl implements TApkService {
	
	private TApkDAO tApkDAO;
	
	/**
	 * 根据应用删除APK
	 * @author lw
	 * @param  application  应用对象
	*/
	public void deleteApk(TApplication application) {
		
		tApkDAO.deleteApk(application);
	}
    
	/**
	 * 修改APK
	 * @author lw
	 * @param  apk  要修改的APK
	*/
	public void editApk(TApk apk) {
		
		tApkDAO.merger(apk);
	}
   
	/**
	 * 添加特定分辨率的APK
	 * @author lw
	 * @param  apk  要添加的APK对象
	*/
	public void addApk(TApk apk) {
		
		tApkDAO.save(apk);
	}
    
	
	/**
	 * 查询所有特定分辨率的APK
	 * @author lw
	 * @param  maxsize  每页最大条数
	 * @param  currentPage  当前页数
	 * @return
	*/
	public PageBean getAllApk(int maxsize, int currentPage,TApplication app) {
		
		return tApkDAO.findAllSpecialApk(maxsize,currentPage,app);
	}
    
	/**
	 * 根据应用查询该应用下的常用APK
	 * @author lw
	 * @param  application  应用对象
	 * @return
	*/
	public TApk getCommonApk(TApplication application) {
		
		return tApkDAO.findCommonApk(application);
	}
    
	/**
	 * 初始化要修改的APK
	 * @author lw
	 * @param apkContent 要修改的APK
	 * @return
	*/
	public TApk initApk(TApk apkContent) {
	
		return tApkDAO.getById(TApk.class, apkContent.getId());
	}

	public TApkDAO gettApkDAO() {
		return tApkDAO;
	}

	public void settApkDAO(TApkDAO tApkDAO) {
		this.tApkDAO = tApkDAO;
	}
	
	
}
