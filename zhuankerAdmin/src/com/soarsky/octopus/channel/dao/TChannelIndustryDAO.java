package com.soarsky.octopus.channel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.channel.constant.ChannelContent;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TChannelIndustry;
import com.soarsky.octopus.utils.PageBean;

public class TChannelIndustryDAO extends BaseDAO  {
    
	
	/**
     * 分页查询所有行业
     * @author lw
     * @param  maxresult 每页最大条数
     * @param  currentpage 当前页数
     * @param  channelIndustry 要查询的对象
     * @return
	*/
	public PageBean findChannelIndustryList(int maxresult, int currentpage,TChannelIndustry channelIndustry) {
		
		Criteria crit=this.getSession().createCriteria(TChannelIndustry.class).add(Restrictions.eq("isRemove",ChannelContent.NOTROMOVE));
		
		return this.queryForPageByParams(maxresult, currentpage, crit);
	}
     
	/**
	 * 查询所有的行业对象
	 * @author lw
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TChannelIndustry> queryAllChannelIndustry() {
		
		Criteria crit=this.getSession().createCriteria(TChannelIndustry.class).add(Restrictions.eq("isRemove",ChannelContent.NOTROMOVE));
		
		List<TChannelIndustry> list=crit.list();
		
		if(list.size()!=0){
			
			return list;
		}
		return null;
	}
	
	/**
	 * 根据行业名称查询行业
	 * @param channelIndustry 行业对象
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public Boolean findIndustryByName(TChannelIndustry channelIndustry) {
		
		Criteria crit=this.getSession().createCriteria(TChannelIndustry.class).add(Restrictions.eq("name",channelIndustry.getName())).add(Restrictions.eq("isRemove",ChannelContent.NOTROMOVE));
		
		List<TChannelIndustry> list=crit.list();
		
		if(list.size()>0){
			
			return true;
			
		}
		
		return false;
	}
}