package com.soarsky.octopus.task.service;

import java.util.List;

import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.mapping.TTaskChannel;

public interface TTaskChannelService {
    
	/**
	 * 添加任务渠道
	 * @param taskChannel 渠道对象
	*/
	public void addTaskChannel(TTaskChannel taskChannel);
	
	/**
	 * 根据任务删除渠道
	 * @param task 任务对象
	*/
	public void deleteTaskChannel(TTask task);
	
	/**
	 * 根据任务查找所有任务渠道
	 * @param task 任务对象
	 * @return
	*/
	public List<TTaskChannel>findTaskChannels(TTask task);
}
