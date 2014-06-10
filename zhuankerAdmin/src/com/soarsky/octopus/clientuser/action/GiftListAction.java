package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.service.TGiftService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.utils.PageBean;

public class GiftListAction extends PageAction {

	private static final long serialVersionUID = 6300817256806669079L;
	
	private TGiftService  tGiftService;
	
	/**
	 * 分页查询所有礼物信息
	 * @author lw
	 * @return
	*/
    public String searchList() {
		
    	pageBean=tGiftService.getGiftList(PageBean.DEFAULTPAGESIZE, currentPage);
		
		return SUCCESS;
	}
    
	public TGiftService gettGiftService() {
		return tGiftService;
	}

	public void settGiftService(TGiftService tGiftService) {
		this.tGiftService = tGiftService;
	}
	
}
