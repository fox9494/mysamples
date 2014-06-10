package com.soarsky.octopus.channel.service.impl;

import java.util.List;

import com.soarsky.octopus.channel.dao.TChannelInviteDAO;
import com.soarsky.octopus.channel.service.TChannelInviteService;
import com.soarsky.octopus.mapping.TChannelInvite;
import com.soarsky.octopus.utils.PageBean;

public class TChannelInviteServiceImpl implements TChannelInviteService {
	
	private TChannelInviteDAO tChannelInviteDAO;
	
	

	/**
	 * 添加推送
	 * @author lw
	 * @param channelInvite 要推送的对象
	*/
	public void addChannelInvite(TChannelInvite channelInvite) {
		
		tChannelInviteDAO.save(channelInvite);
	}

	/**
	 * 导入Excel添加推送信息
	 * @author lw
	 * @param channelInvites 推送对象集合
	*/
	public void addBatchChannelInvite(List<TChannelInvite> channelInvites) {
		
		tChannelInviteDAO.batchAdd(channelInvites);
	}

	/**
	 * 分页得到所有推送信息
	 * @author lw
	 * @param maxresult  每页最大条数
	 * @param currentPage 当前页数
	 * @return
	*/
	public PageBean findAllChannelInvite(int maxresult, int currentPage,Long channelId) {
		
		return tChannelInviteDAO.findAllInviteByPage(maxresult, currentPage,channelId);
	}

	public TChannelInviteDAO gettChannelInviteDAO() {
		return tChannelInviteDAO;
	}

	public void settChannelInviteDAO(TChannelInviteDAO tChannelInviteDAO) {
		this.tChannelInviteDAO = tChannelInviteDAO;
	}
	
	

}
