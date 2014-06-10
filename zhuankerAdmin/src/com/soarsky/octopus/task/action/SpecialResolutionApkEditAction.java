package com.soarsky.octopus.task.action;

import java.io.File;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.FileCopyUtils;

import com.soarsky.octopus.common.action.PageAction;
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
import com.soarsky.octopus.utils.PageBean;
import com.soarsky.octopus.utils.PathUtil;

public class SpecialResolutionApkEditAction extends PageAction {

	private static final long serialVersionUID = 787804308633189864L;
	
	private TApkService tApkService;
	
	private TApplicationService tApplicationService;
	
	private File apk;
	
	private String apkFileName;
	
	private TApplication app;
	
	private TTask task;
	
	private TCompany company;
	
	private TApk apkContent;
	
	/**
	 * 分页查询所有特定分辨率APK
	 * @author lw
	 * @return
	*/
	public String searchList(){
		
		pageBean=tApkService.getAllApk(PageBean.DEFAULTPAGESIZE,currentPage,app);
		
		return SUCCESS;
	}
	
    /**
     * 初始化要修改的APk
     * @author lw
     * @return
	*/
	public String  input(){
		
        if(apkContent!=null){
		
		   apkContent=tApkService.initApk(apkContent);
        
        }
		return "init";
	}
	
	/**
	 * 修改APK
	 * @author lw
	 * @return
	*/
	public String save(){
		
		if(this.hasEorror()){
			return INPUT;
		}
		
		if(StringUtils.isNotEmpty(apkFileName)){
            this.uploadApk();//上传APK
		}
		apkContent.setTApplication(app);
		
		tApkService.editApk(apkContent);
		
		return "editsuccess";
	}
	
	/**
	 * 验证添加特定分辨率
	 * @author lw
	*/
    public Boolean hasEorror(){ 
    	if(apkContent.getDownloadUrl().equals("")){
    		if(apk==null){
    			this.addFieldError(SpecialResolutionApkErrorMsg.APK, SpecialResolutionApkErrorMsg.APK_MSG);
    		}
    	}
    	if(apkContent.getResolution_height()==null){
    		this.addFieldError(SpecialResolutionApkErrorMsg.HEIGHT, SpecialResolutionApkErrorMsg.HEIGHT_MSG);
    	}
    	if(apkContent.getResolution_width()==null){
    		this.addFieldError(SpecialResolutionApkErrorMsg.WIDTH, SpecialResolutionApkErrorMsg.WIDTH_MSG);
    	}
		return this.hasFieldErrors();
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
    
	public TApkService gettApkService() {
		return tApkService;
	}

	public void settApkService(TApkService tApkService) {
		this.tApkService = tApkService;
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

	public TTask getTask() {
		return task;
	}

	public void setTask(TTask task) {
		this.task = task;
	}

	public TCompany getCompany() {
		return company;
	}

	public void setCompany(TCompany company) {
		this.company = company;
	}
}
