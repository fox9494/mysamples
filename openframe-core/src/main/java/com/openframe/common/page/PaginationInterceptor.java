package com.openframe.common.page;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import com.openframe.common.page.Dialect.DataBaseType;

/**
 * mybatis拦截器
 * 用于拦截sql语句，生成物理分页的sql语句
 * 参数中带有rowbound才生成物理分页
 * @author chenll
 *
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PaginationInterceptor implements Interceptor {
	
	private final Logger logger = Logger.getLogger(PaginationInterceptor.class);
	
	private String dialect="";//通过配置文件注入
	
	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();  
	    MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,DEFAULT_OBJECT_FACTORY,DEFAULT_OBJECT_WRAPPER_FACTORY);
	     
	    RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");  
        if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {  
            return invocation.proceed();  
        }  
        DataBaseType databaseType = Dialect.DataBaseType.valueOf(dialect) ;
		Dialect dialectObject = null;  
		switch (databaseType) {  
        case MYSQL:  
        	dialectObject = new Mysql5Dialet();  
            break;  
        case ORACLE:  
        	dialectObject = new OracleDialet();  
            break;  
        default:  
        	dialectObject = new Mysql5Dialet();  
        }  
		
        String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");  //原始sql语句
        String sql = dialectObject.getPageSql(originalSql, rowBounds.getOffset(),rowBounds.getLimit());//新物理sql语句
        metaStatementHandler.setValue("delegate.boundSql.sql", sql);  
        metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);  
        metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);  
		logger.debug("SQL: [ "+sql.toString()+" ]");
		return invocation.proceed();
       
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {

	}

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

}
