package com.soarsky.octopus.clientuser.action;

import java.util.List;

import com.soarsky.octopus.clientuser.service.TExchangeLogService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.common.contant.JEEContant;

public class PayMentSuccessedAction extends PageAction{

	private static final long serialVersionUID = 5498414352247878915L;
	
	private String ids;
	
	private TExchangeLogService tExchangeLogService;
	/**
	 * 支付完成,只有审核通过的才能支付完成
	 * @return
	 */
	public String savePayedPayMent(){
		//只有状态为审核通过的才能支付完成
		List<Long> idList = tExchangeLogService.getAllId(ids, JEEContant.CHECKED);
		if(idList.size()>0){
			tExchangeLogService.savePayMentPayed(idList);
		}
		
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
