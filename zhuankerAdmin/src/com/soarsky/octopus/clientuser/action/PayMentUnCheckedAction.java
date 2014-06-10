package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.service.TExchangeLogService;
import com.soarsky.octopus.common.action.PageAction;

public class PayMentUnCheckedAction extends PageAction{

	private static final long serialVersionUID = 8015873744435838822L;
	
	private String ids;
	
	private TExchangeLogService tExchangeLogService;
	/**
	 * 取消兑换
	 * @return
	 */
	public String saveUnCheckedPayMent(){
		tExchangeLogService.savePayMentUnChecked(tExchangeLogService.getIdList(ids));
		return SUCCESS;
	}
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public void settExchangeLogService(TExchangeLogService tExchangeLogService) {
		this.tExchangeLogService = tExchangeLogService;
	}
}
