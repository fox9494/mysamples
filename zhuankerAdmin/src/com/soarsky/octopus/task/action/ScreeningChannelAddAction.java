package com.soarsky.octopus.task.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.clientuser.vo.TreeData;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.mapping.TTaskAttribute;
import com.soarsky.octopus.mapping.TTaskChannel;
import com.soarsky.octopus.mapping.TTaskHobbies;
import com.soarsky.octopus.task.constant.TaskContent;
import com.soarsky.octopus.task.service.TApplicationService;
import com.soarsky.octopus.task.service.TTaskAttributeService;
import com.soarsky.octopus.task.service.TTaskChannelService;
import com.soarsky.octopus.task.service.TTaskHobbiesService;

public class ScreeningChannelAddAction extends BaseAction {

	private static final long serialVersionUID = -5643428358183724780L;
    
	private TChannelService tChannelService;
	
	private TTaskAttributeService  tTaskAttributeService;
	
	private TApplicationService tApplicationService;
	
	private TTaskHobbiesService  tTaskHobbiesService;
	
	private TTaskChannelService  tTaskChannelService;
	
    private List<TreeData>channels;
    
    private TTaskAttribute taskAttribute;
    
    private List<THobbies> hobbies;
    
    private TTask task;
    
    private TApplication app;
    
    private Integer confiresubmit;
    
    private Integer submitApk;
    
    private Integer submitChannel=0;
    
    private String info;    
    
    /**
     * 筛选渠道
     * @author lw
     * @return
    */
    public String addScreeningChannel(){
    	
    	confiresubmit=TaskContent.SUMBITCHANNEL;
    	
    	submitChannel=TaskContent.SUMBITCHANNEL;
    	
    	String[]id=info.split(",");
    	
    	taskAttribute.setTTask(task);
    	
    	tTaskAttributeService.addTaskAttribute(taskAttribute);//添加任务属性
    	
    	if(StringUtils.isNotBlank(info)){
    		
    	 for(int i=0;i<id.length;i++){
    		
            TChannel initChannel=new TChannel();
    		
    		initChannel.setId(Long.valueOf(id[i]));
    		
    		TChannel channel=tChannelService.initChannel(initChannel);
    		
    		TTaskChannel taskChannel=new TTaskChannel();//封装任务渠道对象
    		
    		taskChannel.setTTask(task);
    		
    		taskChannel.setTChannel(channel);
    	
    		tTaskChannelService.addTaskChannel(taskChannel);//添加任务渠道
    	  }
    	}
    	if(hobbies!=null&&hobbies.size()>0){
    	  for(THobbies hobbi:hobbies){
    		
    		TTaskHobbies  taskHobbie=new TTaskHobbies();
    		
    		taskHobbie.setTHobbies(hobbi);
    		
    		taskHobbie.setTTask(task);
    		
    		tTaskHobbiesService.addTaskHobbies(taskHobbie);//添加任务爱好
    	  }
    	}
        
    	
    	return "screensuccess";
    }
    
    /**
     * 初始化渠道筛选
     * @author lw
     * @return
    */
    public String initChannel(){
    	
    	return "initsuccess";
    }
    
    /**
     * 返回添加应用
     * @author lw
     * @return
    */
    public String goback(){
    	
    	app=tApplicationService.initApplication(app);
    	
    	return "goback";
    }
    
    /**
     *得到所有的渠道信息用json格式封装
     *@author lw
     *@return 
    */
    public String getAllChannels(){
        
    	channels=tChannelService.findAllChannels();
    	
    	return SUCCESS;
    }
    
	public TChannelService gettChannelService() {
		return tChannelService;
	}

	public void settChannelService(TChannelService tChannelService) {
		this.tChannelService = tChannelService;
	}

	public List<TreeData> getChannels() {
		return channels;
	}

	public void setChannels(List<TreeData> channels) {
		this.channels = channels;
	}

	public TTask getTask() {
		return task;
	}

	public void setTask(TTask task) {
		this.task = task;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
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

	public Integer getConfiresubmit() {
		return confiresubmit;
	}

	public void setConfiresubmit(Integer confiresubmit) {
		this.confiresubmit = confiresubmit;
	}

	public TApplication getApp() {
		return app;
	}

	public void setApp(TApplication app) {
		this.app = app;
	}

	public TApplicationService gettApplicationService() {
		return tApplicationService;
	}

	public void settApplicationService(TApplicationService tApplicationService) {
		this.tApplicationService = tApplicationService;
	}

	public Integer getSubmitApk() {
		return submitApk;
	}

	public void setSubmitApk(Integer submitApk) {
		this.submitApk = submitApk;
	}

	public Integer getSubmitChannel() {
		return submitChannel;
	}

	public void setSubmitChannel(Integer submitChannel) {
		this.submitChannel = submitChannel;
	}
}
