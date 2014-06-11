package com.institute.meeting.adminuser.entity;

import java.util.Date;
import java.util.Set;

/**
 * TAdminusers entity. @author MyEclipse Persistence Tools
 */

public class TAdminRole implements java.io.Serializable {

	//角色id
	private Integer roleId;
	
	//角色名
	private String  roleName;
	
	private String remark;
	
	private Date createDate;

	
	private Set<TAdminRight>  roleRightSet;
	

	// Constructors

	/** default constructor */
	public TAdminRole() {
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Set<TAdminRight> getRoleRightSet() {
		return roleRightSet;
	}


	public void setRoleRightSet(Set<TAdminRight> roleRightSet) {
		this.roleRightSet = roleRightSet;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	

}