package com.institute.meeting.adminuser.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.institute.meeting.adminuser.dao.ModelDao;
import com.institute.meeting.adminuser.entity.TModel;
import com.institute.meeting.adminuser.service.ModelService;

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
