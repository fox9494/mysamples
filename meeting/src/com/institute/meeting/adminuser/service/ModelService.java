package com.institute.meeting.adminuser.service;

import java.util.List;
import java.util.Map;

import com.institute.meeting.adminuser.entity.TModel;
import com.institute.meeting.common.entity.TreeModel;

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
	
	
	/**
	 * 查询所有的资源模块，并转成树形数据
	 * @return
	 */
	public List<TreeModel> findAllModelForTree();

}
