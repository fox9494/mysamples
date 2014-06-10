package com.soarsky.octopus.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.common.service.PackageAdpter;
import com.soarsky.octopus.log.service.TLogService;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TLog;
      
/** 
 * @author 
 * windows打包工具
 * explain : 文件解压/打包工具 
 */  
public class PackageApkWinUtil implements PackageAdpter{
	
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
	
	private static Logger logger = Logger.getLogger(PackageApkWinUtil.class);
	
	
    public  PackageApkWinUtil(Long mid,String fileName,String sourceApkPath){
    	this.mid = mid;
    	this.fileName =fileName;
    	this.sourceApkPath = sourceApkPath.replaceAll("/", "\\\\");
    }
    
    /**
     * 打包apk
     */
    public void packageApk(){
    	String apkName =  sourceApkPath.substring(sourceApkPath.lastIndexOf("\\")+1);
    	String basePath = ConfigUtil.getModelValue(ConfigUtil.PATHUPLOAD_CODE, ConfigUtil.PATHUPLOAD_BASEPATH_KEY);
    	String apkToolPath = ConfigUtil.getModelValue(ConfigUtil.PACKAGE_CODE, ConfigUtil.PATHUPLOAD_APKTOOL_KEY);
    	String jdkBinPath  = ConfigUtil.getModelValue(ConfigUtil.PACKAGE_CODE, ConfigUtil.PATHJDK_BIN_KEY);
		Properties properties =  System.getProperties();
		String osName =  properties.getProperty("os.name");
		if(StringUtils.isNotBlank(osName) && osName.contains("Windows")){
            BufferedReader br =null;  
            OutputStreamWriter osw =null;  
            Process process = null;  
            try {  
            	String userFilePath = basePath+"\\apk\\"+"channel_"+mid;
            	//1--如果不存在该文件件则创建
                File userFile = new File(userFilePath);
        		if (!userFile.exists()) {
        			userFile.mkdir();
        		}
        		logger.info("打包程序开始拷贝文件");
                File file =new File(apkToolPath);  
                process = Runtime.getRuntime().exec("cmd.exe /c copy "+basePath+sourceApkPath+" "+userFilePath,null,file);
                process.waitFor();
                process = Runtime.getRuntime().exec("cmd.exe /c apktool d -f "+userFilePath+"\\"+apkName+" " +userFilePath+"\\app",null,file);  
                process.waitFor();
                
                //2----内容修改
                logger.info("打包程序开始修改文件");
                String targetPath = userFilePath+"\\app\\assets\\config.txt";
                String content="MID="+mid;  
                br = new BufferedReader(new InputStreamReader(new FileInputStream(targetPath)));  
                while((br.readLine())!=null)  
                {  
                    osw = new OutputStreamWriter(new FileOutputStream(targetPath));    
                    osw.write(content,0,content.length());    
                    osw.flush();    
                }  
                
                //3----打包
                logger.info("打包程序开始打包");
                process = Runtime.getRuntime().exec("cmd.exe /c apktool b "+userFilePath+"\\app "+userFilePath+"\\app.apk ",null,file);  
                process.waitFor();
                
                //4----签名 （文件名称中不能包含空格）
                logger.info("打包程序开始修改签名");
                File bin =new File(jdkBinPath);  
                String cmd = "cmd.exe /c jarsigner -keystore " +apkToolPath +"\\Octoups.keystore -storepass soarsky -signedjar "
                                +userFilePath+File.separator+fileName+" "+userFilePath+"\\app.apk"+" Octopus";  
                process = Runtime.getRuntime().exec(cmd,null,bin);  
                process.waitFor();

                logger.info("打包完成，开始更新渠道表中的apk路径");
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
		}else{
			
		}
    
    	
    }
} 