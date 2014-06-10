package com.soarsky.octopus.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

import org.apache.log4j.Logger;

import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.common.service.PackageAdpter;
import com.soarsky.octopus.log.service.TLogService;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TLog;

/**
 * linux上打包工具
 * @author chenll
 *
 */
public class PackageApkLinuxUtil implements PackageAdpter {
	
	/**
	 * 待打包的ID(如渠道，个人客户)
	 */
	private Long   mid;   
	
	/**
	 * 打包后生产的文件名(不带路径)
	 */
	private String fileName;
	
	/**
	 * 全路径源文件（用户上传的原始赚客apk）
	 */
	private String sourceApkPath;
	
	private static Logger logger = Logger.getLogger(PackageApkLinuxUtil.class);
	
	 public  PackageApkLinuxUtil(Long mid,String fileName,String sourceApkPath){
	    	this.mid = mid;
	    	this.fileName =fileName;
	    	this.sourceApkPath = sourceApkPath;
	    }
	    

	@Override
	public void packageApk() {
		logger.info("the sourceApkPath:"+sourceApkPath);
    	String apkName =  sourceApkPath.substring(sourceApkPath.lastIndexOf(File.separator)+1);
    	String basePath = ConfigUtil.getModelValue(ConfigUtil.PATHUPLOAD_CODE, ConfigUtil.PATHUPLOAD_BASEPATH_KEY);
    	String apkToolPath = ConfigUtil.getModelValue(ConfigUtil.PACKAGE_CODE, ConfigUtil.PATHUPLOAD_APKTOOL_KEY);
    	String jdkBinPath  = ConfigUtil.getModelValue(ConfigUtil.PACKAGE_CODE, ConfigUtil.PATHJDK_BIN_KEY);
    	String apkPath  = ConfigUtil.getModelValue(ConfigUtil.PATHUPLOAD_CODE, ConfigUtil.PATHUPLOAD_APKPATH_KEY);
		
        BufferedReader br =null;  
        OutputStreamWriter osw =null;  
        Process process = null;  
        try {  
        	String userFilePath = apkPath+"channel_"+mid;
        	
        	logger.info("the apkName:"+apkName+",basePath:"+basePath+",userFilePath:"+userFilePath);
        	//1--如果不存在该文件件则创建
            File userFile = new File(userFilePath);
            String cmd = "rm -rf "+userFilePath;
            logger.info("the command:"+cmd);
            process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
    		if (!userFile.exists()) {
    			userFile.mkdir();
    		}
    		logger.info("begin to copy file");
            File file =new File(apkToolPath);  
            cmd = "cp "+basePath+sourceApkPath+" "+userFilePath;
            logger.info("the command:"+cmd);
            process = Runtime.getRuntime().exec(cmd,null,file);
            process.waitFor();
            
            logger.info("begin to unzip the apk file");
            cmd ="./apktool d  "+userFilePath+File.separator+apkName+" " +userFilePath+File.separator+"app";
            logger.info("the command:"+cmd);
            process = Runtime.getRuntime().exec(cmd,null,file);  
            process.waitFor();
            
            //2----内容修改
            logger.info("begin to update the config.txt");
            String targetPath = userFilePath+File.separator+"app"+File.separator+"assets"+File.separator+"config.txt";
            logger.info("the targetPath:"+targetPath);
            String content="MID="+mid;  
            br = new BufferedReader(new InputStreamReader(new FileInputStream(targetPath)));  
            while((br.readLine())!=null)  
            {  
                osw = new OutputStreamWriter(new FileOutputStream(targetPath));    
                osw.write(content,0,content.length());    
                osw.flush();    
            }  
            
            //3----打包
            logger.info("begin to package new apk file");
            cmd="./apktool b "+userFilePath+File.separator+"app "+userFilePath+File.separator+"app.apk ";
            logger.info("the command:"+cmd);
            process = Runtime.getRuntime().exec(cmd,null,file);  
            process.waitFor();
            
            //4----签名 （文件名称中不能包含空格）
            logger.info("begin to update the signContext");
            File bin =new File(jdkBinPath);  
            cmd = "jarsigner -verbose -keystore " +apkToolPath +File.separator+"Octopus.keystore -storepass  Octopus -keypass Octopus -signedjar "
                            +userFilePath+File.separator+fileName+" "+userFilePath+File.separator+"app.apk"+" Octopus.keystore";  
            logger.info("the command:"+cmd);
            process = Runtime.getRuntime().exec(cmd,null,bin);  
            process.waitFor();

            logger.info("Finish the Package,begin to update the url");
            TChannelService tChannelService = (TChannelService) BeanHolder.getBean("tChannelService");
            TChannel channel = tChannelService.getChannel(mid);
            if (channel!=null){
            	channel.setApkUrl("/apk/channel_"+mid+"/"+fileName);
            	tChannelService.updateChannel(channel);
            }
        }catch (Exception e)  
        {  
        	e.printStackTrace();  
        	//写日志
        	TLogService tLogService = (TLogService) BeanHolder.getBean("tLogService");
        	TLog log = new TLog();
        	log.setContent("打包渠道apk失败");
        	log.setCreateDate(new Date());
        	log.setOperator(String.valueOf(mid));
        	log.setExceContent(ErrMsgUtil.getErrMsg(e));
        	log.setStatus("-1");
        	tLogService.save(log);  
        }finally{  
            try {
				br.close();
				osw.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}  
        }  
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSourceApkPath() {
		return sourceApkPath;
	}

	public void setSourceApkPath(String sourceApkPath) {
		this.sourceApkPath = sourceApkPath;
	}

}
