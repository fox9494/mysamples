package com.soarsky.octopus.tag;



import javax.servlet.jsp.JspException;

import com.soarsky.octopus.utils.PrivilegeUtil;


/**
 * Description:
 * 权限判断IF标签
 * @author chenlile
 * 
 */
public class RightIf extends RightTag{

	private static final long serialVersionUID = 2395056514308179093L;

	@Override
	public int doStartTag() throws JspException {
		if(PrivilegeUtil.validateUserRight(getRightCode())){
			pageContext.setAttribute("_iftag_rightCode", getRightCode());
			return EVAL_BODY_INCLUDE;
		}else{
			return SKIP_BODY;
		}
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
	
	
}
