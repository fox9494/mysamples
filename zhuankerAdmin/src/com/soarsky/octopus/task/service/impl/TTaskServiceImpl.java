package com.soarsky.octopus.task.service.impl;

import java.util.Set;

import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.mapping.TTaskAttribute;
import com.soarsky.octopus.mapping.TTaskChannel;
import com.soarsky.octopus.mapping.TTaskHobbies;
import com.soarsky.octopus.task.dao.TTaskDAO;
import com.soarsky.octopus.task.service.TTaskService;
import com.soarsky.octopus.utils.PageBean;

public class TTaskServiceImpl implements TTaskService {
	
	private TTaskDAO tTaskDAO;
    
	/**
	 *添加任务
	 *@author lw
	 *@param  task  要添加的任务对象 
	 *@return
	 */
	public TTask addTask(TTask task) {
		
		tTaskDAO.save(task);
		
		return task;
	}

	/**
	 *删除任务信息
	 *@author lw
	 *@param  info 要删除的任务id集合
	 */
	public void deleteTask(String info) {
		
		tTaskDAO.deleteTask(info);
	}
	
	/**
	 * 更新过期任务
	 */
	public void updateExpire(){
		tTaskDAO.updateExpire();
	}

    /**
     *初始化要修改的任务对象
     *@author lw
     *@param  task  要初始化的任务对象  
     *@return
	 */
	public TTask ininTask(TTask task) {
		
		return tTaskDAO.getById(TTask.class, task.getTaskid());
	}
    
	/**
	 * 修改任务信息
	 * @author lw
	 * @param  task  要修改的任务对象  
	*/
	public void editTask(TTask task) {
		
		tTaskDAO.updateTask(task);
	}

    
	/**
	 * 分页查询所有任务信息
	 * @author lw
	 * @param  maxresult  每页最大条数
	 * @param  currentPage  当前页数
	 * @return
	*/
	public PageBean getTaskList(int maxresult, int currentPage) {
		
		return tTaskDAO.findAllTask(maxresult,currentPage);
	}
	
	/**
	 * 分页查询所有任务信息
	 * @author lw
	 * @param  maxresult  每页最大条数
	 * @param  currentPage  当前页数
	 * @param  task 任务对象
	 * @return
	*/
	public PageBean getTaskListByConditions(int maxresult, int currentPage,TTask task) {
		
		return tTaskDAO.findAllTaskByConditions(maxresult,currentPage,task);
	}
    
	/**
	 * 分页查询所有未审核的任务对象列表
	 * @author lw
	 * @param  maxresult 每页最大条数
	 * @param currentPage 当前页数
	 * @return
	*/
	public PageBean getTaskWaitingList(int maxresult, int currentPage) {
	
		return tTaskDAO.findAllWaitingTask(maxresult,currentPage);
	}
	
	/**
	 * 审核任务
	 * @author lw
	 * @param info 要进行审核的任务ID
	*/
	public void approveTask(String info) {
			
		tTaskDAO.approveTask(info);
	}
    
	/**
	 * 根据任务查找渠道信息
	 * @author lw
	 * @param task 任务对象
	 * @return
	*/
	@SuppressWarnings({ "unchecked", "unused" })
	public TTask searchChannelDetails(TTask task) {
		
        TTask taskDetails=tTaskDAO.getById(TTask.class, task.getTaskid());
		
		if(taskDetails!=null){
			Set<TTaskAttribute> attrs = taskDetails.getTTaskAttributes();
		    for(TTaskAttribute taskAttr:attrs){//此循环为了延迟加载任务属性对象
		    	
		    }
		    
		    Set<TTaskChannel> channels = taskDetails.getTTaskChannels();
		    for(TTaskChannel taskChannel:channels){//此循环为了延迟加载任务渠道对象
		        TChannel channel=taskChannel.getTChannel();
		        channel.getChannelName();//延迟加载渠道名称
		    }
		    
		    Set<TTaskHobbies> hobbies = taskDetails.getTTaskHobbieses();
		    for(TTaskHobbies taskHobbies:hobbies){//此循环为了延迟加载任务爱好对象
		    	THobbies hobbie=taskHobbies.getTHobbies();
		    	hobbie.getTagname();//延迟加载爱好
		    }
		}
		
		return taskDetails;
	}
    
	/**
	 * 根据任务名查找任务
	 * @author lw
	 * @param task 任务对象
	 * @return
	*/
	public Boolean findTaskByName(TTask task) {
		
		return tTaskDAO.findTaskByName(task);
	}

	public TTaskDAO gettTaskDAO() {
		return tTaskDAO;
	}

	public void settTaskDAO(TTaskDAO tTaskDAO) {
		this.tTaskDAO = tTaskDAO;
	}

}
