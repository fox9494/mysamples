package com.soarsky.octopus.manager.service;

import java.util.List;

import com.soarsky.octopus.mapping.TRoleInfo;
import com.soarsky.octopus.utils.PageBean;

public interface TRoleInfoService {
	
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<TRoleInfo> findAllRole();
	
	
	/**
	 * 分页查找
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public PageBean queryListPage(int pageSize,int currentPage);
	
	
	/**
	 * 新增角色
	 * @param role
	 */
	public void addRole(TRoleInfo role);
	
	/**
	 * 查找角色
	 * @param id 主键Id
	 */
	public TRoleInfo findRole(Long id);
	
	
	/**
	 * 更新
	 * @param role
	 */
	public void editRole(TRoleInfo role);
	
	/**
	 * 删除单个角色
	 * @param id
	 */
	public void deleteRole(Long id);
	
	/**
	 * 判断角色名是否重复
	 */
	public boolean judgeRoleName(String roleName);
	
	/**
	 * 判断是否有用户使用此角色
	 */
	public boolean judgeRoleUser(Long id);

}
