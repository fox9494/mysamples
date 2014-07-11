package com.cpy.enfm.common.entity;


public class MybatisExample {

	protected String orderByClause;

	protected boolean distinct;

	

	public MybatisExample() {
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}


	

}