package com.soarsky.octopus.channel.service;

import java.util.List;

import com.soarsky.octopus.mapping.TChannelInvite;
import com.soarsky.octopus.utils.PageBean;

public interface TChannelInviteService {
   
	/**
	 * 添加推送
	 * @param channelInvite 要推送的对象
	*/
	public void  addChannelInvite(TChannelInvite channelInvite);
	
	/**
	 * 导入Excel添加推送信息
	 * @param channelInvites 推送对象集合
	*/
	public void  addBatchChannelInvite(List<TChannelInvite> channelInvites); 
	
	/**
	 * 分页得到所有推送信息
	 * @param maxresult  每页最大条数
	 * @param currentPage 当前页数
	 * @return
	*/
	public PageBean findAllChannelInvite(int maxresult,int currentPage,Long channelId);
}
