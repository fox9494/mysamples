package com.cpy.enfm.sysmanager.user.service;

import java.util.List;

import com.cpy.enfm.common.service.BaseService;
import com.cpy.enfm.sysmanager.user.entity.AdminUsers;

public interface AdminUserService extends BaseService<AdminUsers> {
	
	
	/**
	 * 根据账户查找
	 * @param user
	 * @return
	 */
	public List<AdminUsers> findByAccount(String accountName);

}
