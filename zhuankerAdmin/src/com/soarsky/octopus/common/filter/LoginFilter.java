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
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.soarsky.octopus.common.contant.JEEContant;

/**
 * 登录过滤验证器
 * @author chenll
 *
 */
public class LoginFilter implements Filter {
	
	/**
	 * 不需要过滤的url地址
	 */
	private String excludeUrlStr; 
	
	/**
	 * 配置排除的路径地址
	 */
	private String[] excludeUrl = new String[0];
	
	/**
	 * 基本排除路径
	 */
	private static final String[] baseExcludeUrl = { "/", "/jsp/login.jsp" };

	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		// 当前访问的路径
		final String curURL = httpServletRequest.getRequestURI();
		//排除项目名
		final String currentURL = curURL.substring(curURL.indexOf("/", 1),curURL.length());
		
		boolean sessionFlag = false;
		
		HttpSession session = httpServletRequest.getSession(false);
		if(session != null){
			sessionFlag = validateSession(session, JEEContant.SESSION_LOGIN_TOKENID);
		}
		
		if(excludeURL(currentURL, baseExcludeUrl)){
			chain.doFilter(request, response);
		}else {
			if (excludeURL(currentURL, excludeUrl)){
				chain.doFilter(request, response);
			}else{
				if(sessionFlag){
					chain.doFilter(httpServletRequest, httpServletResponse);
				}else{//返回登录页面
					httpServletResponse.sendRedirect(httpServletRequest
							.getContextPath()
							+ "/jsp/login.jsp");
				}
			}
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		excludeUrlStr = filterConfig.getInitParameter("excludeUrl");
		if (StringUtils.isNotBlank(excludeUrlStr)) {
			String[] excludeUrlStrArray = excludeUrlStr.split(",");
			excludeUrl = new String[excludeUrlStrArray.length];
			for (int i = 0; i < excludeUrlStrArray.length; i++) {
				excludeUrl[i] = excludeUrlStrArray[i].trim();
			}
		}

	}
	
	/**
	 * 验证session中用户是否存在
	 * @param session
	 * @param token
	 * @return
	 */
	private boolean validateSession(HttpSession session, String token) {
		Long loginID = (Long)session.getAttribute(token);
		if(loginID != null){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean excludeURL(String url, String[] excludeUrl) {
		for (String exclude : excludeUrl) {
			if (exclude.equals(url)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void destroy() {

	}

}
