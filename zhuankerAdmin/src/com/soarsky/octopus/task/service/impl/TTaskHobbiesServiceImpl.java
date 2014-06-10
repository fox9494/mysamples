package com.soarsky.octopus.task.service.impl;

import java.util.List;

import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.mapping.TTaskHobbies;
import com.soarsky.octopus.task.dao.TTaskHobbiesDAO;
import com.soarsky.octopus.task.service.TTaskHobbiesService;

public class TTaskHobbiesServiceImpl implements TTaskHobbiesService{
	
	private TTaskHobbiesDAO tTaskHobbiesDAO;
    
	
	/**
	 * 添加任务爱好
	 * @author lw
	 * @param  taskHobbies  要添加的任务爱好对象
	*/
	public void addTaskHobbies(TTaskHobbies taskHobbies) {
		
		tTaskHobbiesDAO.save(taskHobbies);
	}
    
	/**
	 * 根据任务对象删除任务爱好
	 * @author lw
	 * @param  task  任务对象
	*/
	public void deleteTaskHobbies(TTask task) {
		
		tTaskHobbiesDAO.deleteTaskHobbies(task);
	}

	/**
	 * 根据任务查询该任务爱好所对应的所有爱好ID
	 * @author lw
	 * @param task 任务对象
	 * @return
	*/
	public List<String> findHobbiesByTask(TTask task) {
		
		return tTaskHobbiesDAO.findHobbiesByTask(task);
	}

	public TTaskHobbiesDAO gettTaskHobbiesDAO() {
		return tTaskHobbiesDAO;
	}

	public void settTaskHobbiesDAO(TTaskHobbiesDAO tTaskHobbiesDAO) {
		this.tTaskHobbiesDAO = tTaskHobbiesDAO;
	}

}
