package com.cpy.enfm.utils;

import java.math.BigInteger;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

/**
 * 用于token产生，防止重复提交
 * @author chenll
 *
 */
public class TokenUtil {

    private static final Random RANDOM = new Random();
    
    public static final String DEFAULT_TOKEN_NAME = "token";
    
    public static String setToken(HttpServletRequest request) {
        return setToken(DEFAULT_TOKEN_NAME,request);
    }
	
	public static String setToken(String tokenName,HttpServletRequest request){
		
		String token = generateGUID();  //产生token
		//将token放到session中
		HttpSession session = request.getSession();
		session.setAttribute(tokenName, token);
		return token;
	}
	
	
	public static String generateGUID() {
        return new BigInteger(165, RANDOM).toString(36).toUpperCase();
    };
    
    
    // 验证token
    public static boolean validToken(HttpServletRequest request) {
    	
    	 String token = request.getParameter(DEFAULT_TOKEN_NAME);

         if (StringUtils.isBlank(token)) {
             return false;
         }

        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute(DEFAULT_TOKEN_NAME);

        if (!token.equals(sessionToken)) {
            return false;
        }

        session.removeAttribute(DEFAULT_TOKEN_NAME);

        return true;
    }
}
