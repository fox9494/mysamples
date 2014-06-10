package com.soarsky.octopus.task.service;

import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.utils.PageBean;

public interface TTaskService {
    
	/**
	 * 添加任务对象
	 * @param task 要添加的任务对象
	 * @return
	*/
	public TTask addTask(TTask task);
    
	/**
	 * 删除任务对象
	 * @param info 要删除的任务对象
	*/
	public void deleteTask(String info);
	
	/**
	 * 初始化要修改的任务对象
	 * @param task 要修改的任务对象
	 * @return
	*/
	public TTask ininTask(TTask task);
	
	/**
	 * 修改任务对象
	 * @param task 要修改的任务对象
	*/
	public void editTask(TTask task);
	
	/**
	 * 更新过期任务
	 */
	public void updateExpire();
	
	/**
	 * 分页得到所有任务对象列表
	 * @param maxresult 每页最大条数
	 * @param currentPage 当前页数
	 * @return
	*/
	public PageBean getTaskList(int maxresult,int currentPage);
    
	/**
	 * 根据条件分页查询所有任务对象列表
	 * @param maxresult 每页最大条数
	 * @param currentPage 当前页数
	 * @param task 任务对象(里面封装了条件)
	 * @return
	*/
	public PageBean getTaskListByConditions(int maxresult,int currentPage, TTask task);

	/**
	 * 分页查询所有未审核的任务对象列表
	 * @param  maxresult 每页最大条数
	 * @param currentPage 当前页数
	 * @return
	*/
	public PageBean getTaskWaitingList(int maxresult, int currentPage);
     
	/**
	 * 审核任务
	 * @param info 要进行审核的任务ID
	*/
	public void approveTask(String info);
    
	/**
	 * 根据任务查找渠道信息
	 * @param task 任务对象
	 * @return
	*/
	public TTask searchChannelDetails(TTask task);
    
	/**
	 * 根据任务名查找任务
	 * @param task 任务对象
	 * @return
	*/
	public Boolean findTaskByName(TTask task);
}
