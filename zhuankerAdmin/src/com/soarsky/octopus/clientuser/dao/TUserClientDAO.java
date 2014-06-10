package com.soarsky.octopus.clientuser.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.mapping.TUserLevel;
import com.soarsky.octopus.utils.PageBean;

public class TUserClientDAO extends BaseDAO {

	/**
	 * 分页查询所有用户
	 * 
	 * @author lw
	 * @param maxresult
	 *            每页最大条数
	 * @param currentpage
	 *            当前页数
	 * @return
	 */
	public PageBean findAllUserClient(int maxresult, int currentpage) {

		Criteria crit = this.getSession().createCriteria(TUserClient.class);
		return this.queryForPageByParams(maxresult, currentpage, crit);
	}

	/**
	 * 根据条件查询用户
	 * 
	 * @author lw yl
	 * @param maxresult
	 *            每页最大条数
	 * @param currentpage
	 *            当前页数
	 * @param userclient
	 *            要查询的条件客户对象
	 * @return
	 */
	public PageBean findAllUserClientByConditions(int maxresult,Integer currentPage, TUserClient userclient, List<THobbies> hobbies,Integer startAge,Integer endAge) {			
		Criteria crit=this.getSession().createCriteria(TUserClient.class);
		
		//根据用户查询
		if(StringUtils.isNotEmpty(userclient.getUserName().trim())){
			crit.add(Restrictions.like("userName", "%"+userclient.getUserName().trim()+"%"));
		}
		//根据区域查询,最好是判断id不要判断area
		if(userclient.gettArea()!=null){
			if(userclient.gettArea().getId()!=null){			
				crit.createCriteria("tArea").add(Restrictions.eq("id", userclient.gettArea().getId()));						
			}
		}		
		//如果性别为空，那么男女性别一起查询
		if(userclient.getSex()!=JEEContant.ALL){			
			crit.add(Restrictions.eq("sex", userclient.getSex()));
		}
		//根据年龄查询
		if(startAge!=null&&endAge!=null){
			crit.add(Restrictions.between("age", startAge,endAge));
		}
		//根据选择的爱好查询用户		
		if(hobbies!=null){
			List list=new ArrayList();
			for(THobbies ho:hobbies){				
					list.add(ho.getHobbiesid());				
			}
			//得到不重复的id集合
			List idList = getUsersIdList(list);				
				if(idList!=null){
							crit.add(Restrictions.in("id", idList));
				}	
		}
		
		return this.queryForPageByParams(maxresult, currentPage, crit);
	}
	/**
	 * 根据金币数，判断级别
	 * @author yl
	 */
	public String getAllUserLevel(Long total){
		Criteria crit = this.getSession().createCriteria(TUserLevel.class).add(Restrictions.between("goldNum", 0l, total)).add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE));
		List<TUserLevel> level = crit.list();
		if(level.size()>0){
			return level.get(level.size()-1).getName();
		}else{
			return JEEContant.INITLEVEL;
		}
			
	}
	/**
	 * 返回不重复的userid集合
	 * @param userClients
	 * @author yl
	 * @return
	 */
	private List getUsersIdList(List<Long> lists){
		List<TUserClient> userClients=this.getSession().createCriteria(TUserClient.class).createCriteria("tUserHobbieses").createCriteria("THobbies").add(Restrictions.in("hobbiesid",lists)).list();
		List<Long> list = new ArrayList<Long>();
		if(userClients!=null){
			for(TUserClient user:userClients){
				list.add(user.getId());
			}
		}	
		//id去除重复
		List idList = new ArrayList();
		Set set = new HashSet();		
		for(Iterator iter = list.iterator();iter.hasNext();){
				Object element = iter.next();
				if(set.add(element)){
					idList.add(element);
				}									
		}
		return idList;
	}
}