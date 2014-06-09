package com.institute.meeting.adminuser.dao;

import com.institute.meeting.common.dao.BaseDao;


public interface AdminRightDao extends BaseDao {

	/**
	 * 根据roleId删除
	 * @param roleId
	 */
	public void deleteByRole(Integer roleId);
}
