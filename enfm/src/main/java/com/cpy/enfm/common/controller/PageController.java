package com.cpy.enfm.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.cpy.enfm.common.page.PageBean;
import com.cpy.enfm.utils.BeanUtil;

/**
 * 分页控制bean
 * @author chenll
 *
 */
public class PageController {
	
	public static final int FIRSTPAGE = 1;

	
	/**
	 * 得到分页对象用于查询
	 * @param obj   条件对象
	 * @param request 请求对象
	 * @return  PageBean   分页对象
	 */
	protected PageBean getPageBean(Object obj,HttpServletRequest request){
		PageBean pageBean=new PageBean();
		pageBean.setCondition(BeanUtil.bean2Map(obj));
		int currentPageNumber=FIRSTPAGE;
		try{
			 currentPageNumber = StringUtils.isBlank(request.getParameter("currentPage"))?FIRSTPAGE:Integer.parseInt(request.getParameter("currentPage"));
		}catch(Exception e){
			 currentPageNumber = FIRSTPAGE;
		}
	    
	    if(currentPageNumber <1){//防止负数和0 的出现
	    	currentPageNumber = FIRSTPAGE;
	    }
	    pageBean.setCurrentPage(currentPageNumber);
		return pageBean;
	}
}
