package com.openframe.sysmanager.dao;

import java.util.List;

import com.openframe.common.dao.BaseMybatisDAO;
import com.openframe.sysmanager.domain.User;

public interface UserDAO extends BaseMybatisDAO<User>{
	
	/**
	 * 批量添加
	 * @param list
	 */
	public void batchInsert(List<User> list);
	
	
	

}
