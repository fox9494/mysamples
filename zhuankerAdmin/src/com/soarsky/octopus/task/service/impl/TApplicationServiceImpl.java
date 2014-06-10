package com.soarsky.octopus.task.service.impl;

import java.util.Set;

import com.soarsky.octopus.mapping.TAppImage;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.task.dao.TApplicationDAO;
import com.soarsky.octopus.task.service.TApplicationService;

public class TApplicationServiceImpl implements TApplicationService {
      
	private TApplicationDAO tApplicationDAO;
    
	
	/**
	 * 添加应用
	 * @author lw
	 * @param  application 要添加的应用对象
	*/
	public TApplication addApplication(TApplication application) {
		
		tApplicationDAO.save(application);
	
		return application;
	}
    
	/**
	 * 根据Id查找应用
	 * @author lw
	 * @param  application 要添加的应用对象
	 * @return
	*/
	@SuppressWarnings({"unchecked","unused"})
	public TApplication initApplication(TApplication application) {
		
		TApplication app=tApplicationDAO.getById(TApplication.class, application.getAppid());
	
		Set<TAppImage>imgs=app.gettAppImages();//延迟加载应用图片
		for(TAppImage appImg:imgs){
			
		}
		
		return app;
	}
	
	/**
	 * 修改应用
	 * @author lw
	 * @param  application 要添加的应用对象
	*/
	public void editApplication(TApplication application) {
		
		tApplicationDAO.updateApplication(application);
	}

	/**
	 * 根据任务对象查找应用对象
	 * @author lw
	 * @param 任务对象
	 * @return
	*/
	@SuppressWarnings({ "unchecked", "unused" })
	public TApplication findApplicationByTask(TTask task) {
		
		TApplication app=tApplicationDAO.findAppByTask(task);
		if(app!=null){
			Set<TAppImage>imgs=app.gettAppImages();
			for(TAppImage img:imgs){//延迟加载应用图片
			}
		}
		return app;
	}

	public TApplicationDAO gettApplicationDAO() {
		return tApplicationDAO;
	}

	public void settApplicationDAO(TApplicationDAO tApplicationDAO) {
		this.tApplicationDAO = tApplicationDAO;
	}
	
	
}
