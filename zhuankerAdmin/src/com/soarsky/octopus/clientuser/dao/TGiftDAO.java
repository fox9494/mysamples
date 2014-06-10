package com.soarsky.octopus.clientuser.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.channel.constant.ChannelContent;
import com.soarsky.octopus.clientuser.constant.ClientUserContent;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TGift;
import com.soarsky.octopus.utils.PageBean;


public class TGiftDAO extends BaseDAO  {
	
	/**
     *分页查询礼物信息
     *@author lw
     *@param  maxresult 每页最大条数
    * @param  currentPage 当前页数
    * @return
	 */
	public PageBean findAllGift(int maxresult, int currentPage) {
		
		Criteria crit=this.getSession().createCriteria(TGift.class).add(Restrictions.eq("isRemove", ClientUserContent.NOTROMOVE));
		
		return this.queryForPageByParams(maxresult, currentPage, crit);
	}

	/**
	 * 根据礼物名查找礼物对象
	 * @author lw
	 * @param gift 礼物对象
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public Boolean findGiftByName(TGift gift) {
		
		Criteria crit=this.getSession().createCriteria(TGift.class).add(Restrictions.eq("giftName", gift.getGiftName())).add(Restrictions.eq("isRemove",ChannelContent.NOTROMOVE));
		
		List<TGift>gifts=crit.list();
		
		if(gifts.size()>0){
			
			return true;
			
		}
		
		return false;
	}
	
	
}