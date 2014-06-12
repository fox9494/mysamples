package com.institute.meeting.adminuser.dao;

import com.institute.meeting.adminuser.entity.TAdminRole;
import com.institute.meeting.common.dao.BaseDao;
import com.institute.meeting.utils.PageBean;

public interface AdminRoleDao extends BaseDao {	
	
	/**
	 * 分页查找系统角色
	 * @param pageSize
	 * @param currentPage
	 * @param role
	 * @return
	 */
	public PageBean queryListPage(int pageSize, Integer currentPage, TAdminRole role);
}
