package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.service.TUserLevelService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.utils.PageBean;

public class UserLevelListAction extends PageAction {

	private static final long serialVersionUID = -7846613105195585526L;
    
	private TUserLevelService  tUserLevelService;
	
    /**
     * 分页查询所有赚客级别信息
     * @author lw
     * @return
	*/
	public String searchList() {
		
		pageBean=tUserLevelService.getUserLevelList(PageBean.DEFAULTPAGESIZE, currentPage);
		
		return SUCCESS;
	}

	public TUserLevelService gettUserLevelService() {
		return tUserLevelService;
	}

	public void settUserLevelService(TUserLevelService tUserLevelService) {
		this.tUserLevelService = tUserLevelService;
	}
}
