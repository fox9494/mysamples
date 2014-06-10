package com.soarsky.octopus.reports.vo;

/**
 * 统计报表相关数据封装类
 * @author ouyang
 *
 */
public class StatisticsReport {
	
	public static final int TYPE_INSTALL = 1;
	
	private Long companyId;
	
	private String companyName;
	
	private Long appId;
	
	private String appName;
	
	private Long  appInstalls;
	
	private Long appDownloads;
	
	private Long downFlowNum;
	
	private Long upFlowNum;
	
	public StatisticsReport() {
		super();
	}
	
	public StatisticsReport(Long companyId, String companyName, Long appId,
			String appName, Long appInstalls, Long appDownloads,
			Long downFlowNum, Long upFlowNum) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.appId = appId;
		this.appName = appName;
		this.appInstalls = appInstalls;
		this.appDownloads = appDownloads;
		this.downFlowNum = downFlowNum;
		this.upFlowNum = upFlowNum;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Long getAppInstalls() {
		return appInstalls;
	}

	public void setAppInstalls(Long appInstalls) {
		this.appInstalls = appInstalls;
	}

	public Long getAppDownloads() {
		return appDownloads;
	}

	public void setAppDownloads(Long appDownloads) {
		this.appDownloads = appDownloads;
	}

	public Long getDownFlowNum() {
		return downFlowNum;
	}

	public void setDownFlowNum(Long downFlowNum) {
		this.downFlowNum = downFlowNum;
	}

	public Long getUpFlowNum() {
		return upFlowNum;
	}

	public void setUpFlowNum(Long upFlowNum) {
		this.upFlowNum = upFlowNum;
	}
	
}
