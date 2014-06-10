package com.soarsky.octopus.task.action;

import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.task.service.TTaskService;
import com.soarsky.octopus.utils.PageBean;

public class TaskApproveAction extends PageAction{
      
	private static final long serialVersionUID = 3875540043821705892L;

	private TTaskService tTaskService; 
	
	private String info;
   
	/**
	 * 得到所有未审核的任务列表
	 * @author lw
	 * @return
	*/
	public String searchList(){
		
		pageBean=tTaskService.getTaskWaitingList(PageBean.DEFAULTPAGESIZE, currentPage);
		
		return SUCCESS;
	}
	
	/**
	 * 审核任务
	 * @author lw
	 * @return
	*/
	public String approveTask(){
		
	    tTaskService.approveTask(info);
			
		return "approvesuccess";
	}
	
	public TTaskService gettTaskService() {
		return tTaskService;
	}

	public void settTaskService(TTaskService tTaskService) {
		this.tTaskService = tTaskService;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
