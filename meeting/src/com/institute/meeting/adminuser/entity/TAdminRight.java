package com.institute.meeting.adminuser.entity;


/**
 * TAdminusers entity. @author MyEclipse Persistence Tools
 */

public class TAdminRight implements java.io.Serializable {

	//权限id
	private Integer rightId;
	
	//角色名
	private TAdminRole  role;
	
	//权限名
	private TModel  model;

	// Constructors

	/** default constructor */
	public TAdminRight() {
	}

	public Integer getRightId() {
		return rightId;
	}

	public void setRightId(Integer rightId) {
		this.rightId = rightId;
	}

	public TAdminRole getRole() {
		return role;
	}

	public void setRole(TAdminRole role) {
		this.role = role;
	}

	public TModel getModel() {
		return model;
	}

	public void setModel(TModel model) {
		this.model = model;
	}



}