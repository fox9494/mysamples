package com.soarsky.octopus.clientuser.service;

import java.util.List;

import com.soarsky.octopus.clientuser.vo.HobbiesVo;
import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.utils.PageBean;

public interface THobbiesService {

	/**
	 * 添加爱好信息
	 * @param hobbies 爱好对象
	*/
	public void addHobbies(THobbies hobbies);
	
	/**
	 * 删除爱好信息
	 * @param hobbies 爱好对象
	*/
	public void deleteHobbies(THobbies hobbies);
	
	/**
	 * 修改爱好信息
	 * @param hobbies 爱好对象
	*/
	public void editHobbies(THobbies hobbies);
	
	/**
	 * 初始化爱好对象(根据ID查询爱好)
	 * @param hobbies 爱好对象
	 * @return
	*/
	public THobbies initHobbies(THobbies hobbies);
	
	/**
	 * 分页查询所有爱好信息
	 * @param maxresult 每页最大条数
	 * @param currentPage 当前页数
	 * @return
	*/
	public PageBean getHobbiesList(int maxresult,int currentPage);
    
	/**
	 * 查询所有爱好信息
	 * @return
	*/
	public List<HobbiesVo> findAllHobbies();
	
	/**
	 * 根据爱好名查找爱好
	 * @param hobbies 爱好对象
	 * @return
	*/
	public Boolean findHobbieByName(THobbies hobbies);
}
