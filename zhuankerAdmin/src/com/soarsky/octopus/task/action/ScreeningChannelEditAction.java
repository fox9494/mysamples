package com.soarsky.octopus.task.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.clientuser.service.TAreaService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TArea;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.mapping.TTaskAttribute;
import com.soarsky.octopus.mapping.TTaskChannel;
import com.soarsky.octopus.mapping.TTaskHobbies;
import com.soarsky.octopus.task.service.TTaskAttributeService;
import com.soarsky.octopus.task.service.TTaskChannelService;
import com.soarsky.octopus.task.service.TTaskHobbiesService;
import com.soarsky.octopus.task.service.TTaskService;

public class ScreeningChannelEditAction extends BaseAction {

	private static final long serialVersionUID = 298580638746266774L;
	
	private TTaskService tTaskService;
	
	private TChannelService tChannelService;
	
    private TTaskAttributeService  tTaskAttributeService;
	
	private TTaskHobbiesService  tTaskHobbiesService;
	
	private TTaskChannelService  tTaskChannelService;
	
	private TAreaService tAreaService;
    
	private TTask task;
	
	private TTaskAttribute taskAttribute;
	    
	private List<THobbies> hobbies;
	
	private List<TTaskChannel>taskChannels;
	
	private List<String>taskHobbiesids;//爱好id
	
	private List<String>taskChannelids=new ArrayList<String>();//渠道id
	
	private TArea province;//省
	    
	private String info;
	
	public String editChannel(){
		
	    tTaskChannelService.deleteTaskChannel(task);//删除任务渠道
				
        tTaskHobbiesService.deleteTaskHobbies(task);//删除任务爱好
	
        tTaskAttributeService.deleteTaskAttribute(task);//删除任务属性
	
        if(taskAttribute.getAreaId()!=null||taskAttribute.getSex()!=null||taskAttribute.getStartAge()!=null||taskAttribute.getEndAge()!=null){
    	   taskAttribute.setTTask(task);
     	   tTaskAttributeService.addTaskAttribute(taskAttribute);//修改任务属性
        }
        
    	String[]id=info.split(",");
    	if(id.length>0){
    	 for(int i=0;i<id.length;i++){
    	   if(StringUtils.isNotEmpty(id[i])){
            TChannel initChannel=new TChannel();
    		initChannel.setId(Long.valueOf(id[i]));
    		TChannel channel=tChannelService.initChannel(initChannel);
    		TTaskChannel taskChannel=new TTaskChannel();//封装任务渠道对象
    		taskChannel.setTTask(task);
    		taskChannel.setTChannel(channel);
    		tTaskChannelService.addTaskChannel(taskChannel);//添加任务渠道
    	   }
    	 }
    	}
    	
    	if(hobbies!=null&&hobbies.size()>0){
    	  for(THobbies hobbi:hobbies){
    		TTaskHobbies  taskHobbie=new TTaskHobbies();
    		taskHobbie.setTHobbies(hobbi);
    		taskHobbie.setTTask(task);
    		tTaskHobbiesService.addTaskHobbies(taskHobbie);//修改任务爱好
    	  }
    	  
    	}
        
		return SUCCESS;
	}
	
	/**
     * 初始化渠道筛选
     * @author lw
     * @return
    */
    public String initChannel(){
    	//初始化任务渠道
    	taskChannels=tTaskChannelService.findTaskChannels(task);
    	for(TTaskChannel tc:taskChannels){
    		taskChannelids.add(tc.getTChannel().getId().toString().trim());
    	}
    	
    	//初始化任务属性
    	taskAttribute=tTaskAttributeService.findTaskAttributeByTask(task);
    	if(taskAttribute!=null){
	    	if(taskAttribute.getAreaId()!=null){
	    		province=tAreaService.findAreaByAreaId(taskAttribute.getAreaId());
	    	}
    	}
    	
    	//初始化任务爱好
    	taskHobbiesids=tTaskHobbiesService.findHobbiesByTask(task);
    	
    	return "initsuccess";
    }

	public TTask getTask() {
		return task;
	}

	public void setTask(TTask task) {
		this.task = task;
	}

	public TTaskService gettTaskService() {
		return tTaskService;
	}

	public void settTaskService(TTaskService tTaskService) {
		this.tTaskService = tTaskService;
	}

	public TTaskAttribute getTaskAttribute() {
		return taskAttribute;
	}

	public void setTaskAttribute(TTaskAttribute taskAttribute) {
		this.taskAttribute = taskAttribute;
	}

	public List<THobbies> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<THobbies> hobbies) {
		this.hobbies = hobbies;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public TChannelService gettChannelService() {
		return tChannelService;
	}

	public void settChannelService(TChannelService tChannelService) {
		this.tChannelService = tChannelService;
	}

	public TTaskAttributeService gettTaskAttributeService() {
		return tTaskAttributeService;
	}

	public void settTaskAttributeService(TTaskAttributeService tTaskAttributeService) {
		this.tTaskAttributeService = tTaskAttributeService;
	}

	public TTaskHobbiesService gettTaskHobbiesService() {
		return tTaskHobbiesService;
	}

	public void settTaskHobbiesService(TTaskHobbiesService tTaskHobbiesService) {
		this.tTaskHobbiesService = tTaskHobbiesService;
	}

	public TTaskChannelService gettTaskChannelService() {
		return tTaskChannelService;
	}

	public void settTaskChannelService(TTaskChannelService tTaskChannelService) {
		this.tTaskChannelService = tTaskChannelService;
	}

	public List<TTaskChannel> getTaskChannels() {
		return taskChannels;
	}

	public void setTaskChannels(List<TTaskChannel> taskChannels) {
		this.taskChannels = taskChannels;
	}

	public List<String> getTaskChannelids() {
		return taskChannelids;
	}

	public void setTaskChannelids(List<String> taskChannelids) {
		this.taskChannelids = taskChannelids;
	}

	public TArea getProvince() {
		return province;
	}

	public void setProvince(TArea province) {
		this.province = province;
	}

	public TAreaService gettAreaService() {
		return tAreaService;
	}

	public void settAreaService(TAreaService tAreaService) {
		this.tAreaService = tAreaService;
	}

	public List<String> getTaskHobbiesids() {
		return taskHobbiesids;
	}

	public void setTaskHobbiesids(List<String> taskHobbiesids) {
		this.taskHobbiesids = taskHobbiesids;
	}
}
