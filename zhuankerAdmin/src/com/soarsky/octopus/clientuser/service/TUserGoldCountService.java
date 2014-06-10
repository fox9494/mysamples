package com.soarsky.octopus.clientuser.service;

import java.util.List;

import com.soarsky.octopus.mapping.TUserGoldCount;


public interface TUserGoldCountService {
	/**
	 * 用户详情，金币统计信息
	 * @param userId
	 * @return
	 */
	public TUserGoldCount findUserGoldCountByUserId(long userId);
	/**
	 * 用户详情，当前用户奴隶数
	 * @param userId
	 * @return
	 */
	public long findChildrenByUserId(long userId);
	/**
	 * 当前用户排名
	 * @param userId
	 * @return
	 */
	public long findRankingByUserGold(long userId);
}
