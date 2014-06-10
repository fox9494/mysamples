package com.soarsky.octopus.clientuser.service.impl;

import com.soarsky.octopus.clientuser.dao.TUserGoldCountDAO;
import com.soarsky.octopus.clientuser.service.TUserGoldCountService;
import com.soarsky.octopus.mapping.TUserGoldCount;

public class TUserGoldCountServiceImpl implements TUserGoldCountService {

	private TUserGoldCountDAO tUserGoldCountDAO;

	/**
	 * 用户金币信息统计
	 */
	public TUserGoldCount findUserGoldCountByUserId(long userId) {

		return tUserGoldCountDAO.findUserGoldCountByUserId(userId);
	}

	/**
	 * 当前用户奴隶数
	 */
	public long findChildrenByUserId(long userId) {

		return tUserGoldCountDAO.findChildrenByUserId(userId);
	}

	/**
	 * 当前用户的排名
	 */
	public long findRankingByUserGold(long userId) {

		return tUserGoldCountDAO.findRankingByUserGold(userId);
	}

	public TUserGoldCountDAO gettUserGoldCountDAO() {
		return tUserGoldCountDAO;
	}

	public void settUserGoldCountDAO(TUserGoldCountDAO tUserGoldCountDAO) {
		this.tUserGoldCountDAO = tUserGoldCountDAO;
	}

}
