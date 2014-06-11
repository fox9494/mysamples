package com.institute.meeting.adminuser.service;

import java.util.List;

import com.institute.meeting.adminuser.entity.TAdminRole;
import com.institute.meeting.adminuser.vo.RoleInfoVO;
import com.institute.meeting.common.service.BaseService;

public interface AdminRoleService extends BaseService{
	
	
	/**
	 * 查询所有的角色权限,带有模块名
	 * @return
	 */
	public List<RoleInfoVO> findRoleRight();
	
	/**
	 * 保存角色和权限
	 */
	public void saveRoleAndRight(TAdminRole role,String moduleIds);
	
	
	/**
	 * 验证角色名是否唯一
	 * 唯一则返回true
	 * @param name
	 * @return
	 */
	public boolean validateName(String name);
	
	

}
