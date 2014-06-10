package com.soarsky.octopus.clientuser.service.impl;

import com.soarsky.octopus.clientuser.constant.ClientUserContent;
import com.soarsky.octopus.clientuser.dao.TGiftDAO;
import com.soarsky.octopus.clientuser.service.TGiftService;
import com.soarsky.octopus.mapping.TGift;
import com.soarsky.octopus.utils.PageBean;

public class TGiftServiceImpl implements TGiftService {
   
	private TGiftDAO tGiftDAO;
    
	/**
     *添加礼物信息
     *@author lw
     *@param  gift 要添加的礼物 对象
	*/
	public void addGift(TGift gift) {
		
		tGiftDAO.save(gift);
	}
	
    /**
     *删除礼物信息
     *@author lw
     *@param  gift 要删除的礼物 对象 
	 */
	public void deleteGift(TGift gift) {
		
		TGift oldGift=initGift(gift);
		
		oldGift.setIsRemove(ClientUserContent.ROMOVE);
		
	}
    /**
     *分页查询礼物信息
     *@author lw
     *@param  maxresult 每页最大条数
    * @param  currentPage 当前页数
    * @return
	 */
	public PageBean getGiftList(int maxresult, int currentPage) {
		
		return tGiftDAO.findAllGift(maxresult,currentPage);
	}
	
   /**
    *初始化修改礼物对象
    *@author lw
    *@param  gift 要删除的礼物 对象 
    *@return
	*/
	public TGift initGift(TGift gift) {
		
		return tGiftDAO.getById(TGift.class, gift.getId());
	}
   /**
    * 修改礼物对象
    * @author lw
    * @param  gift 要删除的礼物 对象
	*/
	public void editGift(TGift gift) {
		
		tGiftDAO.update(gift);
	}
    
	/**
	 * 根据礼物名查找礼物对象
	 * @author lw
	 * @param gift 礼物对象
	 * @return
	*/
	public Boolean findGiftByName(TGift gift) {
		
		return tGiftDAO.findGiftByName(gift);
	}

	public TGiftDAO gettGiftDAO() {
		return tGiftDAO;
	}

	public void settGiftDAO(TGiftDAO tGiftDAO) {
		this.tGiftDAO = tGiftDAO;
	}
	
	
}
