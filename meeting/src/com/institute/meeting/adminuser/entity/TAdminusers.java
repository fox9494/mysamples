package com.institute.meeting.adminuser.entity;

import java.util.Date;

/**
 * TAdminusers entity. @author MyEclipse Persistence Tools
 */

public class TAdminusers implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userAccount;
	private String userPassword;
	private Date createDate;
	private Date editDate;

	// Constructors

	/** default constructor */
	public TAdminusers() {
	}

	/** full constructor */
	public TAdminusers(String userAccount, String userPassword,
			 Date createDate, Date editDate) {
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.createDate = createDate;
		this.editDate = editDate;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getEditDate() {
		return this.editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

}