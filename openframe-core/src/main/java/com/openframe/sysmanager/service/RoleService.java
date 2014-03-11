package com.openframe.sysmanager.service;

import com.openframe.common.page.PageBean;
import com.openframe.sysmanager.domain.Role;

public interface RoleService {
	
	
	public void save(Role role);
	
	/**
	 * 分页查找
	 * @param pageObj
	 * @return
	 */
	public PageBean queryPageUser(PageBean pageObj);
	
	
	public int count(int param);

}
