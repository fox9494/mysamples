package com.soarsky.octopus.task.service;

import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TTask;

public interface TApplicationService {
	
	/**
	 * 添加应用
	 * @param application 要添加的应用对象
	 * @return
	*/
	public TApplication  addApplication(TApplication application);
    
	/**
	 * 初始化要修改的应用对象
	 * @param application 要修改的应用对象
	 * @return
	*/
	public TApplication initApplication(TApplication application);
	
	/**
	 * 修改应用对象
	 * @param application 修改的应用对象
	*/
	public void editApplication(TApplication application);

	/**
	 * 根据任务对象查找应用对象
	 * @param 任务对象
	 * @return
	*/
	public TApplication findApplicationByTask(TTask task);
}
