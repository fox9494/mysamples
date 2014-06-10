package com.soarsky.octopus.clientuser.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.soarsky.octopus.clientuser.dao.TUserClientDAO;
import com.soarsky.octopus.clientuser.list.User;
import com.soarsky.octopus.clientuser.service.TUserClientService;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TArea;
import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.mapping.TUserGoldCount;
import com.soarsky.octopus.utils.PageBean;

public class TUserClientServiceImpl implements TUserClientService {
	
	private TUserClientDAO tUserClientDAO;
	
    /**
     * 分页查询所有用户
     * @author lw yl
     * @param  maxresult 每页最大条数
     * @param  currentpage 当前页数
     * @return
	*/
	public PageBean getUserClientList(int maxresult, int currentpage) {				
		PageBean pageBean= tUserClientDAO.findAllUserClient(maxresult,currentpage);	
		return getPageBean(pageBean);
	}
    
	/**
	 *根据条件查询用户
	 *@author lw yl
	 *@param  maxresult 每页最大条数
     *@param  currentpage 当前页数
     *@param  userclient  要查询的条件客户对象
	 *@return 
	*/
	public PageBean getUserClientByConditions(int maxresult,Integer currentPage, TUserClient userclient,List<THobbies> hobbies,Integer startAge,Integer endAge) {				
		PageBean pageBean= tUserClientDAO.findAllUserClientByConditions(maxresult,currentPage,userclient,hobbies, startAge, endAge);		
		return getPageBean(pageBean);
	}

    /**
     *查看用户详情
     *@author lw yl
     *@param  要查询的用户对象
     *@return 
	*/
	public TUserClient initUserClient(TUserClient userclient) {
		TUserClient user = tUserClientDAO.getById(TUserClient.class, userclient.getId());
		if(user!=null){
			TArea tarea =   user.gettArea();
			if(tarea!=null){
			    String name = 	tarea.getStatename();
			}	
			//懒加载
			Set<TUserGoldCount> gold = user.gettUserGoldCounts();
			for(TUserGoldCount set:gold){
				Long toltal = set.getTotal_gold();
			}
			
		}
		
		return user;
	}
	
	/**
	 * 根据用户的总金币数，判断级别
	 * @author yl
	 */
	public String getAllUserLevel(Long total) {
		
		return tUserClientDAO.getAllUserLevel(total);
	}
	/**
	 * 根据相应的pagebean再返回所需的pagebean
	 * @author yl
	 * @return
	 */
	private PageBean getPageBean(PageBean pageBean){
		List<User> list = new ArrayList<User>();
		List<TUserClient> userList = pageBean.getList();
		//赖加载
		for(TUserClient userClient:userList){
			User user = new User();
			Set<TUserGoldCount> gold = userClient.gettUserGoldCounts();
			for(TUserGoldCount set:gold){
				if(set.getTotal_gold()==null){
					user.setTotal_gold(JEEContant.INITGOLD);					
				}else{
					//当前金币
					user.setTotal_gold(set.getTotal_gold());
				}
				if(set.getCurrentGold()==null){
					user.setCurrent_gold(JEEContant.INITGOLD);					
				}else{
					user.setCurrent_gold(set.getCurrentGold());
				}
				String level = tUserClientDAO.getAllUserLevel(set.getTotal_gold());
				user.setLeveCode(level);
			}
			user.setEmail(userClient.getEmail());
			user.setId(userClient.getId());
			user.setNickName(userClient.getNickName());
			user.setPhone(userClient.getPhone());			
			user.setUserName(userClient.getUserName());
			list.add(user);
		}			
		pageBean.setList(list);
		return pageBean;
	}
	public TUserClientDAO gettUserClientDAO() {
		return tUserClientDAO;
	}

	public void settUserClientDAO(TUserClientDAO tUserClientDAO) {
		this.tUserClientDAO = tUserClientDAO;
	}



}
