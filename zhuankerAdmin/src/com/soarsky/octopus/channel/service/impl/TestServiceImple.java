package com.soarsky.octopus.channel.service.impl;

import com.soarsky.octopus.common.dao.BaseDAO;

/**
 * @author chenll
 *
 * @param <T>
 */
public class TestServiceImple <T extends BaseDAO>{
	
	protected T dao;
	
	
	public void save(Object obj){
		dao.save(obj);
	}

	public T getDao() {
		return dao;
	}

	public void setDao(T dao) {
		this.dao = dao;
	}
	
	
	
	

}
