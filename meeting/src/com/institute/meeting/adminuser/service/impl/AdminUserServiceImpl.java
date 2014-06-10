package com.institute.meeting.adminuser.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.institute.meeting.adminuser.dao.AdminRoleDao;
import com.institute.meeting.adminuser.dao.AdminUserDao;
import com.institute.meeting.adminuser.dao.AdminUserRoleDao;
import com.institute.meeting.adminuser.entity.TAdminRight;
import com.institute.meeting.adminuser.entity.TAdminRole;
import com.institute.meeting.adminuser.entity.TAdminusers;
import com.institute.meeting.adminuser.entity.TAdminusersRole;
import com.institute.meeting.adminuser.entity.TModel;
import com.institute.meeting.adminuser.service.AdminUserService;
import com.institute.meeting.adminuser.vo.MenuVO;
import com.institute.meeting.enums.EnumConstant;
import com.institute.meeting.utils.PageBean;

/**
 * 后台用户管理
 * @author chenll
 *
 */
public class AdminUserServiceImpl implements AdminUserService {
	
	private AdminUserDao adminUserDao;
	
	private AdminRoleDao adminRoleDao;
	
	private AdminUserRoleDao adminUserRoleDao;
	
	
	/**
	 * 验证用户登录
	 * @return
	 */
	public TAdminusers login(String name,String password){
		return adminUserDao.findByNamePass(name, password);
	}
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(TAdminusers user){
		adminUserDao.save(user);
	}
	
	/**
	 * 分页查询用户
	 * @param pageSize  每页记录数
	 * @param curPage  当前页码数
	 * @return
	 */
	public PageBean queryPageList(int pageSize,int curPage){
		return adminUserDao.queryPageList(pageSize, curPage);
	}
	
	/**
	 * 删除用户
	 * 
	 */
      public void deleteAdminUser(int userId) {
		
		adminUserDao.deleteAdminUser(userId);
	}


	public AdminUserDao getAdminUserDao() {
		return adminUserDao;
	}

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	
	/**
     * 
     * 根据ID查找用户
     * 
     */
	public TAdminusers findByAdminUser(int userId) {
		
		return adminUserDao.getById(TAdminusers.class, userId);
	}


	 /**
     * 
     * 修改用户
     * 
     * 
     */
	public void updateAdminUser(TAdminusers tadminUsers) {
		
		adminUserDao.update(tadminUsers) ;
	}
	
	
	/**
	 * 得到用户的导航菜单
	 * @param uid
	 * @return
	 */
	public List<MenuVO> getAdminUserMenus(Integer uid){
		
		List<TAdminusersRole> usersRole = adminUserRoleDao.findByProperty(TAdminusersRole.class, "userId", uid);
		List<MenuVO> list = new ArrayList<MenuVO>();
		if (usersRole!=null && !usersRole.isEmpty()){
			Map<Integer,MenuVO> menuMap = new HashMap<Integer, MenuVO>();
			for (TAdminusersRole adminusersRole : usersRole) {
				TAdminRole roleBean = adminRoleDao.getById(TAdminRole.class, adminusersRole.getRoleId());
				Set<TAdminRight> rights = roleBean.getRoleRightSet();
				
				//将map中存放所有转化的MenuVo
				if (rights!=null){
					for (TAdminRight rightInfo : rights) {
						TModel model = rightInfo.getModel();
						
						if (EnumConstant.MENU.getCode().equals(model.getType())){
							TModel parent = model.getParent();
							
							MenuVO vo = new MenuVO();
							vo.setTitle(model.getIcon()+model.getName());//名称加上导航图标
							vo.setWidth("80");
							vo.setHref(model.getUrl());
							vo.setItems(new ArrayList<MenuVO>());
							vo.setId(model.getModelId());
							if (parent!=null){
								vo.setParentId(parent.getModelId());
							}
							menuMap.put(model.getModelId(),vo);
						}
					}
				}
				
			}
			
			//将map中的menu设置子菜单
			Set<Entry<Integer, MenuVO>> set = menuMap.entrySet();
			for (Entry<Integer, MenuVO> entry : set) {
				MenuVO menu = entry.getValue();
				
				MenuVO parentMenu = menuMap.get(menu.getParentId());
				if (parentMenu==null){
					list.add(menu);
				}else{
					parentMenu.getItems().add(menu);
				}
			}
		}
		
		/*int roleId = adminUserDao.getById(TAdminusers.class, uid).getUserRole();
		TAdminRole roleBean = adminRoleDao.getById(TAdminRole.class, roleId);
		Set<TAdminRight> rights = roleBean.getRoleRightSet();
		
		
		List<MenuVO> list = new ArrayList<MenuVO>();
		Map<Integer,MenuVO> menuMap = new HashMap<Integer, MenuVO>();
		
		//将map中存放所有转化的MenuVo
		if (rights!=null){
			for (TAdminRight rightInfo : rights) {
				TModel model = rightInfo.getModel();
				
				if (EnumConstant.MENU.getCode().equals(model.getType())){
					TModel parent = model.getParent();
					
					MenuVO vo = new MenuVO();
					vo.setTitle(model.getIcon()+model.getName());//名称加上导航图标
					vo.setWidth("80");
					vo.setHref(model.getUrl());
					vo.setItems(new ArrayList<MenuVO>());
					vo.setId(model.getModelId());
					if (parent!=null){
						vo.setParentId(parent.getModelId());
					}
					menuMap.put(model.getModelId(),vo);
				}
			}
		}
		*/
		
		//将map中的menu设置子菜单
//		Set<Entry<Integer, MenuVO>> set = menuMap.entrySet();
//		for (Entry<Integer, MenuVO> entry : set) {
//			MenuVO menu = entry.getValue();
//			
//			MenuVO parentMenu = menuMap.get(menu.getParentId());
//			if (parentMenu==null){
//				list.add(menu);
//			}else{
//				parentMenu.getItems().add(menu);
//			}
//		}
//		
		return list;
		
	}
	
	/**
	 * 根据用户名查找用户
	 * @param userAccount
	 * @return
	*/
	public boolean findByName(String userAccount) {
		
		return adminUserDao.findByName(userAccount);
	}

	public AdminRoleDao getAdminRoleDao() {
		return adminRoleDao;
	}

	public void setAdminRoleDao(AdminRoleDao adminRoleDao) {
		this.adminRoleDao = adminRoleDao;
	}

	public AdminUserRoleDao getAdminUserRoleDao() {
		return adminUserRoleDao;
	}

	public void setAdminUserRoleDao(AdminUserRoleDao adminUserRoleDao) {
		this.adminUserRoleDao = adminUserRoleDao;
	}

}
