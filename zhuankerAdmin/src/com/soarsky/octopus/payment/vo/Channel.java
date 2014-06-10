package com.soarsky.octopus.payment.vo;

/**
 * 用于后台服务器与页面通信时封装渠道简要信息：id和名字
 * @author ouyang
 *
 */
public class Channel {
	
	private Long channelId;//
	
    private String channelName;

	public Channel() {
		super();
	}

	public Channel(Long channelId, String channelName) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
    
}
