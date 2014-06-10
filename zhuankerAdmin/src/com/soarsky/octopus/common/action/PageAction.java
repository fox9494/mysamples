package com.soarsky.octopus.common.action;

import com.soarsky.octopus.utils.PageBean;

/**
 * 分页action,如果页面需要查询分页则继承此action
 * @author chenll
 *
 */
public class PageAction extends BaseAction {

	private static final long serialVersionUID = -8277835494861999940L;

	protected PageBean pageBean;
	
	protected Integer currentPage=1;

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	//设置当前页面如果为空，则置为第一页
	public void setCurrentPage(Integer currentPage) {
		if (currentPage==null){
			this.currentPage=1;
		}else{
			this.currentPage = currentPage;
		}
	}

}
