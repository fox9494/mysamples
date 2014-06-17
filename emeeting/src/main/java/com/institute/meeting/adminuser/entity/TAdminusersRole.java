package com.institute.meeting.adminuser.entity;



public class TAdminusersRole implements java.io.Serializable {

	// Fields

	private Integer userRoleID;
	private Integer userId;
	private Integer roleId;

	// Constructors

	/** default constructor */
	public TAdminusersRole() {
	}

	/** full constructor */
	public TAdminusersRole(Integer userRoleID, Integer userId,
			 Integer roleId) {
		this.userRoleID = userRoleID;
		this.userId = userId;
		this.roleId = roleId;
	}

	public Integer getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(Integer userRoleID) {
		this.userRoleID = userRoleID;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}



}