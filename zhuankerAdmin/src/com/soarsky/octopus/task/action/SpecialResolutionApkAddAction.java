package com.soarsky.octopus.task.action;

import java.io.File;
import java.util.Date;

import org.springframework.util.FileCopyUtils;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TApk;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.task.constant.ApplicationErrorMsg;
import com.soarsky.octopus.task.constant.SpecialResolutionApkErrorMsg;
import com.soarsky.octopus.task.constant.TaskContent;
import com.soarsky.octopus.task.service.TApkService;
import com.soarsky.octopus.task.service.TApplicationService;
import com.soarsky.octopus.utils.FileNameGenerator;
import com.soarsky.octopus.utils.PathUtil;

public class SpecialResolutionApkAddAction extends BaseAction {

	private static final long serialVersionUID = 3497120808292650871L;
	
	private TApkService tApkService;
	
	private TApplicationService tApplicationService;
    
	private TApplication app;
	
	private TTask task;
	
	private File apk;
	
	private TCompany company;
	
	private String apkFileName;
	
	private TApk apkContent;
	
	private Integer confiresubmit;
	
	private Integer submitApk=0;
	
	 private Integer submitChannel;
    
	/**
	 * 初始化添加特定分辨率APK
	 * @author lw
	 * @return
	*/
	public String initAddApk(){
		
	  return "initsuccess";	
	}
	
	/**
	 * 添加APK并退出
	 * @author lw
	 * @return
	*/
	public String addApkAndExit(){
		
		if(this.hasEorror()){
			return INPUT;
		}
		
		this.uploadApk();//上传APK
		
		apkContent.setTApplication(app);
		
		tApkService.addApk(apkContent);
		
		return "addandexit";
	}
	
	/**
	 * 添加APK并继续添加
	 * @author lw
	 * @return
	*/
	public String addApkAndContinue(){
		
		if(this.hasEorror()){
			return INPUT;
		}
		
		confiresubmit=TaskContent.SUMBITSPECIALAPK;
		
		submitApk=TaskContent.SUMBITSPECIALAPK;
		
		this.uploadApk();//上传APK
		
		apkContent.setTApplication(app);
		
		tApkService.addApk(apkContent);
		
		return "addandcontinue";
	}
	
	/**
	 * 验证添加特定分辨率
	 * @author lw
	*/
    public Boolean hasEorror(){    	
    	if(apkContent.getResolution_height()==null){
    		this.addFieldError(SpecialResolutionApkErrorMsg.HEIGHT, SpecialResolutionApkErrorMsg.HEIGHT_MSG);
    	}
    	if(apkContent.getResolution_width()==null){
    		this.addFieldError(SpecialResolutionApkErrorMsg.WIDTH, SpecialResolutionApkErrorMsg.WIDTH_MSG);
    	}
		return this.hasFieldErrors();
	}
    
	/**
	 * 返回添加应用界面
	 * @author lw
	 * @return
	*/
	public String goBack(){
		
		app=tApplicationService.initApplication(app);
		
		return "goback";
	}
	/**
	 * 上传APK
	 * @author lw
	 * @return 
	*/
    public void uploadApk(){
    	
    	String realpath =PathUtil.getUploadAPkRoot()+File.separator+"company_"+company.getId();
    	
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
		
		//String path=realpath+"\\"+apkName;
		
		Long apksize=apk.length()/TaskContent.SIZE;
		
		/*AXMLPrinter ap = new AXMLPrinter();*/
		
		/*apkContent = ap.getManifestXMLFromAPK(path);
		   
	    Pattern pa=Pattern.compile("^[^0-9]+\\..*$");
	    
	    TApplication gapplication=new TApplication();
	    
	    gapplication.setVersion(apkContent.get(0));
	    
	    Matcher ma=pa.matcher(apkContent.get(2));
	    
	    if(ma.matches()){
	    	
	    	gapplication.setPackage_name(apkContent.get(2));
	    	
	    }else{
	    	
	    	gapplication.setPackage_name(apkContent.get(3));
	    }
	    
	    this.setApp(gapplication);*/
	    
		apkContent.setDownloadUrl(TaskContent.UPLOADAPKPATH+"company_"+company.getId()+"/"+apkName);
	    
		apkContent.setApkSize(apksize);
	    
		apkContent.setIsDefault(JEEContant.SPECIALRESOLUTIONAPK);
	   
		apkContent.setUploadDate(new Date());
	   
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
	public TApplication getApp() {
		return app;
	}

	public void setApp(TApplication app) {
		this.app = app;
	}

	public File getApk() {
		return apk;
	}

	public void setApk(File apk) {
		this.apk = apk;
	}

	public String getApkFileName() {
		return apkFileName;
	}

	public void setApkFileName(String apkFileName) {
		this.apkFileName = apkFileName;
	}

	public TApk getApkContent() {
		return apkContent;
	}

	public void setApkContent(TApk apkContent) {
		this.apkContent = apkContent;
	}

	public TApkService gettApkService() {
		return tApkService;
	}

	public void settApkService(TApkService tApkService) {
		this.tApkService = tApkService;
	}

	public Integer getConfiresubmit() {
		return confiresubmit;
	}

	public void setConfiresubmit(Integer confiresubmit) {
		this.confiresubmit = confiresubmit;
	}

	public TApplicationService gettApplicationService() {
		return tApplicationService;
	}

	public void settApplicationService(TApplicationService tApplicationService) {
		this.tApplicationService = tApplicationService;
	}

	public TTask getTask() {
		return task;
	}

	public void setTask(TTask task) {
		this.task = task;
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

	public TCompany getCompany() {
		return company;
	}

	public void setCompany(TCompany company) {
		this.company = company;
	}
}
