package com.institute.meeting.adminuser.vo;

import java.util.List;

public class MenuVO {
	
	
	private Integer id;
	
	private Integer parentId;
	
	private String title;
	
	private String width;
	
	private String href;
	
	private List<MenuVO> items;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}


	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public List<MenuVO> getItems() {
		return items;
	}

	public void setItems(List<MenuVO> items) {
		this.items = items;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	
	
	
	

}
