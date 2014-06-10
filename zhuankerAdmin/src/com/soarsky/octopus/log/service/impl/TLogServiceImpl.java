package com.soarsky.octopus.log.service.impl;

import com.soarsky.octopus.log.dao.TLogDAO;
import com.soarsky.octopus.log.service.TLogService;
import com.soarsky.octopus.mapping.TLog;

public class TLogServiceImpl implements TLogService {
	
	private TLogDAO tLogDAO;
	

	@Override
	public void save(TLog tlog) {
		tLogDAO.save(tlog);
	}
	
	
	public TLogDAO gettLogDAO() {
		return tLogDAO;
	}

	public void settLogDAO(TLogDAO tLogDAO) {
		this.tLogDAO = tLogDAO;
	}

}
