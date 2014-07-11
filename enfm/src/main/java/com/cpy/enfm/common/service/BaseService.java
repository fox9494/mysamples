package com.cpy.enfm.common.service;

import java.util.List;

public interface BaseService<T> {
	
	
	/**
	 * 查询所有
	 */
	public List<T>  findAll();
	
	
	/**
	 * 保存
	 * @param entity
	 */
	public int save(T entity);
	

	/**
	 * 根据主键查找
	 * @param id
	 * @return
	 */
	public T findById(Integer id);
	
	
	/**
	 * 根据主键更新对象所有属性
	 * @param entity
	 */
	public int update(Object entity);
	
	
	/**
	 * 删除对象
	 * @param entity
	 */
	public int delete(Object entity);
	

}
