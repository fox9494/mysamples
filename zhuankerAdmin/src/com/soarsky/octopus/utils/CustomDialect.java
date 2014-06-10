package com.soarsky.octopus.utils;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQL5Dialect;

public class CustomDialect extends MySQL5Dialect {

	public CustomDialect() {
		super();
		
		// This maps a TEXT column to a String.
		// May be bogus
		// http://stackoverflow.com/questions/7192190/hibernate-sql-query-problem-with-text-data-type-in-mysql
		registerHibernateType(-1,Hibernate.STRING.getName());
	}
}
