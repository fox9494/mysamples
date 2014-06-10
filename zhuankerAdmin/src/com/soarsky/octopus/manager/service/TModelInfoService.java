package com.soarsky.octopus.manager.service;

import java.util.List;
import java.util.Map;

import com.soarsky.octopus.clientuser.vo.TreeData;
import com.soarsky.octopus.manager.vo.TransModelBean;
import com.soarsky.octopus.mapping.TModelInfo;



public interface TModelInfoService {
	
	
	/**
	 * 只查询第三级菜单
	 * @return
	 */
	public List<TransModelBean>  queryThirdLevelMenu();
	
	/**
	 * 查询所有模块
	 * @return  Map
	 */
	public Map<Long,TModelInfo> queryAllForMap();

	
	
	//增加model
	public void addModel(Long parentId,TModelInfo tmodel);
	
	//删除model
	public void deleteModel(Long id);
	
	//根据id查询modelinfo
	public TModelInfo findModelInfo(Long id);
	
	/**
	 * 查询出所有模块封装成jstree的树结构数据类型
	 * @return
	 */
	public List<TreeData> findAllModelForTree();
}
