package com.soarsky.octopus.manager.action;

import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.manager.service.TRoleInfoService;
import com.soarsky.octopus.utils.PageBean;

public class RoleListAction extends PageAction {
	
	
	private TRoleInfoService tRoleInfoService;
	
	
	/**
	 * 分页查询后台用户
	 * @return
	 */
	public String searchListPage(){
		pageBean = tRoleInfoService.queryListPage(PageBean.DEFAULTPAGESIZE, this.currentPage);
		return SUCCESS;
	}

	public TRoleInfoService gettRoleInfoService() {
		return tRoleInfoService;
	}

	public void settRoleInfoService(TRoleInfoService tRoleInfoService) {
		this.tRoleInfoService = tRoleInfoService;
	}
	
	

}
