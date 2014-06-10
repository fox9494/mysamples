package com.soarsky.octopus.clientuser.service;

import com.soarsky.octopus.mapping.TUserLevel;
import com.soarsky.octopus.utils.PageBean;

public interface TUserLevelService {
   
	/**
	 * 删除级别信息
	 * @param userLevel 要删除的级别对象
	*/
	public void deleteUserLevel(TUserLevel userLevel);
	
	/**
	 * 添加级别信息
	 * @param userLevel 要添加的级别对象
	*/
	public void addUserLevel(TUserLevel userLevel);
	
	/**
	 * 分页得到所有级别信息
	 * @param maxresult 每页最大条数
	 * @param currentPage 当前页数
	 * @return
	*/
	public PageBean getUserLevelList(int maxresult,int currentPage);
	
	/**
	 * 初始化级别对象(根据ID查找级别对象)
	 * @param  userLevel 要查找的级别对象
	 * @return 
	*/
	public TUserLevel initUserLevel(TUserLevel userLevel);
	
	/**
	 * 修改级别对象
	 * @param userLevel 修改的级别对象
	*/
	public void updateUserLevel(TUserLevel userLevel);
    
	/**
	 * 根据级别名查找赚客级别对象
	 * @param userLevel 修改的级别对象
	 * @return
	*/
	public Boolean findUserLevelByName(TUserLevel userLevel);
	
	/**
	 * 根据金币数查找赚客级别对象
	 * @param userLevel 修改的级别对象
	 * @return
	*/
	public boolean findUserLevelByGOld(TUserLevel userLevel);
}
