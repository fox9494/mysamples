package com.institute.meeting.adminuser.service.impl;

import java.util.List;

import com.institute.meeting.adminuser.dao.AdminRightDao;
import com.institute.meeting.adminuser.entity.TAdminRight;
import com.institute.meeting.adminuser.service.AdminRightService;

public class AdminRightServiceImple implements AdminRightService {
	
	private AdminRightDao adminRightDao;
	
	
	
	/**
	 *更新权限，先删除，后更新或插入
	 */
	public void updateRight(Integer roleId,List<TAdminRight> list){
		adminRightDao.deleteByRole(roleId);
		adminRightDao.batchMerger(list);
	}

	public AdminRightDao getAdminRightDao() {
		return adminRightDao;
	}

	public void setAdminRightDao(AdminRightDao adminRightDao) {
		this.adminRightDao = adminRightDao;
	}
	
	

}
