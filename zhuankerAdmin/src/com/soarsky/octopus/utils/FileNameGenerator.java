package com.soarsky.octopus.utils;

import java.util.UUID;

import sun.misc.BASE64Encoder;

/**
 * 文件名生成工具类
 * 主要用于文件上传
 * @author chenll
 *
 */
public class FileNameGenerator {
	
	/**
	 * Base64编码工具
	 */
	private static final BASE64Encoder base64En = new BASE64Encoder();
	
	
	/**
	 * 产生全局唯一文件名
	 * 利用base64编码UUID
	 * @return
	 */
	public static String getFileName(){
		return base64En.encode(UUID.randomUUID().toString().getBytes());
	}

}
