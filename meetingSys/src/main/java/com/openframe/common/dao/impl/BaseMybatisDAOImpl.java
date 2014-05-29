package com.openframe.common.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;

import com.openframe.common.dao.BaseMybatisDAO;
import com.openframe.common.page.PageBean;

public abstract class BaseMybatisDAOImpl<T> implements  BaseMybatisDAO<T> {
	
	/**
	 * 默认注入可重用的sqlSessionTemplate
	 */
	@Autowired 
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSessionTemplate;
	
	@Autowired //根据类型自动装配
	@Qualifier("sqlSessionTemplateBatch")//更细粒度控制，根据名字
	/**
	 * 使用批处理无法获取自增id,一个事务中不能同时使用两个不同SqlSessionTemplate
	 */
	private SqlSession sqlSessionTemplateBatch;
	
	public static final String INSERT="insert";
	
	public static final String UPDATE="updateById";
	
	public static final String DELETE="deleteById";
	
	public static final String SELECT="selectById";
	
	public static final String SELECTALL="selectAll";
	
	public static final String SELECTCOUNT="selectcount";
	
	public static final String SELECTPAGE="pagequery";
	
	
	/**
	 * 获取mybatis执行语句id
	 * 要求只能实现一个接口
	 * @param mapperId 映射语句id
	 * @return
	 */
	protected String getStatement(String mapperId){
		String result="";
		Class<?>[] clazz = this.getClass().getInterfaces();
		if (clazz.length>0){
			result= clazz[0].getName()+"."+mapperId;
		}
		return result;
	}
	
	/**
	 * 批量添加
	 * @param list
	 */
	public void batchInsert(List<T> list){
		if (!CollectionUtils.isEmpty(list)){
			for (T t : list) {
				sqlSessionTemplateBatch.insert(this.getStatement(INSERT), t);
			}
		}
		
	}
	
	public T selectById(Object parameter){
		return sqlSessionTemplate.selectOne(this.getStatement(SELECT), parameter);
	}
	
	public int deleteById(Object parameter){
		return sqlSessionTemplate.delete(this.getStatement(DELETE), parameter);
	}
	
	public int insert(T parameter){
		return sqlSessionTemplate.insert(this.getStatement(INSERT), parameter);
	}
	
	public int updateById(Object parameter){
		return sqlSessionTemplate.update(this.getStatement(UPDATE), parameter);
	}
	
	public List<T> selectAll(){
		return sqlSessionTemplate.selectList(this.getStatement(SELECTALL), null);
	}
	
	
	/**
	 * 分页查询
	 */
	public PageBean queryPage(PageBean pageObj){
	  //查询数量
	  long count = sqlSessionTemplate.selectOne(this.getStatement(SELECTCOUNT),pageObj.getCondition());
	  
	  //查询数据	
	  List<T> resultList = sqlSessionTemplate.selectList(this.getStatement(SELECTPAGE), pageObj.getCondition(), new RowBounds(PageBean.countOffset(pageObj.getPageSize(), pageObj.getCurrentPage()),pageObj.getPageSize()));
	
	  PageBean result = new PageBean();
	  result.setList(resultList);
	  result.setRowCount(count);
	  result.setCondition(pageObj.getCondition());
	  result.setPageSize(pageObj.getPageSize());
	  result.setCurrentPage(pageObj.getCurrentPage());
	  return result;
		
	}

	

}
