package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.service.TUserLevelService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TUserLevel;

public class UserLevelDeleteAction extends BaseAction {

	private static final long serialVersionUID = -8721347592946899714L;
    
	private TUserLevelService  tUserLevelService;
    
	private TUserLevel  userLevel;
	
	/**
	 *删除赚客级别信息
	 *@author lw
	 *@return
	 */
	public String delete() {
		
		tUserLevelService.deleteUserLevel(userLevel);
		
		return SUCCESS;
	}

	public TUserLevelService gettUserLevelService() {
		return tUserLevelService;
	}

	public void settUserLevelService(TUserLevelService tUserLevelService) {
		this.tUserLevelService = tUserLevelService;
	}

	public TUserLevel getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(TUserLevel userLevel) {
		this.userLevel = userLevel;
	}
} 
