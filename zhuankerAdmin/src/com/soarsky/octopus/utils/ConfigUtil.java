package com.soarsky.octopus.utils;

import java.util.List;

import com.soarsky.octopus.config.service.TConfigService;
import com.soarsky.octopus.mapping.TConfig;

/**
 * 加载配置表工具类
 * @author chenll
 *
 */
public class ConfigUtil {
	

	public static final String PATHUPLOAD_CODE = "com.soarsky.octopus.path.upload";
	
	public static final String CLIENTUSER_CODE = "com.soarsky.octopus.clientuser";
	
	public static final String CLIENTURL_CODE = "com.soarsky.octopus.client.url";
	
	public static final String CLIENTUSER_FINISHGOLD_KEY = "finishGold";
	
	public static final String PATHUPLOAD_BASEPATH_KEY = "basePath";
	
	public static final String PATHUPLOAD_APKROOT_KEY = "apkRootPath";
	
	public static final String CLIENTURL_IMAGEURL_KEY = "imageUrl";
	
	public static final String PACKAGE_CODE = "com.soarsky.octopus.register.package";
	
	public static final String PATHUPLOAD_APKTOOL_KEY = "apkToolPath";
	
	public static final String PATHJDK_BIN_KEY = "jdkBinPath";
	
	
	
	public static final String PATHUPLOAD_IMGBASEPATH_KEY = "imgBasePath";
	
	public static final String PATHUPLOAD_APKBASEPATH_KEY = "apkBasePath";
	
	public static final String PATHUPLOAD_APKPATH_KEY = "apkPath";
	
	public static final String PATHUPLOAD_EXCELPATH_KEY = "excelPath";
	
	public static final String PATHUPLOAD_IMGPATH_KEY = "imgPath";
	
	
	
	/**
	 * 得到配置表中的模块对应的key的value值
	 * @param modelCode (模块编码)
	 * @param key (键值对的key)
	 * @return
	 */
	public static String getModelValue(String modelCode,String key){
		String result="";
		TConfigService tConfigService = (TConfigService) BeanHolder.getBean("tConfigService");
		List<TConfig> list = tConfigService.getConfigByCodeKey(modelCode, key);
		if (list!=null&&!list.isEmpty()){//list中只有一个唯一值
			result = list.get(0).getValue();
		}
		return result;
	}
	
	/**
	 * 得到配置表中的模块对应的key的value值
	 * 使用hibernate的二级缓存
	 * @param modelCode (模块编码)
	 * @param key (键值对的key)
	 * @return
	 */
	public static String getModelValueUseCache(String modelCode,String key){
		String result="";
		
		TConfigService tConfigService = (TConfigService) BeanHolder.getBean("tConfigService");
		List<TConfig> list = tConfigService.getAllConfig();
		
		if (list!=null&&!list.isEmpty()){
			for (TConfig tConfig : list) {
				if (tConfig.getModelCode().equals(modelCode)&&tConfig.getKey().equals(key)){
					result =  tConfig.getValue();
				}
			}
		}
		return result;
	}
	
	
}


