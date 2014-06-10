package com.soarsky.octopus.task.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
import com.soarsky.octopus.task.service.TApplicationService;
import com.soarsky.octopus.task.service.TTaskService;
import com.soarsky.octopus.utils.FileNameGenerator;
import com.soarsky.octopus.utils.Image2DUtil;
import com.soarsky.octopus.utils.PathUtil;

public class ApplicationAddAction extends BaseAction {

	private static final long serialVersionUID = 6133261010806925598L;
    
	private TApplicationService tApplicationService;
	
	private TTaskService tTaskService;
	
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
	
	private Integer confiresubmit;
	
	/**
	 * 添加应用
	 * @author lw
	 * @return
	*/
	public String  save(){
		
		confiresubmit=TaskContent.SUMBIT;
		
		Set<TApk>apks=new HashSet<TApk>();
		
		entityapk.setTApplication(app);
		
		task=tTaskService.ininTask(task);
		
		task.setApp(app);
		
		apks.add(entityapk);
		
		app.setCompany(company);
		
        if(icon!=null){
			
			this.uploadIcon();
			
		}
        
        app.setAppName(task.getName());
        
		app.setTask(task);
		
		app.settApks(apks);
		
		app.settAppImages(this.uploadImg());
		
		app=tApplicationService.addApplication(app);
		
		tTaskService.editTask(task);
		
		return SUCCESS;
	}
	
	/**
	 * 验证添加应用
	 * @author lw
	*/
	public void validateSave(){	
		if(icon==null){
			this.addFieldError(ApplicationErrorMsg.ICON, ApplicationErrorMsg.ICON_MSG);
		}
		if(img==null||img.length<1){
			this.addFieldError(ApplicationErrorMsg.IMG, ApplicationErrorMsg.IMG_MSG);
		}
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
	 * 初始化添加应用
	 * @author lw
	 * @return
    */
	public  String initAddApplication(){
		try {
			task.setName(URLDecoder.decode(task.getName(),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "initaddsuccess";	
	}
	
	/**
	 * 上传APK
	 * @author lw
	 * @return
	*/
    @SuppressWarnings("unchecked")
	public  String uploadApk(){
    	
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
		}
		
		String path=realpath+File.separator+apkName;
		
		long apksize=apk.length();
		
		AXMLPrinter ap = new AXMLPrinter();
		
		apkContent = ap.getManifestXMLFromAPK(path);
		   
	    Pattern pa=Pattern.compile("^[^0-9]+\\..*$");
	    
	    TApplication gapplication=new TApplication();
	    
	    gapplication.setVersion(apkContent.get(1));
	    
	    Matcher ma=pa.matcher(apkContent.get(2));
	    
	    if(ma.matches()){
	    	
	    	gapplication.setPackage_name(apkContent.get(2));
	    	
	    }else{
	    	
	    	gapplication.setPackage_name(apkContent.get(3));
	    }
	    
	    this.setApp(gapplication);
	    
	    entityapk.setDownloadUrl(TaskContent.UPLOADAPKPATH+"company_"+company.getId()+"/"+apkName);
	    
	    entityapk.setApkSize(apksize);
	    
	    entityapk.setIsDefault(JEEContant.COMMONRESOLUTIONAPK);
	   
	    entityapk.setUploadDate(new Date());
	    
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
    public Set<TAppImage> uploadImg(){
    	
    	Set<TAppImage>appImgs=new HashSet<TAppImage>();
    	
    	String path=PathUtil.getUploadImageRoot()+File.separator+"company_"+company.getId();
 		
 		File file=new File(path);
 		
 		if(!file.mkdirs()){
 			
 			file.mkdirs();
 			
 		}
 		if(img.length>0&&img!=null){
 			
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
				
				appImg.setImageUrl(TaskContent.UPLOADIMGPATH+"company_"+company.getId()+"/"+ImageName);
				
				appImg.setTApplication(app);
				
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

	public TTaskService gettTaskService() {
		return tTaskService;
	}

	public void settTaskService(TTaskService tTaskService) {
		this.tTaskService = tTaskService;
	}

	public Integer getConfiresubmit() {
		return confiresubmit;
	}

	public void setConfiresubmit(Integer confiresubmit) {
		this.confiresubmit = confiresubmit;
	}
}
