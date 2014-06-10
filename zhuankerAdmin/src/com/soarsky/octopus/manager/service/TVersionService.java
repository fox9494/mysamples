package com.soarsky.octopus.manager.service;

import com.soarsky.octopus.mapping.TVersion;
import com.soarsky.octopus.utils.PageBean;

public interface TVersionService {
	
	
	//增加版本
	public void versionAdd(TVersion tversion);
	
	//获得版本列表
	public PageBean getAllVersions(int maxresult, int currentPage,TVersion tversion);
	
	/**
	 * 判断版本是否存在
	 */
	public boolean judgeName(String versionName);

}
