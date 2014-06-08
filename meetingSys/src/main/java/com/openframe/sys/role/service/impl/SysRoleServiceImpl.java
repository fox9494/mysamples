package com.openframe.sys.role.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.openframe.common.page.PageBean;
import com.openframe.common.service.impl.BaseServiceImpl;
import com.openframe.sys.role.dao.SysRoleDAO;
import com.openframe.sys.role.domain.SysRole;
import com.openframe.sys.role.service.SysRoleService;

@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements
		SysRoleService {
	
	@Autowired
	public void setSysRoleDAO(@Qualifier("sysRoleDAO")SysRoleDAO sysRoleDAO){
		setBaseMybatisDAO(sysRoleDAO);
	}
	
	//强制返回sysRoleDAO
	public SysRoleDAO getSysRoleDAO(){
		return (SysRoleDAO)baseMybatisDAO;
	}
	
	
	public PageBean queryRolePage(PageBean param){
		return getSysRoleDAO().queryPage(param);
	}
	
	


}
