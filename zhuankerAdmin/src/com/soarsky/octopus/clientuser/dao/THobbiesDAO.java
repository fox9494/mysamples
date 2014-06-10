package com.soarsky.octopus.clientuser.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.channel.constant.ChannelContent;
import com.soarsky.octopus.clientuser.constant.ClientUserContent;
import com.soarsky.octopus.clientuser.vo.HobbiesVo;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.utils.PageBean;

public class THobbiesDAO extends BaseDAO  {
	
	/**
     * 分页查询所有爱好信息
     * @author lw
     * @param  maxresult 没页最大条数
     * @param  currentPage 当前页数
     * @return
	*/
	public PageBean findAllHobbies(int maxresult, int currentPage) {
		
		Criteria crit=this.getSession().createCriteria(THobbies.class).add(Restrictions.eq("isRemove", ClientUserContent.NOTROMOVE));
		
		return this.queryForPageByParams(maxresult, currentPage, crit);
	}
    
	/**
	 * 得到JSON格式的全部爱好信息
	 * @author lw
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public List<HobbiesVo> finAllHobbies() {
		
		Criteria crit=this.getSession().createCriteria(THobbies.class).add(Restrictions.eq("isRemove",ClientUserContent.NOTROMOVE));
		
		List<THobbies>thobbies=crit.list();
		
		List<HobbiesVo>thobbiesvo=new ArrayList<HobbiesVo>();
		
		if(thobbies.size()>0){
			
			for(THobbies th:thobbies){
				
				HobbiesVo hv=new HobbiesVo();
				
				hv.setHobbiesid(th.getHobbiesid());
				
				hv.setTagname(th.getTagname());
				
				thobbiesvo.add(hv);
			}
			
		}
		
		return thobbiesvo;
	}
	
	/**
	 * 根据爱好名查找爱好
	 * @author lw
	 * @param hobbies 爱好对象
	 * @return
	*/
	@SuppressWarnings("unchecked")
	public Boolean findHobbieByName(THobbies hobbies) {
		
		Criteria crit=this.getSession().createCriteria(THobbies.class).add(Restrictions.eq("tagname",hobbies.getTagname())).add(Restrictions.eq("isRemove",ChannelContent.NOTROMOVE));
		
		List<THobbies>thobbies=crit.list();
		
		if(thobbies.size()>0){
			
			return true;
			
		}
		
		return false;
	}
	
}