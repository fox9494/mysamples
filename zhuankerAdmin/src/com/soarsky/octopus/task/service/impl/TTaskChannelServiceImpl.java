package com.soarsky.octopus.task.service.impl;

import java.util.List;

import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.mapping.TTaskChannel;
import com.soarsky.octopus.task.dao.TTaskChannelDAO;
import com.soarsky.octopus.task.service.TTaskChannelService;

public class TTaskChannelServiceImpl implements TTaskChannelService {
	
	private TTaskChannelDAO tTaskChannelDAO;
    
	
	/**
	 * 添加任务渠道
	 * @author lw
	 * @param  taskChannel 要添加的任务渠道对象
	*/
	public void addTaskChannel(TTaskChannel taskChannel) {
		
		tTaskChannelDAO.save(taskChannel);
	}
   
	/**
	 * 根据任务对象删除任务渠道
	 * @author lw
	 * @param  task 任务对象
	*/
	public void deleteTaskChannel(TTask task) {
		
		tTaskChannelDAO.deleteTaskChannel(task);
	}
    
	/**
	 * 根据任务查找所有任务渠道
	 * @author lw
	 * @param task 任务对象
	 * @return
	*/
	public List<TTaskChannel> findTaskChannels(TTask task) {
		
		return tTaskChannelDAO.findAllTaskChannel(task);
	}

	public TTaskChannelDAO gettTaskChannelDAO() {
		return tTaskChannelDAO;
	}

	public void settTaskChannelDAO(TTaskChannelDAO tTaskChannelDAO) {
		this.tTaskChannelDAO = tTaskChannelDAO;
	}

}
