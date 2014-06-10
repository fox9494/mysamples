package com.soarsky.octopus.task.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.mapping.TTaskHobbies;

public class TTaskHobbiesDAO extends BaseDAO  {
	
	/**
	 * 根据任务对象删除任务爱好
	 * @author lw
	 * @param  task  任务对象
	*/
	@SuppressWarnings("unchecked")
	public void deleteTaskHobbies(TTask task) {
		
		 Criteria crit=this.getSession().createCriteria(TTaskHobbies.class).createCriteria("TTask").add(Restrictions.eq("taskid", task.getTaskid()));
			
		Iterator<TTaskHobbies>list=crit.list().iterator();
			
		while(list.hasNext()){
				
			this.delete(list.next());
				
		}
	}

	@SuppressWarnings("unchecked")
	public List<String> findHobbiesByTask(TTask task) {
		
		List<String>taskHobbiesids=new ArrayList<String>();
		
		Criteria crit=this.getSession().createCriteria(TTaskHobbies.class).createCriteria("TTask").add(Restrictions.eq("taskid", task.getTaskid()));
		
		Iterator<TTaskHobbies>taskHobbies=crit.list().iterator();
		while(taskHobbies.hasNext()){ 
			THobbies hobbies=taskHobbies.next().getTHobbies();
			taskHobbiesids.add(hobbies.getHobbiesid().toString());
		}
		return taskHobbiesids;
	}
	
	
}