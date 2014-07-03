package com.cpy.enfm.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * 属性加载类
 * @author chenll
 *
 */
public class PropertiesLoader {
	
	/**
	 * 得到properties文件
	 * @param resourceLocation  properties文件名
	 * @return
	 */
	public static Properties loadProperties(String resourceLocation){
		Properties properties=new Properties();
		InputStream inputStream=PropertiesLoader.class.getResourceAsStream(resourceLocation);
		if(inputStream==null){
			throw new RuntimeException("Cannot load resource from location:"+resourceLocation);
		}
		try {
			properties.load(inputStream);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return properties;
	}

}
