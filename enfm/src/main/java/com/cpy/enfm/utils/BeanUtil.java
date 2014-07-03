package com.cpy.enfm.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class BeanUtil {
	
	private static final Logger logger = Logger.getLogger(BeanUtil.class);
	
	
	//将bean对象转成map
	public static Map<String,Object> bean2Map(Object bean){
		if(bean == null) return null;
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor propertyDescriptor[] = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor property : propertyDescriptor){
				String key = property.getName();
				if(!key.equals("class")){
					Method getter = property.getReadMethod();
					if(getter!=null){
						Object val = getter.invoke(bean);
						map.put(key, val);
					}
				}
			}
		} catch (Exception e) {
			logger.error("transBean2Map Error!", e);
		}
		return map;
	}
}
