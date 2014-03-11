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
	private long rowCount; // 总条数
	private long totalPage;// 总页数
	private int currentPage = 1;// 当前页码
	private int pageSize = 10;// 每页条数

	private boolean isFirstPage;// 是否是第一页
	private boolean isLastPage;// 是否是最后一页
	private boolean hasPreviousPage;//是否有上一页
	private boolean hasNextPage;// 是否有下一页
	
	
	
	/**
	 * 查询条件,用户组装需要输入的查询条件
	 */
	private Map condition;

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public long getTotalPage() {
		long totalPage=rowCount/pageSize;
		if(rowCount%pageSize!=0){
			totalPage++;
		}
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 初始化
	 */
	public void init() {
		this.isFirstPage = isFirstPage();
		this.isLastPage = isLastPage();
		this.hasPreviousPage = isHasPreviousPage();
		this.hasNextPage = isHasNextPage();
	}


	public boolean isFirstPage() {
		return currentPage == 1;
	}

	public boolean isLastPage() {
		return currentPage == totalPage;
	}

	public boolean isHasPreviousPage() {
		return currentPage != 1;//不是第一页则都有上一页
	}

	public boolean isHasNextPage() {
		return currentPage != totalPage;//
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

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

}
