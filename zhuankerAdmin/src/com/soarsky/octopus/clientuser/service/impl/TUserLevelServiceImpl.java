package com.soarsky.octopus.clientuser.service.impl;

import com.soarsky.octopus.clientuser.constant.ClientUserContent;
import com.soarsky.octopus.clientuser.dao.TUserLevelDAO;
import com.soarsky.octopus.clientuser.service.TUserLevelService;
import com.soarsky.octopus.mapping.TUserLevel;
import com.soarsky.octopus.utils.PageBean;

public class TUserLevelServiceImpl implements TUserLevelService {
	
	private TUserLevelDAO tUserLevelDAO;
	
	/**
	 *删除赚客级别信息
	 *@author lw
	 *@param  userLevel 赚客级别对象  
	 */
	public void deleteUserLevel(TUserLevel userLevel) {
		
		TUserLevel oldUserLevel=initUserLevel(userLevel);
		
		oldUserLevel.setIsRemove(ClientUserContent.ROMOVE);
		
	}

    /**
	 *添加赚客级别信息
	 *@author lw
	 *@param  userLevel 赚客级别对象  
	 */
	public void addUserLevel(TUserLevel userLevel) {
		
		tUserLevelDAO.save(userLevel);
	}
	
   /**
    * 分页查询所有赚客级别信息
    * @author lw
    * @param  maxresult 每页最大条数
    * @param  currentPage 当前页数
    * @return
    */
	public PageBean getUserLevelList(int maxresult, int currentPage) {
		
		return tUserLevelDAO.findAllUserLevel(maxresult,currentPage);
	}

    /**
     * 初始化赚客修改对象
     * @author lw
     * @param  userLevel 赚客级别对象  
     * @return
	*/
	public TUserLevel initUserLevel(TUserLevel userLevel) {
		
		return tUserLevelDAO.getById(TUserLevel.class,userLevel.getId());
	}
    
	/**
	 *修改赚客级别对象
	 *@author lw
	 *@param  userLevel 赚客级别对象  
	 */
	public void updateUserLevel(TUserLevel userLevel) {
	
		tUserLevelDAO.update(userLevel);
	}
	
	/**
	 * 根据级别名查找赚客级别对象
	 * @author lw
	 * @param userLevel 修改的级别对象
	 * @return
	*/
	public Boolean findUserLevelByName(TUserLevel userLevel) {
		
		return tUserLevelDAO.findLevelByName(userLevel);
	}
     
	/**
	 * 根据金币数查找赚客级别对象
	 * @author lw
	 * @param userLevel 修改的级别对象
	 * @return
	*/
	public boolean findUserLevelByGOld(TUserLevel userLevel) {
	
		return tUserLevelDAO.findLevelByGold(userLevel);
	}

	public TUserLevelDAO gettUserLevelDAO() {
		return tUserLevelDAO;
	}

	public void settUserLevelDAO(TUserLevelDAO tUserLevelDAO) {
		this.tUserLevelDAO = tUserLevelDAO;
	}

}
