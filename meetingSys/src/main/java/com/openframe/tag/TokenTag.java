package com.openframe.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.openframe.utils.TokenUtil;

/**
 * 用于生成token，防止重复提交
 * @author chenll
 */
public class TokenTag extends TagSupport {

	private static final long serialVersionUID = 6942009556640612078L;

	Logger log = Logger.getLogger(TokenTag.class);  
	
    
    
    @Override  
    public int doStartTag() throws JspException {  
    	
        String html = "<input type=\"hidden\" value=\""+TokenUtil.setToken((HttpServletRequest)this.pageContext.getRequest())+"\" name=\""+TokenUtil.DEFAULT_TOKEN_NAME+"\">";
       
        try {  
            this.pageContext.getOut().print(html);  
        } catch (IOException e) {  
            log.error(e.getMessage());  
            e.printStackTrace();  
        }  
        
        return super.doStartTag();  
    }  
  
  


}
