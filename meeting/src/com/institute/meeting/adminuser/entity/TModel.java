package com.institute.meeting.adminuser.entity;

import java.util.Set;

/**
 * TAdminusers entity. @author MyEclipse Persistence Tools
 */

public class TModel implements java.io.Serializable {

	//模块id
	private Integer modelId;
	
	//模块名
	private String  name;
	
	//模块编码
	private String  code;
	
	private String type;  //类型  0-菜单模块,1-非菜单模块
	
	private Integer order;//序号
	
	private String url; //菜单的url
	
	private Set<TModel> modelSet;
	
	//父模块
	private TModel  parent;
	
	private String icon;//导航图标

	// Constructors

	/** default constructor */
	public TModel() {
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<TModel> getModelSet() {
		return modelSet;
	}

	public void setModelSet(Set<TModel> modelSet) {
		this.modelSet = modelSet;
	}

	public TModel getParent() {
		return parent;
	}

	public void setParent(TModel parent) {
		this.parent = parent;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}




}