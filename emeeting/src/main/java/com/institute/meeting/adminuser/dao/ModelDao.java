package com.institute.meeting.adminuser.dao;

import java.util.List;

import com.institute.meeting.adminuser.entity.TModel;
import com.institute.meeting.common.dao.BaseDao;

public interface ModelDao extends BaseDao {
	
	
	/**
	 * 查询所有导航菜单
	 * @return
	 */
	public List<TModel>  queryAllMenu();

}
