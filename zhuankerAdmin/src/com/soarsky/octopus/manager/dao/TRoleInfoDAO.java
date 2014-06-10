package com.soarsky.octopus.manager.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TRoleInfo;
import com.soarsky.octopus.utils.PageBean;

public class TRoleInfoDAO extends BaseDAO  {
	
	/**
	 * 分页查找后台用户
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public PageBean queryForPage(int pageSize,int currentPage){
		return this.queryForPageByParams(pageSize, currentPage, this.getSession().createCriteria(TRoleInfo.class).add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE)).addOrder(Order.asc("id")));
	}
	
	/**
	 * 更新角色名
	 * @param role
	 */
	public void updateRole(TRoleInfo role){
		String hql = "update TRoleInfo t set t.roleName=:roleName where t.id=:id";
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleName", role.getRoleName());
		paramMap.put("id", role.getId());
		this.executeByHql(hql, paramMap);
	}
	
	/**
	 * 逻辑删除
	 * @param role
	 */
	public void deleteRole(TRoleInfo role){
		String hql = "update TRoleInfo t set t.isRemove=:isRemove where t.id=:id";
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("isRemove", JEEContant.ROMOVE);
		paramMap.put("id", role.getId());
		this.executeByHql(hql, paramMap);
	}
	
	/**
	 * 查询所以角色，并且判断角色是否重复
	 */
	public boolean findAllRoleName(String roleName){
		
		List<TRoleInfo> roleList=this.getSession().createCriteria(TRoleInfo.class).add(Restrictions.eq("roleName", roleName)).list();
		if(roleList.size()>0){
			return true;
		}
		return false;
	}
	
	
}