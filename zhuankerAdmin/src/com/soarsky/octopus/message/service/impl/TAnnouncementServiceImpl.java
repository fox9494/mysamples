package com.soarsky.octopus.message.service.impl;

import com.soarsky.octopus.message.dao.TAnnouncementDAO;
import com.soarsky.octopus.message.service.TAnnouncementService;

public class TAnnouncementServiceImpl implements TAnnouncementService {
	
	private TAnnouncementDAO  tAnnouncementDAO;

	public TAnnouncementDAO gettAnnouncementDAO() {
		return tAnnouncementDAO;
	}

	public void settAnnouncementDAO(TAnnouncementDAO tAnnouncementDAO) {
		this.tAnnouncementDAO = tAnnouncementDAO;
	}
	
	
}
