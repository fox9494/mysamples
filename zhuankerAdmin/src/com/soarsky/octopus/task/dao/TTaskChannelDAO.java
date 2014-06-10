package com.soarsky.octopus.task.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.mapping.TTaskChannel;

public class TTaskChannelDAO extends BaseDAO  {

	
	/**
	 * 根据任务对象删除任务渠道
	 * @author lw
	 * @param  task 任务对象
	*/
	@SuppressWarnings("unchecked")
	public void deleteTaskChannel(TTask task) {
		
        Criteria crit=this.getSession().createCriteria(TTaskChannel.class).createCriteria("TTask").add(Restrictions.eq("taskid", task.getTaskid()));
		
		Iterator<TTaskChannel>list=crit.list().iterator();
		
		while(list.hasNext()){
			
			this.delete(list.next());
			
		}
	}
    
	/**
	 * 根据任务查找所有任务渠道
	 * @author lw
	 * @param task 任务对象
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public List<TTaskChannel> findAllTaskChannel(TTask task) {
		
		Criteria crit=this.getSession().createCriteria(TTaskChannel.class).createCriteria("TTask").add(Restrictions.eq("taskid", task.getTaskid()));
		List<TTaskChannel>taskChannels=crit.list();
		
		for(TTaskChannel tc:taskChannels){
			TChannel channel=tc.getTChannel();//延迟加载渠道
			channel.getId();
		}
		return taskChannels;
	}
	
	
}