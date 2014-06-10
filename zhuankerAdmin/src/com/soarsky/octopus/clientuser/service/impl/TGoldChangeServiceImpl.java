package com.soarsky.octopus.clientuser.service.impl;

import com.soarsky.octopus.clientuser.dao.TGoldChangeDAO;
import com.soarsky.octopus.clientuser.service.TGoldChangeService;
import com.soarsky.octopus.utils.PageBean;

public class TGoldChangeServiceImpl implements TGoldChangeService {

	private TGoldChangeDAO tGoldChangeDAO;

	public TGoldChangeDAO gettGoldChangeDAO() {
		return tGoldChangeDAO;
	}

	public void settGoldChangeDAO(TGoldChangeDAO tGoldChangeDAO) {
		this.tGoldChangeDAO = tGoldChangeDAO;
	}

	/**
	 * 金币变化列表
	 * 
	 * @author yl
	 */
	public PageBean findAllGoldChangeList(int maxresult, int currentPage,
			long userId) {

		return tGoldChangeDAO.findAllGoldChange(maxresult, currentPage, userId);
	}

}
