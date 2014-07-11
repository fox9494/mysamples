package com.cpy.enfm.sysmanager.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpy.enfm.common.service.impl.BaseServiceImpl;
import com.cpy.enfm.sysmanager.user.dao.AdminUserDAO;
import com.cpy.enfm.sysmanager.user.entity.AdminUsers;
import com.cpy.enfm.sysmanager.user.entity.AdminUsersExample;
import com.cpy.enfm.sysmanager.user.service.AdminUserService;

@Service("adminUserService")
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUsers> implements
		AdminUserService {
	
	
	public AdminUserDAO getDao() {
		return (AdminUserDAO) baseDao;
	}

	@Autowired
	public void setBaseDao(AdminUserDAO adminUserDAO) {
		this.baseDao = adminUserDAO;
	}
	
	
	/**
	 * 根据账户查找
	 * @param user
	 * @return
	 */
	public List<AdminUsers> findByAccount(String accountName){
		AdminUsersExample userExample = new AdminUsersExample();
		userExample.or().andUserAccountEqualTo(accountName);
		return getDao().selectByExample(userExample);
	}


}
