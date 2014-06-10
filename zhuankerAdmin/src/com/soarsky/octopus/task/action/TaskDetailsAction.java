package com.soarsky.octopus.task.action;

import java.util.HashSet;
import java.util.Set;

import com.soarsky.octopus.clientuser.service.TAreaService;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TApk;
import com.soarsky.octopus.mapping.TAppImage;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TArea;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.mapping.TTaskAttribute;
import com.soarsky.octopus.mapping.TTaskChannel;
import com.soarsky.octopus.mapping.TTaskHobbies;
import com.soarsky.octopus.reports.service.TDownloadInstallLogService;
import com.soarsky.octopus.reports.service.TSystemFlowService;
import com.soarsky.octopus.task.service.TApkService;
import com.soarsky.octopus.task.service.TApplicationService;
import com.soarsky.octopus.task.service.TTaskService;
import com.soarsky.octopus.utils.PageBean;

public class TaskDetailsAction extends PageAction {

	private static final long serialVersionUID = -5439009727859997445L;
    
	private TTaskService tTaskService;
	
	private TApplicationService tApplicationService;
	
	private TApkService tApkService;
	
	private TAreaService tAreaService;
	
	private TDownloadInstallLogService tDownloadInstallLogService;
	
	private TSystemFlowService tSystemFlowService;
	
	private TTask task;
	
	private TArea province;
	
	private TArea city;
	
	private Set<TAppImage>imgs;
	
	private TTaskAttribute attr;
	
	private Set<TChannel>channels=new HashSet<TChannel>();
	
	private Set<THobbies>hobbies=new HashSet<THobbies>();
	
	private TApplication app;

	private TApk apk;
	
	private Integer type;
	
	/**
	 * 查看任务基本信息
	 * @author lw
	 * @return
	*/
	public String searchTaskDetails(){
		
		task=tTaskService.ininTask(task);
		
		return "searchtask";
	}
    
	/**
	 * 查看应用信息
	 * @author lw
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public String searchApplicationDetails(){
		
		app=tApplicationService.findApplicationByTask(task);
		
		if(app!=null){
			
		   apk=tApkService.getCommonApk(app);//得到应用普通APK
		   
		   imgs=app.gettAppImages();//得到应用图片
		}
		
		return "searchapp";
	}
	
	/**
	 * 查看任务渠道信息
	 * @author lw
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public String searchChannelDetails(){
		
		task=tTaskService.searchChannelDetails(task);
		
		//初始化任务属性对象
		if(task.getTTaskAttributes().iterator().hasNext()){
			  attr=(TTaskAttribute)task.getTTaskAttributes().iterator().next();
			  if(attr.getAreaId()!=null){ 
				  //初始化区域信息 
				  city=tAreaService.findAreaByClientId(attr.getAreaId());
				  province=tAreaService.findAreaByClientId(city.getParentId());
			  }
		}
		
		//初始化渠道对象
		Set<TTaskChannel> taskChannels = task.getTTaskChannels();
		for(TTaskChannel taskChannel:taskChannels){
			 channels.add(taskChannel.getTChannel());
		}
		
		//初始化爱好对象
		Set<TTaskHobbies> taskHobbies =task.getTTaskHobbieses();
		for(TTaskHobbies taskHobbie:taskHobbies){
			hobbies.add(taskHobbie.getTHobbies());
		}
		return "searchchannel";
	}
	
	/**
	 * 查询下载详情
	 * @author lw
	 * @return
	*/
	public String searchDownLoadDetails(){
		
		app=tApplicationService.findApplicationByTask(task);
		
		if(app!=null){
             pageBean=tDownloadInstallLogService.findDownInstallByApplication(PageBean.DEFAULTPAGESIZE, currentPage, app, JEEContant.DOWNLOAD);
		}

		return "searchdownload";
	}
	
	/**
	 *(下载,安装)执行分页操作
	 * @author lw
	 * @return
	*/
	public String searchDownLoadDetailsJson(){
		
		if(app!=null){
		  if(type==JEEContant.DOWNLOAD){	
            pageBean=tDownloadInstallLogService.findDownInstallByApplicationJson(PageBean.DEFAULTPAGESIZE, currentPage, app, JEEContant.DOWNLOAD);		   
		  }else{
			pageBean=tDownloadInstallLogService.findDownInstallByApplicationJson(PageBean.DEFAULTPAGESIZE, currentPage, app, JEEContant.INSTALL);		   
		  }
		 }
		
		return "searchdownloadjson";
	}
	/**
	 * 查询安装详情
	 * @author lw
	 * @return
	*/
	public String searchInstallDetails(){
		
		app=tApplicationService.findApplicationByTask(task);
		
		if(app!=null){
             pageBean=tDownloadInstallLogService.findDownInstallByApplication(PageBean.DEFAULTPAGESIZE, currentPage, app, JEEContant.INSTALL);
		}

		return "searchinstall";
	}
	
	/**
	 * 查询系统流量详情
	 * @author lw
	 * @return
	*/
	public String searchSysFlowDetails(){
		
		app=tApplicationService.findApplicationByTask(task);
		
		if(app!=null){
		   pageBean=tSystemFlowService.findSysFlowByApplication(PageBean.DEFAULTPAGESIZE, currentPage,app);
		}
		
		return "searchsysflow";
	}
	
	/**
	 *(流量统计)执行分页操作
	 * @author lw
	 * @return
	*/
	public String searchSysFlowDetailsJson(){
		
		if(app!=null){
			   pageBean=tSystemFlowService.findSysFlowByApplicationJson(PageBean.DEFAULTPAGESIZE, currentPage,app);
		}
		
		return "searchsysflowjson";
	}
	
	public TTaskService gettTaskService() {
		return tTaskService;
	}

	public void settTaskService(TTaskService tTaskService) {
		this.tTaskService = tTaskService;
	}

	public TTask getTask() {
		return task;
	}

	public void setTask(TTask task) {
		this.task = task;
	}

	public TApplicationService gettApplicationService() {
		return tApplicationService;
	}

	public void settApplicationService(TApplicationService tApplicationService) {
		this.tApplicationService = tApplicationService;
	}

	public TApplication getApp() {
		return app;
	}

	public void setApp(TApplication app) {
		this.app = app;
	}

	public TApkService gettApkService() {
		return tApkService;
	}

	public void settApkService(TApkService tApkService) {
		this.tApkService = tApkService;
	}

	public TApk getApk() {
		return apk;
	}

	public void setApk(TApk apk) {
		this.apk = apk;
	}

	public Set<TAppImage> getImgs() {
		return imgs;
	}

	public void setImgs(Set<TAppImage> imgs) {
		this.imgs = imgs;
	}

	public TTaskAttribute getAttr() {
		return attr;
	}

	public void setAttr(TTaskAttribute attr) {
		this.attr = attr;
	}

	public Set<TChannel> getChannels() {
		return channels;
	}

	public void setChannels(Set<TChannel> channels) {
		this.channels = channels;
	}

	public Set<THobbies> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<THobbies> hobbies) {
		this.hobbies = hobbies;
	}

	public TArea getProvince() {
		return province;
	}

	public void setProvince(TArea province) {
		this.province = province;
	}

	public TArea getCity() {
		return city;
	}

	public void setCity(TArea city) {
		this.city = city;
	}

	public TAreaService gettAreaService() {
		return tAreaService;
	}

	public void settAreaService(TAreaService tAreaService) {
		this.tAreaService = tAreaService;
	}

	public TDownloadInstallLogService gettDownloadInstallLogService() {
		return tDownloadInstallLogService;
	}

	public void settDownloadInstallLogService(
			TDownloadInstallLogService tDownloadInstallLogService) {
		this.tDownloadInstallLogService = tDownloadInstallLogService;
	}

	public TSystemFlowService gettSystemFlowService() {
		return tSystemFlowService;
	}

	public void settSystemFlowService(TSystemFlowService tSystemFlowService) {
		this.tSystemFlowService = tSystemFlowService;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
