package com.cpy.enfm.common.page;

/**
 * mysql物理分页
 * @author chenll
 *
 */
public class Mysql5Dialet implements Dialect {

	@Override
	public String getPageSql(String sql, int offset, int limit) {
		 StringBuilder sb = new StringBuilder();
		 sb.append(sql).append(" limit ").append(offset).append(",").append(limit);
	     return sb.toString();  
	}

}
