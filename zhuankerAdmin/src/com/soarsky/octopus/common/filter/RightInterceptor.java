package com.soarsky.octopus.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soarsky.octopus.utils.PrivilegeUtil;

/**
 * 权限过滤器，主要拦截用户的url地址
 * 根据请求的url判断用户是否具有该功能的请求权限
 * @author chenll
 *
 */
public class RightInterceptor implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		// 当前访问的路径
		final String curURL = httpServletRequest.getRequestURI();
		//排除项目名
	    final String currentURL = curURL.substring(curURL.indexOf("/", 1),curURL.length());
	    
	    
	    if (PrivilegeUtil.validateUserRightByURL(currentURL)){
	    	chain.doFilter(httpServletRequest, httpServletResponse);
	    }else{
	    	httpServletResponse.sendRedirect(httpServletRequest
					.getContextPath()
					+ "/jsp/err.jsp");
	    }
	    
	    
	    
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
