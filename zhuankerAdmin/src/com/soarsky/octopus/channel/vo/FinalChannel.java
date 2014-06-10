package com.soarsky.octopus.channel.vo;

import java.util.Date;

public class FinalChannel {
	
	private String userName; //账户	
    
	private Date registDate;  //注册时间
	
	private Integer  totalTaskNum;  //总任务数		
	
	private String  Phone;     //	手机
	
	private String email;    //邮箱

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	
	public Integer getTotalTaskNum() {
		return totalTaskNum;
	}

	public void setTotalTaskNum(Integer totalTaskNum) {
		this.totalTaskNum = totalTaskNum;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
