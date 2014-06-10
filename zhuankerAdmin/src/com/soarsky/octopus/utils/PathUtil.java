package com.soarsky.octopus.utils;

/**
 * 路径工具类
 * 用于获取上传各种文件的路径
 * @author chenll
 *
 */
public class PathUtil {
	
	/**
	 * 从配置中得到上传文件的基准路径
	 * @return
	 */
	public static String getUploadBasePath(){
		return ConfigUtil.getModelValueUseCache(ConfigUtil.PATHUPLOAD_CODE, ConfigUtil.PATHUPLOAD_BASEPATH_KEY);
	}
	
	/**
	 * 从配置中得到上传文件的apk根路径
	 * @return
	 */
	public static String getUploadAPkRoot(){
		return ConfigUtil.getModelValueUseCache(ConfigUtil.PATHUPLOAD_CODE, ConfigUtil.PATHUPLOAD_APKPATH_KEY);
	}
	
	/**
	 * 从配置中得到上传文件的image根路径
	 * @return
	 */
	public static String getUploadImageRoot(){
		return ConfigUtil.getModelValueUseCache(ConfigUtil.PATHUPLOAD_CODE, ConfigUtil.PATHUPLOAD_IMGPATH_KEY);
	}
	
	/**
	 * 得到image的base路径，用于存放赚客网的图片或者图标
	 * 如赚客等级头像等
	 * @return
	 */
	public static String getUploadImageBase(){
		return ConfigUtil.getModelValueUseCache(ConfigUtil.PATHUPLOAD_CODE, ConfigUtil.PATHUPLOAD_IMGBASEPATH_KEY);
	}
	
	/**
	 * 得到apk的base路径，用于存放赚客网的自己的apk版本信息
	 * 如赚客等级头像等
	 * @return
	 */
	public static String getUploadApkBase(){
		return ConfigUtil.getModelValueUseCache(ConfigUtil.PATHUPLOAD_CODE, ConfigUtil.PATHUPLOAD_APKBASEPATH_KEY);
	}
	
	/**
	 * 得到上传excel路径
	 * @return
	 */
	public static String getUploadExcel(){
		return ConfigUtil.getModelValueUseCache(ConfigUtil.PATHUPLOAD_CODE, ConfigUtil.PATHUPLOAD_EXCELPATH_KEY);
	}
	
	/**
	 * 得到前台图片等需要src的相对路径
	 * @return
	 */
	public static String getHttpPath(){
		return ConfigUtil.getModelValueUseCache(ConfigUtil.CLIENTURL_CODE, ConfigUtil.CLIENTURL_IMAGEURL_KEY);
	}
	

}
