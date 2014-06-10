package com.soarsky.octopus.task.service;

import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.mapping.TTaskAttribute;

public interface TTaskAttributeService {
    
	/**
	 * 添加任务属性
	 * @param taskAttribute 属性对象
	*/
	public void addTaskAttribute(TTaskAttribute taskAttribute);
	
	/**
	 * 根据任务删除任务属性
	 * @param task 任务对象
	*/
	public void deleteTaskAttribute(TTask task);
	
	/**
	 * 根据任务查询任务属性
	 * @param task 任务对象
	 * @return
	*/
	public TTaskAttribute findTaskAttributeByTask(TTask task);
}
