package com.soarsky.octopus.common.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;

import com.soarsky.octopus.utils.PageBean;

/**
 * 数据访问dao的基类，所有dao继承此类
 * @author chenll
 *
 */
public class BaseDAO   {

	private static final Log log = LogFactory.getLog(BaseDAO.class);
	
	private SessionFactory sessionFactory;
	
	
	/**
	 * 返回当前session
	 * @return
	 */
	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	
	public <T extends Object> T  merger(T entity){
		return (T)this.getSession().merge(entity);
	}
	
	
	/**
	 *保存对象,能立即返回主键
	 * @param transientInstance
	 */
	public void save(Object entityObject) {
		this.getSession().save(entityObject);
	}
	
	/**
	 * 根据主键查询
	 * 此方法没有数据会由hibernate抛出异常
	 * @param id  主键
	 * @return
	 */
	public <T> T loadById(Class<T> clazz,Integer id){
		return (T) this.getSession().load(clazz, id);
	}
	
	/**
	 * 根据主键查询Long类型
	 * 此方法没有数据则返回null;
	 * @param id  主键
	 * @return
	 */
	public <T> T getById(Class<T> clazz,Long id){
		return (T) this.getSession().get(clazz, id);
	}
	
	/**
	 * 根据主键查询Integer类型
	 * 此方法没有数据则返回null;
	 * @param id  主键
	 * @return
	 */
	public <T> T getById(Class<T> clazz,Integer id){
		return (T) this.getSession().get(clazz, id);
	}
	/**
	 * 删除对象
	 * @param entity
	 */
	public void delete(Object entity){
		this.getSession().delete(entity);
	}
	
	/**
	 * 根据主键更新对象所有属性
	 * @param entity
	 */
	public void update(Object entity){
		this.getSession().update(entity);
	}
	
	/**
	 * 根据属性查找
	 * @param clazz  对象的class
	 * @param propertyName  属性名
	 * @param value    属性值
	 * @return
	 */
	public <T> List<T> findByProperty(Class<T> clazz,String propertyName, Object value) {
		
	     String queryString = "from "+clazz.getSimpleName()+" as model where model." 
	     						+ propertyName + "= ?";
	     Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
	}	
	
	/**
	 * 通过给定的实例进行查询
	 * @param instance
	 * @return
	 */
	public <T> List<T> findByExample(T instance) {
	      return getSession().createCriteria(instance.getClass()).add(Example.create(instance)).list();
	}   
	
	/**
	 *批量更新或插入
	 */
	public <T> void batchMerger(List<T> list){
		log.info("begin to batch merger");
		Session session = this.getSession();
		if (list!=null){
			int i=0;
			for (T t : list) {
				session.merge(t);
				if (++i%20 ==0){
					session.flush();
					session.clear();
				}
			}
		}
	}
	
	
	/**
	 *批量插入
	 */
	public <T> void batchAdd(List<T> list){
		log.info("begin to batch add");
		Session session = this.getSession();
		if (list!=null){
			int i=0;
			for (T t : list) {
				session.save(t);
				if (++i%20 ==0){
					session.flush();
					session.clear();
				}
			}
		}
	}
	
	/**
	 * 查询所有数据
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	public <T> List<T> queryAll(Class<T> clazz){
		return this.getSession().createCriteria(clazz).list();
	}
	
	/**
	 * 执行hql进行 增，删，改
	 * @param hql
	 * @param paramMap
	 */
	public void executeByHql(String hql,Map<String,Object> paramMap){
		if (StringUtils.isNotBlank(hql)){
			 Query query = this.getSession().createQuery(hql);
			if (paramMap!=null){
				Set<Entry<String, Object>> set = paramMap.entrySet();
				for (Entry<String, Object> entry : set) {
					String paramName = entry.getKey();
					Object paramValue = entry.getValue();
					query.setParameter(paramName, paramValue);
				}
			}
			query.executeUpdate();
		}

	}
	
	/**
	 * 使用原生sql查询,语句中使用命名参数
	 * @param sql
	 * @param paramMap  命名参数名和参数值
	 * @param clazz   待查询的对象clazz
	 * @return list or null
	 */
	public <T>  List<T> queryBySql(String sql,Map<String,Object> paramMap,Class<T> clazz){
		if (StringUtils.isNotBlank(sql)){
			SQLQuery query = this.getSession().createSQLQuery(sql);
			if (paramMap!=null){
				Set<Entry<String, Object>> set = paramMap.entrySet();
				for (Entry<String, Object> entry : set) {
					String paramName = entry.getKey();
					Object paramValue = entry.getValue();
					query.setParameter(paramName, paramValue);
				}
			}
			return query.addEntity(clazz).list();
		}else{
			return null;
		}
	}
	
	/**
	 * 执行原生sql语句，用于增加，删除或者修改(不用于查询)
	 * @param sql
	 * @param paramMap
	 */
	public void executeBySql(String sql,Map<String,Object> paramMap){
		if (StringUtils.isNotBlank(sql)){
			SQLQuery query = this.getSession().createSQLQuery(sql);
			if (paramMap!=null){
				Set<Entry<String, Object>> set = paramMap.entrySet();
				for (Entry<String, Object> entry : set) {
					String paramName = entry.getKey();
					Object paramValue = entry.getValue();
					query.setParameter(paramName, paramValue);
				}
			}
			query.executeUpdate();
		}
	}
	

	/**
	 * 分页查询，可以带查询参数
	 * @param pageSize  页面总数  
	 * @param page   当前页面
	 * @param sql    sql语句
	 * @param params   参数,map形式(参数名，参数值),没有可以置为null
	 * @param clazz    PageBean 中list待返回的类型
	 * @return
	 */
	public PageBean queryForPageByParams(int pageSize, int page, String sql,Map<String,Object> params,Class<?> clazz) {
		SQLQuery query = getSession().createSQLQuery(sql);
		String str = query.getQueryString();
		
		//根据查询sql生存查询总数sql语句
		String sqlCount = "select count(*) ".concat(str.substring(str.indexOf("from")));
		SQLQuery queryCount = getSession().createSQLQuery(sqlCount);
		if (params!=null){
			Set<Entry<String, Object>> set = params.entrySet();
			for (Entry<String, Object> entry : set) {
				String paramName = entry.getKey();
				Object paramValue = entry.getValue();
				queryCount.setParameter(paramName, paramValue);
			}
		}
		BigDecimal temp = (BigDecimal) queryCount.uniqueResult();
		
		int allRow = temp.intValue();
		
		//设置参数
		if (params!=null){
			Set<Entry<String, Object>> set = params.entrySet();
			for (Entry<String, Object> entry : set) {
				String paramName = entry.getKey();
				Object paramValue = entry.getValue();
				query.setParameter(paramName, paramValue);
			}
		}
		
		if (pageSize <= 0)
			pageSize = 10;
		int totalPage = PageBean.countTotalPage(pageSize, allRow);
		if (page < 1) {
			page = 1;
		} 
//		else if (page >= totalPage) {
//			page = totalPage;
//		}
		final int offset = PageBean.countOffset(pageSize, page);
		final int length = pageSize;
		final int currentPage = PageBean.countCurrentPage(page);
		
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List<?> list = query.addEntity(clazz).list();
		
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
	
	
	
	/**
	 * 分页查询，使用criteria条件查询
	 * @param pageSize  页面总数  
	 * @param page   当前页面
	 * @param crit    hibernate的crit查询
	 * @return
	 */
	public PageBean queryForPageByParams(int pageSize, int page,Criteria crit) {
		
		//查询总数
		Long temp = (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
		int allRow = temp.intValue();
		crit.setProjection(null);
		crit.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		if (pageSize <= 0){
			pageSize = 10;
		}
		int totalPage = PageBean.countTotalPage(pageSize, allRow);
		if (page < 1) {
			page = 1;
		} else if (page >= totalPage) {
			page = totalPage;
		}
		final int offset = PageBean.countOffset(pageSize, page);
		final int length = pageSize;
		final int currentPage = PageBean.countCurrentPage(page);
		crit.setFirstResult(offset);
		crit.setMaxResults(length);
		List<?> list = crit.list();
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
	
	/**
	 * 使用hibernate的面向对象的hql进行条件查询，返回查询对象集合，语句中使用命名参数
	 * @param hql 面向对象的查询语句
	 * @param paramMap 命名参数名，参数值
	 * @return 符合条件的对象集合
	 */
	public List<?> queryByHql(String hql, Map<String,Object> paramMap) {
		
		Query query = this.getSession().createQuery(hql);
		if (paramMap!=null){
			Set<Entry<String, Object>> set = paramMap.entrySet();
			for (Entry<String, Object> entry : set) {
				String paramName = entry.getKey();
				Object paramValue = entry.getValue();
				query.setParameter(paramName, paramValue);
			}
		}
		return query.list();
		
	}
	
	/**
	 * 使用hibernate的面向对象的hql进行条件查询，返回查询对象集合，语句中使用顺序参数
	 * @param hql 面向对象的查询语句
	 * @param params 与条件hql对应的有序参数集合
	 * @return 符合条件的对象集合
	 */
	public List<?> queryByHql(String hql, List<Object> params) {
		
		Query query = this.getSession().createQuery(hql);
		if (params!=null){
			for (int index=0; index<params.size(); index++) {
				query.setParameter(index, params.get(index));
			}
		}
		return query.list();
		
	}
	
	/**
	 * 返回值唯一属性的查询可用此方法比如查询count(*)、max()、min()等
	 * @param hql 要执行的hal（注意只能返回一个值）
	 * @param params 预编译hql参数（参数列表用键值对封装）
	 * @return 
	 */
	public Object queryUniqueResult(String hql, Map<String,Object> paramMap) {

		Query query = this.getSession().createQuery(hql);
		if (paramMap!=null){
			Set<Entry<String, Object>> set = paramMap.entrySet();
			for (Entry<String, Object> entry : set) {
				String paramName = entry.getKey();
				Object paramValue = entry.getValue();
				query.setParameter(paramName, paramValue);
			}
		}
		return query.uniqueResult();
		
	}
	
	/**
	 * 返回值唯一属性的查询可用此方法比如查询count(*)、max()、min()等
	 * @param hql 要执行的hal（注意只能返回一个值）
	 * @param params 预编译hql参数（根据参数顺序给定的参数列表）
	 * @return 
	 */
	public Object queryUniqueResult(String hql, List<Object> params) {

		Query query = this.getSession().createQuery(hql);
		if(params != null) {
			for(int index=0; index<params.size(); index++) {
				query.setParameter(index, params.get(index));
			}
		}
		return query.uniqueResult();
		
	}
	
	/**
	 * 分页查询，可以带查询参数，返回"List(Object[])"
	 * @param pageSize  页面总数  
	 * @param page   当前页面
	 * @param sql    sql语句
	 * @param params   参数,map形式(参数名，参数值),没有可以置为null
	 * @return PageBean :list=集合中存放的是Object[]，属性顺序和sql的查询结果顺序一致
	 */
	public PageBean queryForPageByParams(int pageSize, int page, String sql,Map<String,Object> params) {
		
		SQLQuery query = getSession().createSQLQuery(sql);
		
		//根据查询sql生存查询总数sql语句
		String sqlCount = "select count(*) from (" + sql.toString() +")";
		SQLQuery queryCount = getSession().createSQLQuery(sqlCount);
		if (params!=null){
			Set<Entry<String, Object>> set = params.entrySet();
			for (Entry<String, Object> entry : set) {
				String paramName = entry.getKey();
				Object paramValue = entry.getValue();
				queryCount.setParameter(paramName, paramValue);
			}
		}
		BigDecimal temp = (BigDecimal) queryCount.uniqueResult();
		
		int allRow = temp.intValue();
		
		//设置参数
		if (params!=null){
			Set<Entry<String, Object>> set = params.entrySet();
			for (Entry<String, Object> entry : set) {
				String paramName = entry.getKey();
				Object paramValue = entry.getValue();
				query.setParameter(paramName, paramValue);
			}
		}
		
		if (pageSize <= 0)
			pageSize = 10;
		int totalPage = PageBean.countTotalPage(pageSize, allRow);
		if (page < 1) {
			page = 1;
		} 
		final int offset = PageBean.countOffset(pageSize, page);
		final int length = pageSize;
		final int currentPage = PageBean.countCurrentPage(page);
		
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List<?> list = query.list();
		
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
