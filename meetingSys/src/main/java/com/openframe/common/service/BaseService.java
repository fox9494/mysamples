package com.openframe.common.service;

import java.util.List;

public interface BaseService<T> {
	
	public int save(T entity);
	
	public int delete(Object id);
	
	
	public T findOne(Object id);
	
	
	public List<T> findAll();

}
