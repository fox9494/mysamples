package com.soarsky.octopus.manager.action;

import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.manager.service.TManagerInfoService;
import com.soarsky.octopus.utils.PageBean;

public class ManagerListAction extends PageAction {
	
	private static final long serialVersionUID = 8262518362760527248L;
	private TManagerInfoService tManagerInfoService;
	
	
	/**
	 * 分页查询后台用户
	 * @return
	 */
	public String searchListPage(){
		pageBean = tManagerInfoService.queryListPage(PageBean.DEFAULTPAGESIZE, this.currentPage);
		return SUCCESS;
	}

	public TManagerInfoService gettManagerInfoService() {
		return tManagerInfoService;
	}

	public void settManagerInfoService(TManagerInfoService tManagerInfoService) {
		this.tManagerInfoService = tManagerInfoService;
	}
	
	
	

}
