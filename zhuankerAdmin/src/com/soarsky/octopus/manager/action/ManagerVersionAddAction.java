package com.soarsky.octopus.manager.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.FileCopyUtils;

import com.soarsky.guoxin.android.println.AXMLPrinter;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.constant.versionErrorMsg;
import com.soarsky.octopus.manager.service.TVersionService;
import com.soarsky.octopus.mapping.TVersion;
import com.soarsky.octopus.utils.PathUtil;

public class ManagerVersionAddAction extends BaseAction {
	
	private TVersionService tVersionService;
	
	private TVersion tversion;
	
	private File apk;
	
    private List<String>apkContent;
	
	private Map<String, String> apkcontent = new HashMap<String, String>();
	
	private String apkFileName;
	

	
	
	
	
	
	//添加版本
	public String versionAdd(){
		this.tVersionService.versionAdd(tversion);
		return SUCCESS;
	}
	
	//上传APK
	public String uploadApk(){
		
		String realpath=PathUtil.getUploadApkBase();
		File dir = new File(realpath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		SimpleDateFormat dform = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String date = dform.format(new Date());
	    String extName = apkFileName.substring(apkFileName.lastIndexOf("."));
		String apkName = date+extName;
		if (apk != null&&apk.length() > 0) {
			File uploadfile=new File(realpath,apkName);
			try{
				FileCopyUtils.copy(apk, uploadfile);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		String path=realpath+apkName;
		int size=(int)apk.length()/JEEContant.SIZE;
		String filesize=String.valueOf(size+"KB");
		AXMLPrinter ap = new AXMLPrinter();
		apkContent = ap.getManifestXMLFromAPK(path);
		tversion.setVersion(apkContent.get(1));
		tversion.setApkUrl(JEEContant.UPLOADAPKPATH+"base"+"/"+apkName);
		apkcontent.put("versionFileName",apkFileName);
    	
		
		return INPUT;
	}
	
	public void validateVersionAdd(){
		
		if(tversion.getVersion().trim().length()<1||this.tVersionService.judgeName(tversion.getVersion())){
			this.addFieldError(versionErrorMsg.VERSION, versionErrorMsg.VERSION_MSG);
		}
		
		
	}
	
	
	
	
	
	

	public TVersionService gettVersionService() {
		return tVersionService;
	}

	public void settVersionService(TVersionService tVersionService) {
		this.tVersionService = tVersionService;
	}

	public TVersion getTversion() {
		return tversion;
	}

	public void setTversion(TVersion tversion) {
		this.tversion = tversion;
	}

	public File getApk() {
		return apk;
	}

	public void setApk(File apk) {
		this.apk = apk;
	}

	public List<String> getApkContent() {
		return apkContent;
	}

	public void setApkContent(List<String> apkContent) {
		this.apkContent = apkContent;
	}

	public Map<String, String> getApkcontent() {
		return apkcontent;
	}

	public void setApkcontent(Map<String, String> apkcontent) {
		this.apkcontent = apkcontent;
	}

	public String getApkFileName() {
		return apkFileName;
	}

	public void setApkFileName(String apkFileName) {
		this.apkFileName = apkFileName;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
