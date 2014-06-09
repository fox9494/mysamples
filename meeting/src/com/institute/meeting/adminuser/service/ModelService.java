package com.institute.meeting.adminuser.service;

import java.util.List;
import java.util.Map;

import com.institute.meeting.adminuser.entity.TModel;

public interface ModelService {
	
	
	/**
	 * 查询所有导航模块信息
	 * @return
	 */
	public List<TModel> findAllMenu();
	
	/**
	 * 查询所有模块
	 * @return  Map
	 */
	public Map<Integer,TModel> queryAllForMap();

}
