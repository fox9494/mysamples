package com.soarsky.octopus.clientuser.service;

import com.soarsky.octopus.utils.PageBean;

public interface TUserTaskService {
	/**
	 * 用户任务详细列表
	 * @param maxResult
	 * @param currentPage
	 * @param userId
	 * @return
	 */
	public PageBean findAllUserTask(int maxResult, int currentPage, long userId);
}
