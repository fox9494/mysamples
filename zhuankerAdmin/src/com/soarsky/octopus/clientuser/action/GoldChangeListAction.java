package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.service.TGoldChangeService;
import com.soarsky.octopus.clientuser.service.TUserGoldCountService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.utils.PageBean;

public class GoldChangeListAction extends PageAction {
	private static final long serialVersionUID = 3443782456470842653L;
	// 用户ID
	private long userId;
	private TGoldChangeService tGoldChangeService;
	private TUserGoldCountService tUserGoldCountService;
	private long totalGold;

	/**
	 * 当前用户金币变化列表
	 */
	public String searchList() {

		pageBean = tGoldChangeService.findAllGoldChangeList(
				PageBean.DEFAULTPAGESIZE, currentPage, userId);
		//当前用户总金币数
		totalGold = 	tUserGoldCountService.findUserGoldCountByUserId(userId).getTotal_gold();
		return SUCCESS;
	}

	public void settGoldChangeService(TGoldChangeService tGoldChangeService) {
		this.tGoldChangeService = tGoldChangeService;
	}

	public void settUserGoldCountService(
			TUserGoldCountService tUserGoldCountService) {
		this.tUserGoldCountService = tUserGoldCountService;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getTotalGold() {
		return totalGold;
	}

	public void setTotalGold(long totalGold) {
		this.totalGold = totalGold;
	}

}
