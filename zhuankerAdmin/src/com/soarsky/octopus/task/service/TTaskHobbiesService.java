package com.soarsky.octopus.task.service;

import java.util.List;

import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.mapping.TTaskHobbies;

public interface TTaskHobbiesService {
	
	/**
	 * 添加任务爱好
	 * @param taskHobbies 任务爱好对象
	*/
	public void addTaskHobbies(TTaskHobbies taskHobbies);
    
	/**
	 * 根据任务删除任务爱好
	 * @param task 任务对象
	*/
	public void deleteTaskHobbies(TTask task);
	
	/**
	 * 根据任务查询该任务爱好所对应的所有爱好ID
	 * @param task 任务对象
	 * @return
	*/
	public List<String> findHobbiesByTask(TTask task);
}
