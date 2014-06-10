package com.institute.meeting.adminuser.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.institute.meeting.adminuser.dao.ModelDao;
import com.institute.meeting.adminuser.entity.TModel;
import com.institute.meeting.adminuser.service.ModelService;
import com.institute.meeting.common.entity.TreeModel;

public class ModelServiceImpl implements ModelService {
	
	private ModelDao modelDao;
	
	/**
	 * 查询所有导航模块信息
	 * @return
	 */
	public List<TModel> findAllMenu(){
		return modelDao.queryAllMenu();
	}
	
	
	/**
	 * 查询所有的资源模块，并转成树形数据
	 * @return
	 */
	public List<TreeModel> findAllModelForTree(){
		List<TModel> modelList = modelDao.queryAll(TModel.class);
		List<TreeModel> treeList = new ArrayList<TreeModel>();
		if (modelList!=null && !modelList.isEmpty()){
			for (TModel tModel : modelList) {
				TreeModel treeData = new TreeModel();
				treeData.setId(String.valueOf(tModel.getModelId()));
				treeData.setName(tModel.getName());
				treeData.setpId(String.valueOf(tModel.getParent()!=null?tModel.getParent().getModelId():null));
				treeList.add(treeData);
			}
		}
		
		return treeList;
	}
	
	/**
	 * 查询所有模块
	 * @return  Map
	 */
	public Map<Integer,TModel> queryAllForMap(){
		List<TModel> list = modelDao.queryAll(TModel.class);
		Map<Integer,TModel> map = new HashMap<Integer, TModel>();
		if (list!=null && !list.isEmpty()){
			for (TModel modelInfo : list) {
				map.put(modelInfo.getModelId(), modelInfo);
			}
		}
		return map;
	}

	public ModelDao getModelDao() {
		return modelDao;
	}

	public void setModelDao(ModelDao modelDao) {
		this.modelDao = modelDao;
	}

}
