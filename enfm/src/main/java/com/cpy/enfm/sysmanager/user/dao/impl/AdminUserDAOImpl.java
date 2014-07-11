package com.cpy.enfm.sysmanager.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.cpy.enfm.common.dao.impl.BaseMybatisDAOImpl;
import com.cpy.enfm.sysmanager.user.dao.AdminUserDAO;
import com.cpy.enfm.sysmanager.user.entity.AdminUsers;

@Repository("adminUserDAO")
public class AdminUserDAOImpl extends BaseMybatisDAOImpl<AdminUsers> implements
		AdminUserDAO {



}
