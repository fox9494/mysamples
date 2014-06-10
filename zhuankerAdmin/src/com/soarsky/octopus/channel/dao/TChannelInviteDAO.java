package com.soarsky.octopus.channel.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TChannelInvite;
import com.soarsky.octopus.utils.PageBean;

public class TChannelInviteDAO extends BaseDAO  {
    
	/**
	 * 分页得到所有推送信息
	 * @author lw
	 * @param maxresult  每页最大条数
	 * @param currentPage 当前页数
	 * @return
	*/
	public PageBean findAllInviteByPage(int maxresult, int currentPage,Long channelId) {
		
		Criteria crit=this.getSession().createCriteria(TChannelInvite.class).createCriteria("TChannel").add(Restrictions.eq("id", channelId));
		
		return this.queryForPageByParams(maxresult, currentPage, crit);
	}
	
	
}