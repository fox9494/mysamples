package com.soarsky.octopus.utils;



import com.opensymphony.xwork2.ActionContext;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.service.TManagerInfoService;

public class PrivilegeUtil {
	
	/**
	 * 验证当前用户是否具有code权限
	 * @param code
	 * @return
	 */
	public static boolean validateUserRight(String code)
	{
		TManagerInfoService tManagerInfoService = (TManagerInfoService) BeanHolder.getBean("tManagerInfoService");
		Long uid = (Long)ActionContext.getContext().getSession().get(JEEContant.SESSION_LOGIN_TOKENID);
		return tManagerInfoService.validateRight(uid, code);
	}
	
	
	/**
	 * 验证当前用户是否具有url权限
	 * @param url
	 * @return
	 */
	public static boolean validateUserRightByURL(String url)
	{
		TManagerInfoService tManagerInfoService = (TManagerInfoService) BeanHolder.getBean("tManagerInfoService");
		Long uid = (Long)ActionContext.getContext().getSession().get(JEEContant.SESSION_LOGIN_TOKENID);
		return tManagerInfoService.validateRightByUrl(uid, url);
	}

	
	
	
	
	

}
