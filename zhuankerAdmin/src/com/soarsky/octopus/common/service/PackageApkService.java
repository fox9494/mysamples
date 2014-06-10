package com.soarsky.octopus.common.service;

/**
 * 线城池提供打包服务
 * @author chenll
 *
 */
public interface PackageApkService {
	
	
	/**
     * 打包服务方法
     * @param id  渠道id
     * @param fileName  打包后生产的文件名
     * @param souceApk  全路径源文件
     */
	 public void packageApk(Long id,String fileName,String souceApk);
	 
	 
	 /**
     * 批量打包
     * @param  上传原始apk的url地址
     */
    public void batchPackageApk(String sourceApkUrl);

}
