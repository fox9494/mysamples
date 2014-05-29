package com.openframe.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.openframe.exceptions.CustomException;
import com.openframe.utils.TokenUtil;

/**
 * 拦截器
 * 主要用于token验证，防止重复提交
 * @author chenll
 *
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (!TokenUtil.validToken(request)){//验证失败
			throw new CustomException("不能重复提交!");
		}else{
			return true;
		}
	}
	
	
	

}
