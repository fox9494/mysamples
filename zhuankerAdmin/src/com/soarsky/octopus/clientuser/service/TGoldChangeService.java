package com.soarsky.octopus.clientuser.service;

import com.soarsky.octopus.utils.PageBean;

public interface TGoldChangeService {
	/**
	 * 显示当前用户的金币变化列表
	 * @param maxresult 最大记录数
	 * @param currentPage 当前页数
	 * @param userId 当前用户的id
	 * @return
	 */
	public PageBean findAllGoldChangeList(int maxresult, int currentPage,long userId);
			
}
