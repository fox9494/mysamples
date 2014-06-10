package com.soarsky.octopus.clientuser.service;

import com.soarsky.octopus.mapping.TGift;
import com.soarsky.octopus.utils.PageBean;

public interface TGiftService {
    
	/**
	 * 添加礼物信息
	 * @param gift 礼物对象
	*/
	public void addGift(TGift gift);
	
	/**
	 * 删除礼物信息
	 * @param gift 礼物对象
	*/
	public void deleteGift(TGift gift);
	
	/**
	 * 分页查询所有礼物信息
	 * @param maxresult 每页最大条数
	 * @param currentPage 当前页数
	 * @return
    */
	public PageBean getGiftList(int maxresult,int currentPage);
	
	/**
	 * 初始化礼物对象(根据ID查询礼物对象)
	 * @param gift 礼物对象
	 * @return
	*/
	public TGift initGift(TGift gift);
	
	/**
	 * 修改礼物对象
	 * @param gift 礼物对象
	*/
	public void editGift(TGift gift);
	
	/**
	 * 根据礼物名查找礼物对象
	 * @param gift 礼物对象
	 * @return
	*/
	public Boolean findGiftByName(TGift gift);
}
