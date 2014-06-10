package com.soarsky.octopus.clientuser.service.impl;

import com.soarsky.octopus.clientuser.dao.TClientLoginLogDAO;
import com.soarsky.octopus.clientuser.service.TClientLoginLogService;

public class TClientLoginLogServiceImpl implements TClientLoginLogService {
	
	private TClientLoginLogDAO tClientLoginLogDAO;

	public TClientLoginLogDAO gettClientLoginLogDAO() {
		return tClientLoginLogDAO;
	}

	public void settClientLoginLogDAO(TClientLoginLogDAO tClientLoginLogDAO) {
		this.tClientLoginLogDAO = tClientLoginLogDAO;
	}
    
	
}
