package com.soarsky.octopus.clientuser.vo;

import java.util.List;

public class TreeData {
	private String data;
	private Attr attr;
	private List<TreeData> children;
	private String statename;
	private String state;
	
	
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
	public List<TreeData> getChildren() {
		return children;
	}
	public void setChildren(List<TreeData> children) {
		this.children = children;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	
	
	

}
