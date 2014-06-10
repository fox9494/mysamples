package com.soarsky.octopus.clientuser.service.impl;

import com.soarsky.octopus.clientuser.dao.TUserTaskDAO;
import com.soarsky.octopus.clientuser.service.TUserTaskService;
import com.soarsky.octopus.utils.PageBean;

public class TUserTaskServiceImpl implements TUserTaskService {

	private TUserTaskDAO tUserTaskDAO;

	/**
	 * @author yl
	 */
	public PageBean findAllUserTask(int maxResult, int currentPage, long userId) {
		return tUserTaskDAO.findAllUserTask(maxResult, currentPage, userId);
	}

	public TUserTaskDAO gettUserTaskDAO() {
		return tUserTaskDAO;
	}

	public void settUserTaskDAO(TUserTaskDAO tUserTaskDAO) {
		this.tUserTaskDAO = tUserTaskDAO;
	}

}
