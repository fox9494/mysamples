package com.soarsky.octopus.task.service;

import com.soarsky.octopus.mapping.TApk;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.utils.PageBean;

public interface TApkService {
    
	/**
	 *删除APK
	 *@param application  应用对象
	*/
	public void deleteApk(TApplication application);
	
	/**
	 * 编辑APK
	 * @param 要编辑的apk对象
	*/
	public void editApk(TApk apk);
	
	/**
	 * 添加特定分辨率APK
	 * @param apk 要添加的APK对象
	*/
	public void addApk(TApk apk);
    
	/**
	 * 根据应用获得该应用下的所有特定分辨率的APK
	 * @param maxsize 每页最大条数
	 * @param currentPage 当前页数
	 * @param app 应用对象
	 * @return
	*/
	public PageBean getAllApk(int maxsize, int currentPage,TApplication app);
	
	/**
	 * 根据应用查询该应用下的普通APK
	 * @param application 应用对象
	 * @return
	*/
	public TApk getCommonApk(TApplication application);
    
	/**
	 * 初始化要修改的APK
	 * @param apkContent 要修改的APK
	 * @return
	*/
	public TApk initApk(TApk apkContent);
}
