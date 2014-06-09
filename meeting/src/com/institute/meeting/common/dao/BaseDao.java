package com.institute.meeting.common.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;

import com.institute.meeting.utils.PageBean;

public interface BaseDao {
	
	/**
	 *保存对象,能立即返回主键
	 * @param transientInstance
	 */
	public void save(Object entityObject);
	
	/**
	 * 查询所有数据
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	public <T> List<T> queryAll(Class<T> clazz);
	
	
	/**
	 *批量更新或插入
	 */
	public <T> void batchMerger(List<T> list);
	
	
	/**
	 * 更新或者插入
	 * @param <T>
	 * @param entity
	 * @return
	 */
	public <T extends Object> T  merger(T entity);
	
	/**
	 * 根据主键查询
	 * 此方法没有数据会由hibernate抛出异常
	 * @param id  主键
	 * @return
	 */
	public <T> T loadById(Class<T> clazz,Integer id);
	
	/**
	 * 根据主键查询
	 * 此方法没有数据则返回null;
	 * @param id  主键
	 * @return
	 */
	public <T> T getById(Class<T> clazz,Integer id);
	
	/**
	 *批量插入
	 */
	public <T> void batchAdd(List<T> list);
	
	/**
	 * 删除对象
	 * @param entity
	 */
	public void delete(Object entity);
	
	/**
	 * 更新对象
	 * @param entity
	 */
	public void update(Object entity);
	
	/**
	 * 执行hql进行 增，删，改
	 * @param hql
	 * @param paramMap
	 */
	public void executeByHql(String hql,Map<String,Object> paramMap);
	
	/**
	 * 根据属性查找
	 * @param clazz  对象的class
	 * @param propertyName  属性名
	 * @param value    属性值
	 * @return
	 */
	public <T> List<T> findByProperty(Class<T> clazz,String propertyName, Object value);
	
	/**
	 * 通过给定的实例进行查询
	 * @param instance
	 * @return
	 */
	public <T> List<T> findByExample(T instance);

	
	/**
	 * 分页查询，可以带查询参数
	 * @param pageSize  页面总数  
	 * @param page   当前页面
	 * @param hql    sql语句
	 * @param params   参数,map形式(参数名，参数值),没有可以置为null
	 * @return
	 */
	public PageBean queryForPageByParams(int pageSize, int page, String hql,Map<String,Object> params,Class<?> clazz);
	
	/**
	 * 分页查询，根据查询参数动态组装HQL语句
	 * @param pageSize  页面总数  
	 * @param page   当前页面
	 * @param Object  hibernate实体Bean对象
	 * @param List   查询条件Bean
	 * @return
	 */
	public PageBean queryForPageByParams(int pageSize, int page,Criteria crit);
	
	
	
	
	/**
	 * 使用原生sql查询,语句中使用命名参数
	 * @param sql
	 * @param paramMap  命名参数名和参数值
	 *  @param clazz   待查询的对象clazz
	 * @return list or null
	 */
	public <T>  List<T> queryBySql(String sql,Map<String,Object> paramMap,Class<T> clazz);


	/**
	 * 执行原生sql语句，用于增加，删除或者修改(不用于查询)
	 * @param sql
	 * @param paramMap
	 */
	public void executeBySql(String sql,Map<String,Object> paramMap);
	
	
	/**
	 * 使用hibernate的面向对象的hql进行条件查询，返回查询对象集合，语句中使用命名参数
	 * @param hql 面向对象的查询语句
	 * @param paramMap 命名参数名，参数值
	 * @return 符合条件的对象集合
	 */
	public List<?> queryByHql(String hql, Map<String,Object> paramMap);
	
	/**
	 * 返回值唯一属性的查询可用此方法比如查询count(*)、max()、min()等
	 * @param hql 要执行的hal（注意只能返回一个值）
	 * @param params 预编译hql参数（参数列表用键值对封装）
	 * @return 
	 */
	public Object queryUniqueResult(String hql, Map<String,Object> paramMap);
	

	/**
	 * 返回值唯一属性的查询可用此方法比如查询count(*)、max()、min()等
	 * @param hql 要执行的hal（注意只能返回一个值）
	 * @param params 预编译hql参数（根据参数顺序给定的参数列表）
	 * @return 
	 */
	public Object queryUniqueResult(String hql, List<Object> params);
	
	/**
	 * 使用hibernate的面向对象的hql进行条件查询，返回查询对象集合，语句中使用顺序参数
	 * @param hql 面向对象的查询语句
	 * @param params 与条件hql对应的有序参数集合
	 * @return 符合条件的对象集合
	 */
	public List<?> queryByHql(String hql, List<Object> params) ;

	
	
}
