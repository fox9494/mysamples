package com.soarsky.octopus.manager.vo;

import java.util.List;

public class TreeData {
	
	private String data;
	
	private Attr attr;
	
	private String state;
	
	private List<TreeData> children;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Attr getAttr() {
		return attr;
	}

	public void setAttr(Attr attr) {
		this.attr = attr;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<TreeData> getChildren() {
		return children;
	}

	public void setChildren(List<TreeData> children) {
		this.children = children;
	}

}

