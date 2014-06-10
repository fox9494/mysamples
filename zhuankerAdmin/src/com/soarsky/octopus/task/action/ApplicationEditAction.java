package com.soarsky.octopus.task.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.FileCopyUtils;

import com.soarsky.guoxin.android.println.AXMLPrinter;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TApk;
import com.soarsky.octopus.mapping.TAppImage;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.task.constant.ApplicationErrorMsg;
import com.soarsky.octopus.task.constant.TaskContent;
import com.soarsky.octopus.task.service.TApkService;
import com.soarsky.octopus.task.service.TAppImageService;
import com.soarsky.octopus.task.service.TApplicationService;
import com.soarsky.octopus.task.service.TTaskService;
import com.soarsky.octopus.utils.FileNameGenerator;
import com.soarsky.octopus.utils.Image2DUtil;
import com.soarsky.octopus.utils.PathUtil;

public class ApplicationEditAction extends BaseAction {

	private static final long serialVersionUID = 651591030880208667L;
     
    private TApplicationService tApplicationService;
    
    private TTaskService tTaskService;
    
    private TApkService tApkService;
    
    private TAppImageService tAppImageService;
	
	private TApplication  app;
	
	private TTask  task;
	
	private TApk entityapk;
	
	private TCompany company;
	
    private File apk;
	
	private File icon;
	
	private File[]img;
	
	private String apkFileName;
	
	private String iconFileName;
	
	private String[]imgFileName;
	
	private List<String>apkContent;
	
	private Set<TAppImage>imgs;
	
	private String imgids;
	
	/**
	 * 初始化修改应用
	 * @author lw
	 * @return
    */
	@SuppressWarnings("unchecked")
	public String input() {
	  
	   if(app.getAppid()!=null){
			app=tApplicationService.initApplication(app);
			
			imgs=app.gettAppImages();//初始化应用图片
	   }
	try {
		if(task.getName()!=null){ 
		    task.setName(URLDecoder.decode(task.getName(),"UTF-8"));
		} 
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return SUCCESS;
	}
	
	/**
	 * 修改应用
	 * @author lw
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public String save(){
		
		if(app.getAppid()!=null){
			TApplication oldapp=tApplicationService.initApplication(app);
			
			imgs=oldapp.gettAppImages();//得到所有应用图片信息
						
			Set<TApk>oldapks=new HashSet<TApk>();
			         oldapks=oldapp.gettApks();
			TApk apk=tApkService.getCommonApk(app);//初始化普通APK
			if(entityapk.getApkSize()!=null){
				apk.setApkSize(entityapk.getApkSize()); 	
				apk.setTApplication(oldapp);	
				apk.setDownloadUrl(entityapk.getDownloadUrl());    	
				apk.setUploadDate(entityapk.getUploadDate());  				    
			    tApkService.editApk(apk);
			 }else{
			    app.settApks(oldapks); 
			 }
			
			//上传图标
			if(icon!=null){
				this.uploadIcon();
			}
			
			//上传应用图片
			if(img!=null&&img.length>0){
				tAppImageService.editAppImg(this.uploadImg());
			}else{
				app.settAppImages(imgs);
			}
			app.setAppName(task.getName());
	        app.setCompany(company);
			app.setTask(task);
			tApplicationService.editApplication(app);
		}else{
			
			Set<TApk>apks=new HashSet<TApk>();
			entityapk.setTApplication(app);
			apks.add(entityapk);
			
			if(icon!=null){
				this.uploadIcon();
			}
			
			task=tTaskService.ininTask(task);
			task.setApp(app);
			app.setCompany(company);
			app.setAppName(task.getName());
			app.setTask(task);
			app.settApks(apks);
			tApplicationService.addApplication(app);
			tAppImageService.editAppImg(this.uploadImg());
			tTaskService.editTask(task);
		}
		if(app.getAppid()!=null){
			app=tApplicationService.initApplication(app);
			
			imgs=app.gettAppImages();//初始化应用图片
	    }
		return "initeditsuccess";
	}
	
	/**
	 * 验证修改应用
	 * @author lw
	*/
	public void validateSave(){
		if(app.getIconUrl()==null){
			if(icon==null){
				this.addFieldError(ApplicationErrorMsg.ICON, ApplicationErrorMsg.ICON_MSG);
			}
		}
		/*if(imgid.length()==1&&Long.valueOf(imgid)==0){
			if(img==null||img.length<1){
			    this.addFieldError(ApplicationErrorMsg.IMG, ApplicationErrorMsg.IMG_MSG);	
			}	
		}*/
		if(app.getPlatform().length()<1){
			this.addFieldError(ApplicationErrorMsg.PLATFORM, ApplicationErrorMsg.PLATFORM_MSG);
		}
		if(app.getVersionrequire().length()<1){
			this.addFieldError(ApplicationErrorMsg.VERSIONREQUIRE, ApplicationErrorMsg.VERSIONREQUIRE_MSG);
		}
		if(app.getInitDownLoad()==null){
		    this.addFieldError(ApplicationErrorMsg.INITDOWNLOAD, ApplicationErrorMsg.INITDOWNLOAD_MSG);
		}
		if(app.getRating().length()<1){
			this.addFieldError(ApplicationErrorMsg.RATING, ApplicationErrorMsg.RATING_MSG);
		}
		if(app.getCostType()==null){
			this.addFieldError(ApplicationErrorMsg.COSTTYPE, ApplicationErrorMsg.COSTTYPE_MSG);
		}
		if(app.getDescription().length()<1){
			this.addFieldError(ApplicationErrorMsg.DESCRIPTION, ApplicationErrorMsg.DESCRIPTION_MSG);
		}
	}
	
	/**
	 * 上传APK
	 * @author lw
	 * @return
	*/
    @SuppressWarnings("unchecked")
	public  String uploadApk(){
    	
    	if(app.getAppid()!=null){
          app=tApplicationService.initApplication(app);
		  imgs=app.gettAppImages();
    	}
    	
    	String realpath =PathUtil.getUploadAPkRoot()+"company_"+company.getId();
    	
    	File dir = new File(realpath);
    	
		if (!dir.exists()) {
			
			dir.mkdirs();
		}
		
	    String extName = apkFileName.substring(apkFileName.lastIndexOf("."));
	    
		String apkName = FileNameGenerator.getFileName()+extName;
		
		if (apk != null&&apk.length() > 0) {
			
			File uploadfile=new File(realpath,apkName);
			
			try{
				
				FileCopyUtils.copy(apk, uploadfile);
				
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			String path=realpath+File.separator+apkName;
			
			long apksize=apk.length();
			
			AXMLPrinter ap = new AXMLPrinter();
			
			apkContent = ap.getManifestXMLFromAPK(path);
			   
		    Pattern pa=Pattern.compile("^[^0-9]+\\..*$");
		    
		    app.setVersion(apkContent.get(1));
		    
		    Matcher ma=pa.matcher(apkContent.get(2));
		    
		    if(ma.matches()){
		    	
		    	app.setPackage_name(apkContent.get(2));
		    	
		    }else{
		    	
		    	app.setPackage_name(apkContent.get(3));
		    }
		    
		    entityapk.setDownloadUrl(TaskContent.UPLOADAPKPATH+"company_"+company.getId()+"/"+apkName);
		    
		    entityapk.setApkSize(apksize);
		    
		    entityapk.setIsDefault(JEEContant.COMMONRESOLUTIONAPK);
		   
		    entityapk.setUploadDate(new Date());
		}
		
	    return "uploadapk";
    }
    
    /**
     * 验证上传APK
     * @author lw  
    */
    public void validateUploadApk(){
        
    	String extName = apkFileName.substring(apkFileName.lastIndexOf("."));
    	
    	if(!extName.equals(".apk")){
    		this.addFieldError(ApplicationErrorMsg.APK, ApplicationErrorMsg.APK_MSG);
    	}
    }
    
    /**
     * 上传图标
     * @author lw
    */
    public void  uploadIcon(){
    	
        String path=PathUtil.getUploadImageRoot()+File.separator+"company_"+company.getId();
		
		File file=new File(path);
		
		if(!file.mkdirs()){
			
			file.mkdirs();
			
		}
		
	    if(icon!=null){
	    				
		    String extName = iconFileName.substring(iconFileName.lastIndexOf("."));
		    
			String iconName = FileNameGenerator.getFileName()+extName;
			
			File uploadfile=new File(path,iconName);
			
			try{
				
				FileCopyUtils.copy(icon, uploadfile);
				
			}catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			app.setIconUrl(TaskContent.UPLOADIMGPATH+"company_"+company.getId()+"/"+iconName);
			
		}
    }
    
    /**
     * 上传应用图片
     * @author lw
     * @return
    */
    public List<TAppImage> uploadImg(){
    	
    	String[] imgsid=imgids.split(",");
    	
    	List<TAppImage> appImgs=new ArrayList<TAppImage>();
    	
    	String path=PathUtil.getUploadImageRoot()+File.separator+"company_"+company.getId();
 		
 		File file=new File(path);
 		
 		if(!file.mkdirs()){
 			
 			file.mkdirs();
 			
 		}
 		if(img!=null&&img.length>0){
 			
 			for(int i=0;i<img.length;i++){
 				
 				TAppImage appImg=new TAppImage();
 							
			    String extName = imgFileName[i].substring(imgFileName[i].lastIndexOf("."));
			    
				String ImageName = FileNameGenerator.getFileName()+i+extName;
				
				File uploadfile=new File(path,ImageName);
				
				try{
					Image2DUtil.scale2DImage(img[i], uploadfile, 240);//缩放图片
//					FileCopyUtils.copy(destFile, uploadfile);
					
				}catch (Exception e) {
					
					e.printStackTrace();
				}
				if(imgs!=null&&imgs.size()>0){				   					
					    if(Long.valueOf(imgsid[i])!=0){						
						   appImg.setId(Long.valueOf(imgsid[i]));					
					       appImg.setImageUrl(TaskContent.UPLOADIMGPATH+"company_"+company.getId()+"/"+ImageName);					
						   appImg.setTApplication(app);						
					    }else{					
						appImg.setImageUrl(TaskContent.UPLOADIMGPATH+"company_"+company.getId()+"/"+ImageName);					
						appImg.setTApplication(app);					
					    }				    
				}else{					
					appImg.setImageUrl(TaskContent.UPLOADIMGPATH+"company_"+company.getId()+"/"+ImageName);					
					appImg.setTApplication(app);					
				}
				appImgs.add(appImg);					
			} 			
 		} 		
 		return appImgs;
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

	public TTask getTask() {
		return task;
	}

	public void setTask(TTask task) {
		this.task = task;
	}

	public TApk getEntityapk() {
		return entityapk;
	}

	public void setEntityapk(TApk entityapk) {
		this.entityapk = entityapk;
	}

	public TCompany getCompany() {
		return company;
	}

	public void setCompany(TCompany company) {
		this.company = company;
	}

	public File getApk() {
		return apk;
	}

	public void setApk(File apk) {
		this.apk = apk;
	}

	public File getIcon() {
		return icon;
	}

	public void setIcon(File icon) {
		this.icon = icon;
	}

	public File[] getImg() {
		return img;
	}

	public void setImg(File[] img) {
		this.img = img;
	}

	public String getApkFileName() {
		return apkFileName;
	}

	public void setApkFileName(String apkFileName) {
		this.apkFileName = apkFileName;
	}

	public String getIconFileName() {
		return iconFileName;
	}

	public void setIconFileName(String iconFileName) {
		this.iconFileName = iconFileName;
	}

	public String[] getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String[] imgFileName) {
		this.imgFileName = imgFileName;
	}

	public List<String> getApkContent() {
		return apkContent;
	}

	public void setApkContent(List<String> apkContent) {
		this.apkContent = apkContent;
	}

	public Set<TAppImage> getImgs() {
		return imgs;
	}

	public void setImgs(Set<TAppImage> imgs) {
		this.imgs = imgs;
	}

	public String getImgids() {
		return imgids;
	}

	public void setImgids(String imgids) {
		this.imgids = imgids;
	}

	public TTaskService gettTaskService() {
		return tTaskService;
	}

	public void settTaskService(TTaskService tTaskService) {
		this.tTaskService = tTaskService;
	}

	public TApkService gettApkService() {
		return tApkService;
	}

	public void settApkService(TApkService tApkService) {
		this.tApkService = tApkService;
	}

	public TAppImageService gettAppImageService() {
		return tAppImageService;
	}

	public void settAppImageService(TAppImageService tAppImageService) {
		this.tAppImageService = tAppImageService;
	}
}
