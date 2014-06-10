package com.soarsky.octopus.payment.vo;

/**
 * 用于后台服务器与页面通信时任务简要信息：id和名字
 * @author ouyang
 *
 */
public class Task {
	
    private Long taskId;    //任务taskid号
    private String name;//任务名字
    
	public Task() {
		super();
	}
	/**
	 * 初始化任务taskid号和名字
	 * @param taskid
	 * @param name
	 */
	public Task(Long taskId, String name) {
		super();
		this.taskId = taskId;
		this.name = name;
	}
	
	/**
	 * 获取任务taskid号
	 * @return 任务taskid号
	 */
	public Long getTaskId() {
		return taskId;
	}
	/**
	 * 设定任务taskid号
	 * @param taskid 任务taskid号
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	/**
	 * 获取任务名字
	 * @return 任务名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设定任务名字
	 * @param name任务名字
	 */
	public void setName(String name) {
		this.name = name;
	}

}
