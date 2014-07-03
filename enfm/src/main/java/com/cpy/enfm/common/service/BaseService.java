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
	public void save(T entity);
	
	

	/**
	 * 根据主键查找
	 * @param id
	 * @return
	 */
	public Object findById(Integer id);
	
	
	/**
	 * 根据主键更新对象所有属性
	 * @param entity
	 */
	public void update(Object entity);
	
	
	/**
	 * 根据属性查找
	 * @param propertyName  属性名
	 * @param value    属性值
	 * @return
	 */
	public  List<T> findByProperty(String propertyName, Object value) ;
	
	/**
	 * 删除对象
	 * @param entity
	 */
	public void delete(Object entity);
	

}
