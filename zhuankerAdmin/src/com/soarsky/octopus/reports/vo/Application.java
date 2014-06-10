package com.soarsky.octopus.reports.vo;

public class Application {
	
	private Long appId;
	
	private String appName;

	public Application() {
		super();
	}

	public Application(Long appId, String appName) {
		super();
		this.appId = appId;
		this.appName = appName;
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
	
	
	
}
