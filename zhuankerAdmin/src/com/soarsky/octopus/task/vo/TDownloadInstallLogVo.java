package com.soarsky.octopus.task.vo;

public class TDownloadInstallLogVo {
	
	private String userName;
	
	private String nickName;
	
	private String operateDate;
	
	public TDownloadInstallLogVo() {
		
	}
	
	public TDownloadInstallLogVo(String userName, String nickName,
			String operateDate) {
		super();
		this.userName = userName;
		this.nickName = nickName;
		this.operateDate = operateDate;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	} 
}
