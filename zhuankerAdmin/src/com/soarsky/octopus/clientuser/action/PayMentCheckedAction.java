package com.soarsky.octopus.clientuser.action;



import java.util.List;

import com.soarsky.octopus.clientuser.service.TExchangeLogService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.common.contant.JEEContant;


public class PayMentCheckedAction extends PageAction{
	

	private static final long serialVersionUID = 1283245223751922052L;
	
	private TExchangeLogService tExchangeLogService;
	
	private String ids;

	/**
	 * 审核通过，前提是status必须是申请(0)
	 * @return
	 */
	public String saveCheckedPayMent(){	
		//只有状态为申请的才能审核通过
		List<Long> idList = tExchangeLogService.getAllId(ids, JEEContant.APPLY);
		if(idList.size()>0){
			tExchangeLogService.savePayMentChecked(idList);
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
