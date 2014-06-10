package com.soarsky.octopus.task.action;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.task.service.TTaskService;

public class TaskDeleteAction extends BaseAction {

	private static final long serialVersionUID = -2875213136943274071L;
	
	private TTaskService tTaskService;
	
	private TTask task;
	
	private String info;
	
	/**
	 * 删除任务
	 * @author lw
	 * @return
	*/
	public String delete() {
			
	    tTaskService.deleteTask(info);
		
		return SUCCESS;
	}

	public TTaskService gettTaskService() {
		return tTaskService;
	}

	public void settTaskService(TTaskService tTaskService) {
		this.tTaskService = tTaskService;
	}

	public TTask getTask() {
		return task;
	}

	public void setTask(TTask task) {
		this.task = task;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
