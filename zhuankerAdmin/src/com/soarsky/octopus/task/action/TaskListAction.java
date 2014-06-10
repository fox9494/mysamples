package com.soarsky.octopus.task.action;



import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.task.service.TTaskService;
import com.soarsky.octopus.utils.PageBean;

public class TaskListAction extends PageAction {

	private static final long serialVersionUID = -445523303946199729L;
    
	private TTaskService tTaskService;
	
	private TTask task;
	
	/**
	 * 分页查询所有任务信息
	 * @author lw
	 * @return
	 */
	public String searchList() {
		
		pageBean=tTaskService.getTaskList(PageBean.DEFAULTPAGESIZE, currentPage);
		
		return SUCCESS;
	}
	
	/**
	 * 根据条件查询任务
	 * @author lw
	 * @return
	*/
	public String searchListByConditions(){
		
		pageBean=tTaskService.getTaskListByConditions(PageBean.DEFAULTPAGESIZE,currentPage,task);
		
		return "findbyconditions";
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
}
