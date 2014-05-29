package com.openframe.sysmanager.service;

import java.util.List;

import com.openframe.common.page.PageBean;
import com.openframe.sysmanager.domain.User;

public interface UserService {
	
	/**
	 * 添加多个用户
	 * @param list
	 */
	public void addUsers(List<User> list);
	
	public void add(User user);
	
	public User queryOne(String userId);
	
	/**
	 * 分页查询
	 * @param pageObj
	 * @return
	 */
	public PageBean queryPageUser(PageBean pageObj);

}
