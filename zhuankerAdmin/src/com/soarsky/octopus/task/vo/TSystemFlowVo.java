package com.soarsky.octopus.task.vo;

public class TSystemFlowVo {
	
	private String userName;
	
	private Long downNum;
	 
    private Long upNum;
     
    private String reportDate;

	public TSystemFlowVo() {
		
	}

	public TSystemFlowVo(String userName, Long downNum, Long upNum,
			String reportDate) {
		super();
		this.userName = userName;
		this.downNum = downNum;
		this.upNum = upNum;
		this.reportDate = reportDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getDownNum() {
		return downNum;
	}

	public void setDownNum(Long downNum) {
		this.downNum = downNum;
	}

	public Long getUpNum() {
		return upNum;
	}

	public void setUpNum(Long upNum) {
		this.upNum = upNum;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	} 
}
