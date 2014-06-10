package com.soarsky.octopus.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 错误消息工具类
 * 主要获取exception抛出的异常消息
 * @author chenll
 *
 */
public class ErrMsgUtil {
	
	public static String getErrMsg(Exception ex){
		StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        ex.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
	}

}
