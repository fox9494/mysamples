package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.service.TUserTaskService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.utils.PageBean;

public class UserTaskListAction extends PageAction {

	private static final long serialVersionUID = -1287897534858182019L;
	
	private TUserTaskService tUserTaskService;
	/**
	 * 用户id
	 */
	private long userId;

	public String searchList() {
		pageBean = tUserTaskService.findAllUserTask(PageBean.DEFAULTPAGESIZE, currentPage, userId);
		return SUCCESS;
	}

	public void settUserTaskService(TUserTaskService tUserTaskService) {
		this.tUserTaskService = tUserTaskService;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
