
package com.openframe.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author chenll
 * 调用此类的getBean可以手工获取spring容器产生的bean
 */
public class BeanHolder implements ApplicationContextAware
{
	private static ApplicationContext context = null;
	
	public BeanHolder(){
	
	}

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException
	{
		setApplicationContextStatic(arg0);
	}

	/**
	 * 私有设置方法，避免findBug的错误。
	 * @param arg0
	 */
	private static void setApplicationContextStatic(ApplicationContext arg0){
		context = arg0;
	}
	
	/**
	 * 获取spring容器产生的bean
	 * @param id
	 * @return
	 */
	public static Object getBean(String id)
	{
		return context.getBean(id);
	}
}
