package com.openframe.common.dao;

import java.util.List;

import com.openframe.common.page.PageBean;

public interface BaseMybatisDAO<T> {

	public T selectById(Object parameter);
	
	public int deleteById(Object parameter);
	
	public int insert(T parameter);
	
	public int updateById(Object parameter);
	
	public List<T> selectAll();
	
	/**
	 * 批量添加
	 * @param list
	 */
	public void batchInsert(List<T> list);
	
	/**
	 * 分页查询
	 * @param pageObj
	 */
	public PageBean queryPage(PageBean pageObj);
}
