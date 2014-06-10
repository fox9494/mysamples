package com.soarsky.octopus.task.dao;

import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.mapping.TTaskAttribute;

public class TTaskAttributeDAO extends BaseDAO  {

	/**
	 * 根据任务对象删除任务属性
	 * @author lw
	 * @param  taskAttribute  要删除的任务属性对象
	*/
	@SuppressWarnings("unchecked")
	public void deleteTaskAttribute(TTask task) {
		
		Criteria crit=this.getSession().createCriteria(TTaskAttribute.class).createCriteria("TTask").add(Restrictions.eq("taskid", task.getTaskid()));
		
		Iterator<TTaskAttribute>list=crit.list().iterator();
		
		while(list.hasNext()){
			
			this.delete(list.next());
			
		}
	}
	/**
	 * 根据任务查询任务属性
	 * @author lw
	 * @param task 任务对象
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public TTaskAttribute findTaskAttributeByTask(TTask task) {
		
	    Criteria crit=this.getSession().createCriteria(TTaskAttribute.class).createCriteria("TTask").add(Restrictions.eq("taskid", task.getTaskid()));
		
	    Iterator<TTaskAttribute>taskAttributes=crit.list().iterator();
	    while(taskAttributes.hasNext()){
	    	return taskAttributes.next();
	    }
	    
		return null;
	}
}