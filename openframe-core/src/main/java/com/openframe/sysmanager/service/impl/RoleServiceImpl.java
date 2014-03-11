package com.openframe.sysmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openframe.common.page.PageBean;
import com.openframe.sysmanager.dao.RoleDAO;
import com.openframe.sysmanager.domain.Role;
import com.openframe.sysmanager.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	@Qualifier("roleDAO")
	private RoleDAO roleDAO;
	
	
	/**
	 * 分页查找
	 * @param pageObj
	 * @return
	 */
	public PageBean queryPageUser(PageBean pageObj){
		return roleDAO.queryPage(pageObj);
	}
	
	@Transactional
	public void save(Role role){
		roleDAO.insert(role);
	}
	
	
	public int count(int param){
		List<Role> list = roleDAO.selectAll();
		return list.size();
	}
	
	
}
