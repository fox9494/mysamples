package com.soarsky.octopus.task.service.impl;

import java.util.List;

import com.soarsky.octopus.mapping.TAppImage;
import com.soarsky.octopus.task.dao.TAppImageDAO;
import com.soarsky.octopus.task.service.TAppImageService;

public class TAppImageServiceImpl implements TAppImageService{
    
	private TAppImageDAO tAppImageDAO;
	
	/**
	 * 批量修改应用图片
	 * @author lw
	 * @param imgs 图片集合
    */
	public void editAppImg(List<TAppImage> imgs) {
		
		tAppImageDAO.batchMerger(imgs);
	}

	public TAppImageDAO gettAppImageDAO() {
		return tAppImageDAO;
	}

	public void settAppImageDAO(TAppImageDAO tAppImageDAO) {
		this.tAppImageDAO = tAppImageDAO;
	}
	 
	 
}