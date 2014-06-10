package com.soarsky.octopus.task.service.impl;

import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.mapping.TTaskAttribute;
import com.soarsky.octopus.task.dao.TTaskAttributeDAO;
import com.soarsky.octopus.task.service.TTaskAttributeService;

public class TTaskAttributeServiceImpl implements TTaskAttributeService {
	
	private TTaskAttributeDAO tTaskAttributeDAO;
    
	
	/**
	 * 添加任务属性
	 * @author lw
	 * @param  taskAttribute  要添加的任务属性对象
	*/
	public void addTaskAttribute(TTaskAttribute taskAttribute) {
		
		tTaskAttributeDAO.save(taskAttribute);
	}
    

	/**
	 * 根据任务对象删除任务属性
	 * @author lw
	 * @param  task 任务对象
	*/
	public void deleteTaskAttribute(TTask task) {
		
		tTaskAttributeDAO.deleteTaskAttribute(task);
	}
	
	/**
	 * 根据任务查询任务属性
	 * @author lw
	 * @param task 任务对象
	 * @return
	*/
	public TTaskAttribute findTaskAttributeByTask(TTask task) {
		
		return tTaskAttributeDAO.findTaskAttributeByTask(task);
	}


	public TTaskAttributeDAO gettTaskAttributeDAO() {
		return tTaskAttributeDAO;
	}

	public void settTaskAttributeDAO(TTaskAttributeDAO tTaskAttributeDAO) {
		this.tTaskAttributeDAO = tTaskAttributeDAO;
	}

}
