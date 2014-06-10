package com.soarsky.octopus.common.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.soarsky.octopus.common.interceptor.ExceptionInterceptor;
import com.soarsky.octopus.exception.NameException;
import com.soarsky.octopus.utils.ConfigUtil;
import com.soarsky.octopus.utils.PathUtil;

/**
 * action基础类，用于封装action公用的一些变量或者方法，
 * 该类应该被本项目中的其他action类继承。该类继承actionsupport
 * 并实现ServletRequestAware和ServletResponseAware两个拦截器接口
 * 该类的子类中可以使用request和response对象
 */
@SuppressWarnings("serial")
public abstract class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	
	private static final String UPLOAD = "upload";//上传文件目录名
	
	private static final String TOMCAT = "tomcat";//服务器名
	private static final String JBOSS = "jboss";//

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private static Logger logger = Logger.getLogger(BaseAction.class);

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	/** 
     *搜索：列表 
     *建议return SUCCESS. 
     */  
    public String searchList(){
    	return SUCCESS;
    };  
    
    
    /** 
     *搜索详情 
     *建议return SUCCESS. 
     */  
    public  String searchDetail(){
    	return SUCCESS;
    };
  
    /** 
     * 显示新增或修改Entity界面调用. 
     * 读取、初始化数据
     * 建议return INPUT. 
     */  
    public  String input(){
    	return INPUT;  
    }
  
    /** 
     * 新增或修改Entity
     * 添加保存:
	 * 当执行 添加、保存 数据时
     */  
    public  String save(){
    	return SUCCESS;  
    }
  
    /** 
     * 删除保存
     */  
    public  String delete(){
    	return SUCCESS;  
    }
    
    /**
     * 得到session对象
     * @return
     */
    public Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}
	
	
    /**
	 * 得到上传文件的目录路径
	 * @return
     * @throws NameException 
	 */
	public String getUploadPath()   {
//		String serverName = ServletActionContext.getServletContext().getServerInfo().toLowerCase();
//		String root = ServletActionContext.getServletContext().getRealPath("/");
//		logger.info("the server is "+serverName+",the path is "+root);
//		String path="";
//		if (serverName.contains(TOMCAT)){
//			path = root.substring(0, root.indexOf("webapps"));
//			path = path+UPLOAD+"/";
//		}
//		
//		if (serverName.contains(JBOSS)){
//			path = root.substring(0, root.indexOf("standalone"));
//			path = path+"welcome-content/"+UPLOAD+"/";
//		}
		return PathUtil.getUploadBasePath();
	}

}
