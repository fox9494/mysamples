package com.cpy.enfm.common.service.impl;

import java.util.List;

import com.cpy.enfm.common.dao.BaseMybatisDAO;
import com.cpy.enfm.common.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	
	protected BaseMybatisDAO<T> baseDao;
	
	
	
	@Override
	public int save(T entity) {
		return baseDao.insert(entity);
	}	
	

	/**
	 * 返回所有数据
	 */
	@Override
	public List<T> findAll() {
		return baseDao.selectAll();
	}



	/**
	 * 根据id查找
	 */
	@Override
	public T findById(Integer id) {
		return baseDao.selectById(id);
	}


	/**
	 * 根据主键更新
	 */
	@Override
	public int update(Object entity) {
		return baseDao.updateById(entity);
	}




	@Override
	public int delete(Object entity) {
		return baseDao.deleteById(entity);
	}


	
	


	
}
