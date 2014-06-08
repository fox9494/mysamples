package com.openframe.sys.role.service;

import com.openframe.common.page.PageBean;
import com.openframe.common.service.BaseService;
import com.openframe.sys.role.domain.SysRole;

public interface SysRoleService extends BaseService<SysRole> {
	
	public PageBean queryRolePage(PageBean pageBean);

}
