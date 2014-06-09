package com.institute.meeting.adminuser.dao.impl;

import com.institute.meeting.adminuser.dao.AdminRightDao;
import com.institute.meeting.common.dao.impl.BaseDaoImpl;

public class AdminRightDaoImpl extends BaseDaoImpl implements AdminRightDao {

	public void deleteByRole(Integer roleId) {
		String sql = "delete from t_admin_right where roleId=?";
		this.getSession().createSQLQuery(sql).setInteger(0, roleId)
				.executeUpdate();
	}

	
}
