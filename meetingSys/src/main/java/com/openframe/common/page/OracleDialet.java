package com.openframe.common.page;

/**
 * oracle分页语句
 * @author chenll
 *
 */
public class OracleDialet implements Dialect {

	@Override
	public String getPageSql(String sql, int offset, int limit) {
		sql = sql.trim();  
        StringBuffer pageSql = new StringBuffer(sql.length() + 100);  
        pageSql.append("select * from ( select row_.*, rownum rownum_ from ( ");  
        pageSql.append(sql);  
        pageSql.append(" ) row_ ) where rownum_ > " + offset + " and rownum_ <= " + (offset + limit));  
        return pageSql.toString();  
		
	}

}
