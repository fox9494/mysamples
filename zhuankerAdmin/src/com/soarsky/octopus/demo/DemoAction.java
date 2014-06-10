package com.soarsky.octopus.demo;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.utils.PageBean;

public class DemoAction extends BaseAction {

	private static final long serialVersionUID = -1118706453842061276L;
	
	private String[]  right;
	private String[] left;
	
	private int currentPage=1;
	
	private PageBean pageBean;
	
//	private DemoService  demoService;
	
	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String[] getRight() {
		return right;
	}

	public void setRight(String[] right) {
		this.right = right;
	}

	public String[] getLeft() {
		return left;
	}

	public void setLeft(String[] left) {
		this.left = left;
	}

	@Override
	public String execute() throws Exception {
		
//		ApplicationContext  context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		
		
//		pageBean = demoService.queryByPage(currentPage);
//		BaseDaoImpl baseDao = (BaseDaoImpl) context.getBean("baseDao");
		test="hello";
		
//		PrintWriter stream=ServletActionContext.getResponse().getWriter();
//		stream.write("1");
		System.out.println("finish");
		
		return SUCCESS;
	}

	
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String input() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchList() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	
	
	
	

}


