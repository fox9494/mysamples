package com.institute.meeting.adminuser.service;

import java.util.List;

import com.institute.meeting.adminuser.entity.TAdminusers;
import com.institute.meeting.adminuser.vo.MenuVO;
import com.institute.meeting.utils.PageBean;

public interface AdminUserService {
	
	/**
	 * 验证用户登录
	 * @return
	 */
	public TAdminusers login(String name,String password);
	
	/**
	 * 分页查询用户
	 * @param pageSize  每页记录数
	 * @param curPage  当前页码数
	 * @return
	 */
	public PageBean queryPageList(int pageSize,int curPage);
	
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(TAdminusers user);
	
	/**
	 * 删除用户
	 * 
	 */
    public void deleteAdminUser(int userId);
    /**
     * 
     * 根据ID查找用户
     * 
     */
    public TAdminusers findByAdminUser(int userId);
    
    
    /**
	 * 得到用户的导航菜单
	 * @param uid
	 * @return
	 */
	public List<MenuVO> getAdminUserMenus(Integer uid);
    /**
     * 
     * 修改用户
     * 
     * 
     */
    public void updateAdminUser(TAdminusers tadminUsers);
     
    /**
	 * 根据用户名查找用户
	 * @param userAccount
	 * @return
	 */
	public boolean findByName(String userAccount);
}
