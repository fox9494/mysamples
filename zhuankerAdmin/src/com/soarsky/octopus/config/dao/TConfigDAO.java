package com.soarsky.octopus.config.dao;

import java.util.List;

import org.hibernate.Criteria;

import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TConfig;

public class TConfigDAO extends BaseDAO {

	public  List<TConfig> findAll() {
		Criteria cri = this.getSession().createCriteria(TConfig.class);
		cri.setCacheable(true);
		return cri.list();
	}
	
	
	

}
