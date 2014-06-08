package com.openframe.common.page;

import java.util.List;
import java.util.Map;

/**
 * 分页bean
 * @author chenll
 *
 */
public class PageBean {
	
	public static int DEFAULTPAGESIZE = 10;
	private List list;// 数据列表
	private long totalCount;//总条数
	private long totalPage;// 总页数
	private int pageNum = 1;
	
	private int pageSize=0;
	
	private String targetType;
	
	private int pageNumShown=10;//页标数字显示多少个
	
	/**
	 * 查询条件,用户组装需要输入的查询条件
	 */
	private Map condition;
	
	private String orderField;
	private String orderDirection;
	
	public int getPageSize() {
		return pageSize > 0 ? pageSize : DEFAULTPAGESIZE;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	
	

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public long getTotalPage() {
		long totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0){
			totalPage++;
		}
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}






	/**
	 * 计算总页数
	 * @param pageSize
	 * @param allRow
	 * @return
	 */
	public static int countTotalPage(final int pageSize, final int allRow) {
		int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow
				/ pageSize + 1;
		return totalPage;
	}
	

	/**
	 * 计算当前从第几条记录开始，即偏移量
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public static int countOffset(final int pageSize, final int currentPage) {
		final int offset = pageSize * (currentPage - 1);
		return offset;
	}

	/**
	 * 计算当前是第几页
	 * @param page
	 * @return
	 */
	public static int countCurrentPage(int page) {
		final int curPage = (page == 0 ? 1 : page);
		return curPage;
	}

	public Map getCondition() {
		return condition;
	}

	public void setCondition(Map condition) {
		this.condition = condition;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}


	public int getPageNumShown() {
		return pageNumShown;
	}

	public void setPageNumShown(int pageNumShown) {
		this.pageNumShown = pageNumShown;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


}
