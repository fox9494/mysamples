package com.soarsky.octopus.channel.service;

import java.util.List;

import com.soarsky.octopus.mapping.TChannelIndustry;
import com.soarsky.octopus.utils.PageBean;

public interface TChannelIndustryService {
	
	/**
	 * 添加行业
	 * @param channelIndustry 行业对象
	*/
	public void addChannelIndustry(TChannelIndustry channelIndustry);
	
	/**
	 * 删除行业对象
	 * @param channelIndustry 行业对象
	*/
	public void deleteChannelIndustry(TChannelIndustry channelIndustry);
	
	/**
	 * 分页查询所有行业对象
	 * @param maxresult 每页最大条数
	 * @param currentpage 当前页数
	 * @param channelIndustry 行业对象
	 * @return
 	*/
	public PageBean getChannelIndustryList(int maxresult,int currentpage,TChannelIndustry channelIndustry);
	
	/**
	 * 修改行业对象
	 * @param channelIndustry 行业对象
	*/
	public void updateChannelIndustry(TChannelIndustry channelIndustry);
	
	/**
	 * 初始化行业对象(根据ID查询行业对象)
	 * @param channelIndustry 行业对象
	 * @return
	*/
	public TChannelIndustry initChannelIndustry(TChannelIndustry channelIndustry);
    
	/**
	 * 查询所有行业信息
	 * @return
	*/
	public List<TChannelIndustry> findAllChannelIndustry();
	
	/**
	 * 根据行业名称查询行业
	 * @return
	*/
	public Boolean findChannelIndustryByName(TChannelIndustry channelIndustry);
}
