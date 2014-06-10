package com.soarsky.octopus.tag;



import javax.servlet.jsp.tagext.TagSupport;

/**
 * Description:
 * 权限标签
 * @author chenlile
 * 
 */
public class RightTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 权限码
	 */
	private String rightCode;
	
	public String getRightCode() {
		return rightCode;
	}
	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}
}
