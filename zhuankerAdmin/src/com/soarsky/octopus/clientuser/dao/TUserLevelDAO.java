package com.soarsky.octopus.clientuser.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.channel.constant.ChannelContent;
import com.soarsky.octopus.clientuser.constant.ClientUserContent;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TUserLevel;
import com.soarsky.octopus.utils.PageBean;

public class TUserLevelDAO extends BaseDAO  {
     
	
	/**
	  * 分页查询所有赚客级别信息
	  * @author lw
	  * @param  maxresult 每页最大条数
	  * @param  currentPage 当前页数
	  * @return
	  */
	public PageBean findAllUserLevel(int maxresult, int currentPage) {
		
		Criteria crit=this.getSession().createCriteria(TUserLevel.class).add(Restrictions.eq("isRemove",ClientUserContent.NOTROMOVE));
		
		return this.queryForPageByParams(maxresult, currentPage, crit);
	}
	
	/**
	 * 根据级别名查找赚客级别对象
	 * @author lw
	 * @param userLevel 修改的级别对象
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public Boolean findLevelByName(TUserLevel userLevel) {
		
		Criteria crit=this.getSession().createCriteria(TUserLevel.class).add(Restrictions.eq("name", userLevel.getName())).add(Restrictions.eq("isRemove",ChannelContent.NOTROMOVE));
		
		List<TUserLevel>userLevels=crit.list();
		
		if(userLevels.size()>0){
			
			return true;
			
		}
		
		return false;
	}
	
	/**
	 * 根据金币数查找赚客级别对象
	 * @author lw
	 * @param userLevel 修改的级别对象
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public boolean findLevelByGold(TUserLevel userLevel) {
		
        Criteria crit=this.getSession().createCriteria(TUserLevel.class).add(Restrictions.eq("goldNum", userLevel.getGoldNum())).add(Restrictions.eq("isRemove",ChannelContent.NOTROMOVE));
		
		List<TUserLevel>userLevels=crit.list();
		
		if(userLevels.size()>0){
			
			return true;
			
		}
		
		return false;
	}
}