package com.cpy.enfm.common.service.impl;

import java.util.List;

import com.cpy.enfm.common.dao.BaseMybatisDAO;
import com.cpy.enfm.common.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService {
	
	
	private BaseMybatisDAO<T> baseDao;
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(T entity){
		baseDao.insert(entity);
	}
	
	/**
	 * 获取相应service的的实体class
	 * @return
	 */
	protected abstract Class<T> getEntityClass();
	
	
	/**
	 * 根据主键查找
	 * @param id
	 * @return
	 */
	public Object findById(Integer id){
		return baseDao.getById(getEntityClass(), id);
	}
	
	
	/**
	 * 查询所有
	 */
	public List<T>  findAll(){
		return baseDao.queryAll(this.getEntityClass());
	}
	
	
	/**
	 * 删除对象
	 * @param entity
	 */
	public void delete(Object entity){
		baseDao.delete(entity);
	}
	
	/**
	 * 根据主键更新对象所有属性
	 * @param entity
	 */
	public void update(Object entity){
		baseDao.update(entity);
	}
	
	
	/**
	 * 根据属性查找
	 * @param propertyName  属性名
	 * @param value    属性值
	 * @return
	 */
	public  List<T> findByProperty(String propertyName, Object value) {
	     return baseDao.findByProperty(this.getEntityClass(), propertyName, value);
	}	

}
