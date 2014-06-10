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

import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.log.service.TLogService;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TLog;

      
    /** 
     * @author 
     * explain : 文件解压/打包工具 
     */  
    public class ApkInstallUtil extends Thread{
    	
    	private Long   mid;   //当前ID
    	private String fileName;  //生成的文件名（不包括路径）
    	private String sourceApkPath;//源文件路径名
    	
    	private String apkName;
        public  ApkInstallUtil(Long mid,String fileName,String sourceApkPath){
        	this.mid = mid;
        	this.fileName =fileName;
        	this.sourceApkPath = sourceApkPath.replaceAll("/", "\\\\");
        }
        @Override
    	public void run(){
        	apkName =  sourceApkPath.substring(sourceApkPath.lastIndexOf("\\")+1);
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
                    File file =new File(apkToolPath);  
                    process = Runtime.getRuntime().exec("cmd.exe /c copy "+basePath+sourceApkPath+" "+userFilePath,null,file);
                    process.waitFor();
                    process = Runtime.getRuntime().exec("cmd.exe /c apktool d "+userFilePath+"\\"+apkName+" " +userFilePath+"\\app",null,file);  
                    process.waitFor();
                    //2----内容修改  
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
                    process = Runtime.getRuntime().exec("cmd.exe /c apktool b "+userFilePath+"\\app "+userFilePath+"\\app.apk ",null,file);  
                    process.waitFor();
                    //4----签名 （文件名称中不能包含空格）  
                    File bin =new File(jdkBinPath);  
                    String cmd = "cmd.exe /c jarsigner -keystore " +apkToolPath +"\\Octoups.keystore -storepass soarsky -signedjar "
                                    +userFilePath+File.separator+fileName+" "+userFilePath+"\\app.apk"+" Octopus";  
                    process = Runtime.getRuntime().exec(cmd,null,bin);  
                    process.waitFor();
                    TChannelService tChannelService = (TChannelService) BeanHolder.getBean("tChannelService");
                    
                    //更新路径
                    TChannel channel = tChannelService.getChannel(mid);
                    if (channel!=null){
                    	channel.setApkUrl("/apk/channel_"+mid+"/fileName");
                    	tChannelService.addChannel(channel);
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