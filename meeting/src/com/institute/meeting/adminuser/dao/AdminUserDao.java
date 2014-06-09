package com.institute.meeting.adminuser.dao;

import com.institute.meeting.adminuser.entity.TAdminusers;
import com.institute.meeting.common.dao.BaseDao;
import com.institute.meeting.utils.PageBean;

public interface AdminUserDao extends BaseDao {
	
	/**
	 * 根据用户名和密码查找
	 * @param userAccount
	 * @param password
	 * @return
	 */
	public TAdminusers findByNamePass(String userAccount,String password);
	
	/**
	 * 分页查询后台用户
	 * @param pageSize  
	 * @param curPage  当前页码数
	 * @return
	 */
	public PageBean queryPageList(int pageSize,int curPage);
	/**
	 * 删除用户
	 * 
	 */
	public void deleteAdminUser(int userId);
	
	/**
	 * 根据用户名查找用户
	 * @param userAccount
	 * @return
	*/
	public boolean findByName(String userAccount);
	
	

}
