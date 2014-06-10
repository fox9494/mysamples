package com.soarsky.octopus.manager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.dao.TManagerInfoDAO;
import com.soarsky.octopus.manager.dao.TRoleInfoDAO;
import com.soarsky.octopus.manager.service.TRoleInfoService;
import com.soarsky.octopus.mapping.TRightInfo;
import com.soarsky.octopus.mapping.TRoleInfo;
import com.soarsky.octopus.utils.PageBean;

public class TRoleInfoServiceImpl implements TRoleInfoService {
	
	private TRoleInfoDAO tRoleInfoDAO;
	
	private TManagerInfoDAO tManagerInfoDAO;
	

	/**
	 * 查询所有角色
	 * @return
	 */
	public List<TRoleInfo> findAllRole(){
		
		List<TRoleInfo> newTRoleInfoList=new ArrayList<TRoleInfo>();
		List<TRoleInfo> tRoleInfoList=tRoleInfoDAO.queryAll(TRoleInfo.class);
		for(TRoleInfo role :tRoleInfoList){
			
			if(role.getIsRemove()==JEEContant.NOTROMOVE){
				
				newTRoleInfoList.add(role);
			}
		}
		return newTRoleInfoList;
		
	}
	
	/**
	 * 分页查找
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public PageBean queryListPage(int pageSize,int currentPage){
		return tRoleInfoDAO.queryForPage(pageSize, currentPage);
	}
	
	
	/**
	 * 新增角色
	 * @param role
	 */
	public void addRole(TRoleInfo role){
		tRoleInfoDAO.save(role);
	}
	
	/**
	 * 查找角色
	 * @param id 主键Id
	 */
	@SuppressWarnings("unchecked")
	public TRoleInfo findRole(Long id){
		TRoleInfo role = tRoleInfoDAO.getById(TRoleInfo.class, id);
		if (role!=null){
			Set<TRightInfo> set = role.getTRightInfos();
			for (TRightInfo right : set) {//此循环为了加载延迟对象，可以什么都不做
				
			}
		}
		
		return role;
		
	}
	
	/**
	 * 更新
	 * @param role
	 */
	public void editRole(TRoleInfo role){
		tRoleInfoDAO.updateRole(role);
	}
	
	/**
	 * 删除单个角色,逻辑删除
	 * @param id
	 */
	public void deleteRole(Long id){
		tRoleInfoDAO.deleteRole(new TRoleInfo(id));
	}

	public TRoleInfoDAO gettRoleInfoDAO() {
		return tRoleInfoDAO;
	}

	public void settRoleInfoDAO(TRoleInfoDAO tRoleInfoDAO) {
		this.tRoleInfoDAO = tRoleInfoDAO;
	}

	/**
	 * 判断角色名是否重复
	 */
	public boolean judgeRoleName(String roleName) {
		
		return this.tRoleInfoDAO.findAllRoleName(roleName);
	}

	/**
	 * 判断是否有用户使用此角色
	 */
	public boolean judgeRoleUser(Long id) {
		
		
		
		return this.tManagerInfoDAO.findByRoleUser(id);
	}

	public TManagerInfoDAO gettManagerInfoDAO() {
		return tManagerInfoDAO;
	}

	public void settManagerInfoDAO(TManagerInfoDAO tManagerInfoDAO) {
		this.tManagerInfoDAO = tManagerInfoDAO;
	}

	
}
