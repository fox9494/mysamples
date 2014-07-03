package com.cpy.enfm.common.page;

/**
 * 数据库方言接口
 * @author chenll
 *
 */
public interface Dialect {
	
	public static enum DataBaseType{
		MYSQL, MSSQL, ORACLE 
	}
	
	/** 
     * @descrption 获取分页SQL 
     * @author chenll 
     * @param sql 原始查询SQL 
     * @param offset 开始记录索引（从零开始） 
     * @param limit 每页记录大小 
     * @return 返回数据库相关的分页SQL语句 
     */  
    public abstract String getPageSql(String sql, int offset, int limit);  

}
