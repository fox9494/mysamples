package com.openframe.sys.role.dao.impl;

import org.springframework.stereotype.Repository;

import com.openframe.common.dao.impl.BaseMybatisDAOImpl;
import com.openframe.sys.role.dao.SysRoleDAO;
import com.openframe.sys.role.domain.SysRole;


@Repository("sysRoleDAO")
public class SysRoleDAOImpl extends BaseMybatisDAOImpl<SysRole> implements SysRoleDAO{

}
