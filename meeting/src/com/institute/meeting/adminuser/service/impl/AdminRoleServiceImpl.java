package com.institute.meeting.adminuser.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.institute.meeting.adminuser.dao.AdminRoleDao;
import com.institute.meeting.adminuser.entity.TAdminRight;
import com.institute.meeting.adminuser.entity.TAdminRole;
import com.institute.meeting.adminuser.entity.TModel;
import com.institute.meeting.adminuser.service.AdminRoleService;
import com.institute.meeting.adminuser.vo.RoleInfoVO;
import com.institute.meeting.common.service.impl.BaseServiceImpl;

public class AdminRoleServiceImpl extends BaseServiceImpl<TAdminRole> implements AdminRoleService {
	
	private AdminRoleDao   adminRoleDao;
	
	
	@Override
	protected Class getEntityClass() {
		return TAdminRole.class;
	}
	
	
	/**
	 * 保存角色和权限
	 */
	public void saveRoleAndRight(TAdminRole role,String moduleIds){
		adminRoleDao.save(role);
		String[] modules = moduleIds.split(",");
		List<TAdminRight> rightList = new ArrayList<TAdminRight>();
		for (String module : modules) {
			TAdminRight right = new TAdminRight();
			right.setRole(role);
			TModel model = new TModel();
			model.setModelId(Integer.valueOf(module));
			right.setModel(model);
			rightList.add(right);
		}
		adminRoleDao.batchAdd(rightList);
	}
	
	/**
	 * 验证角色名是否唯一
	 * 唯一则返回true
	 * @param name
	 * @return
	 */
	public boolean validateName(String name){
		List<TAdminRole> list = adminRoleDao.findByProperty(TAdminRole.class, "roleName", name);
		if (list!=null && !list.isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	
	
	/**
	 * 查询所有的角色权限,带有模块名
	 * @return
	 */
	public List<RoleInfoVO> findRoleRight(){
		List<TAdminRole> list = adminRoleDao.queryAll(TAdminRole.class);
		
		List<RoleInfoVO> voList = new ArrayList<RoleInfoVO>();
		
		if (list!=null){
			for (TAdminRole roleInfo : list) {
				RoleInfoVO vo = new RoleInfoVO();
				vo.setRoleId(roleInfo.getRoleId());
				vo.setRoleName(roleInfo.getRoleName());
				Set<TAdminRight> rightSet = roleInfo.getRoleRightSet();
				if (rightSet!=null && !rightSet.isEmpty()){
					for (TAdminRight rightInfo : rightSet) {
						TModel model = rightInfo.getModel();
						TModel parent = model.getParent();
						if (parent==null){//表示是根节点，查询列表只显示根节点权限
							vo.setModelName(model.getName()+"|"+vo.getModelName());
						}
						
					}
					
					vo.setModelName(vo.getModelName().substring(0, vo.getModelName().lastIndexOf("|")));//去掉后面的null模块名
				}
				voList.add(vo);
			}
		}
		
		return voList;
	}
	
	/**
	 * 更新角色
	 * @param entity
	 */
	public void updateRole(TAdminRole entity){
		adminRoleDao.update(entity);
	}


	public AdminRoleDao getAdminRoleDao() {
		return adminRoleDao;
	}


	public void setAdminRoleDao(AdminRoleDao adminRoleDao) {
		this.adminRoleDao = adminRoleDao;
	}






	

}
