package com.openframe.common.service.impl;

import java.util.List;

import com.openframe.common.dao.BaseMybatisDAO;

public class BaseServiceImpl<T> {
	
	
	protected BaseMybatisDAO<T> baseMybatisDAO;
	
	public void setBaseMybatisDAO(BaseMybatisDAO<T> baseDAO){
		this.baseMybatisDAO=baseDAO;
	}
	
	
	public int save(T entity){
		return baseMybatisDAO.insert(entity);
	}
	
	
	public int delete(Object id){
		return baseMybatisDAO.deleteById(id);
	}
	
	
	public T findOne(Object id){
		return baseMybatisDAO.selectById(id);
	}
	
	
	public List<T> findAll(){
		return baseMybatisDAO.selectAll();
	}

}
