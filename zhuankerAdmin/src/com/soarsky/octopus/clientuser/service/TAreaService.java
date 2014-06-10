package com.soarsky.octopus.clientuser.service;

import java.util.List;

import com.soarsky.octopus.clientuser.vo.TreeData;
import com.soarsky.octopus.mapping.TArea;

public interface TAreaService {

	//查询区域
	public List<TreeData> findArea();
	
	//添加区域
	public void addArea(Long parentid,String statename);
	
	//删除区域
	public void deleteArea(Long id);
	
	//编辑区域
	public void editArea(Long id,String statename);
	
	//初始化区域
	public List<TreeData> initArea();
	
	//根据父节点查询区域
	public List<TreeData> findAreaById(Long parentId);
	
	//根据ID查询区域
	public TArea findAreaByClientId(Long id);
	
	/**
	 * 根据parentId查找本级的所有区域
	 * @param parentId
	 * @return
	 */
	public List<TArea>  findLevelArea(Long parentId);
	/**
	 * 根据id查找区域
	 * @param id
	 * @return
	 */
	public TArea findAreaByAreaId(long id);
	
	
}
