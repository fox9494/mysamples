package com.soarsky.octopus.clientuser.service.impl;

import com.soarsky.octopus.clientuser.dao.TUserPositionDAO;
import com.soarsky.octopus.clientuser.service.TUserPositionService;

public class TUserPositionServiceImpl implements TUserPositionService {
	
	private TUserPositionDAO tUserPositionDAO;

	public TUserPositionDAO gettUserPositionDAO() {
		return tUserPositionDAO;
	}

	public void settUserPositionDAO(TUserPositionDAO tUserPositionDAO) {
		this.tUserPositionDAO = tUserPositionDAO;
	}

}
