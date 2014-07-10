package com.cpy.enfm.common.service.impl;

import com.cpy.enfm.common.dao.BaseMybatisDAO;
import com.cpy.enfm.common.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	
	protected BaseMybatisDAO<T> baseDao;
	
	
	
	@Override
	public void save(T entity) {
		baseDao.insert(entity);
		
	}	

	
	/**
	 * 获取相应service的的实体class
	 * @return
	 */
	protected abstract Class<T> getEntityClass();
	
	


	
}
