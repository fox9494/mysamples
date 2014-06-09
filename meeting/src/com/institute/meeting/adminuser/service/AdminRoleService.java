package com.institute.meeting.adminuser.service;

import java.util.List;

import com.institute.meeting.adminuser.entity.TAdminRole;
import com.institute.meeting.adminuser.vo.RoleInfoVO;

public interface AdminRoleService {
	
	/**
	 * 查询所有的角色
	 * @return
	 */
	public List<TAdminRole>  findAllRole();
	
	
	/**
	 * 查询所有的角色权限,带有模块名
	 * @return
	 */
	public List<RoleInfoVO> findRoleRight();
	
	/**
	 * 根据主键查找
	 * @param roleId
	 * @return
	 */
	public TAdminRole findById(Integer roleId);
	
	/**
	 * 更新角色
	 * @param entity
	 */
	public void updateRole(TAdminRole entity);

}
