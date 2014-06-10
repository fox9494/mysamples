package com.soarsky.octopus.game.service.impl;

import com.soarsky.octopus.game.dao.TGameDAO;
import com.soarsky.octopus.game.service.TGameService;

public class TGameServiceImpl implements TGameService {
	
    private TGameDAO tGameDAO;

	public TGameDAO gettGameDAO() {
		return tGameDAO;
	}

	public void settGameDAO(TGameDAO tGameDAO) {
		this.tGameDAO = tGameDAO;
	}
    
}
