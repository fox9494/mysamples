package com.soarsky.octopus.manager.vo;



import java.util.List;

public class MenuVO {
	
	
	private Long id;
	
	private Long parentId;
	
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

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
