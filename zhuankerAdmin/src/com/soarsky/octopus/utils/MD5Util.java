package com.soarsky.octopus.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5生存工具
 * @author chenll
 *
 */
public class MD5Util {
	
	
	/**
	 * 得到md5加密字符串
	 * @param source
	 * @return
	 */
	public static String getMD5(String source){
		String result="";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(source.getBytes("UTF8"));
			result = toHexString(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 将产生的消息字节组数转成16进制字符串
	 * @param byteArray
	 * @return
	 */
	public static String toHexString(byte[] byteArray){
		StringBuffer md5StrBuff = new StringBuffer();  
		  
        for (int i = 0; i < byteArray.length; i++) {  
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
                md5StrBuff.append("0").append(  
                        Integer.toHexString(0xFF & byteArray[i]));  
            else  
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
        }  
  
        return md5StrBuff.toString();  
	}
	
	public static void main(String[] args) {
		System.out.println(getMD5("123456"));
	}

}
