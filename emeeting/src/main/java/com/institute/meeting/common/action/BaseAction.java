package com.institute.meeting.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author ace wang action基础类，用于封装action公用的一些变量或者方法，
 *         该类应该被本项目中的其他action类继承。该类继承actionsupport
 *         并实现ServletRequestAware和ServletResponseAware两个拦截器接口
 *         该类的子类中可以使用request和response对象
 */
@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	protected HttpServletRequest request;
	protected HttpServletResponse response;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	/**
	 * 得到上传图片的目录路径
	 * @return
	 */
	public String getImagePath(){
		String root = ServletActionContext.getServletContext().getRealPath("/");
		String tomcat = root.substring(0, root.indexOf("webapps"));
		
		return tomcat+"gxupload/";
	}

}
