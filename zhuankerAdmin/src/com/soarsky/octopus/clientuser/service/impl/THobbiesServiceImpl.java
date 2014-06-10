package com.soarsky.octopus.clientuser.service.impl;

import java.util.List;

import com.soarsky.octopus.clientuser.constant.ClientUserContent;
import com.soarsky.octopus.clientuser.dao.THobbiesDAO;
import com.soarsky.octopus.clientuser.service.THobbiesService;
import com.soarsky.octopus.clientuser.vo.HobbiesVo;
import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.utils.PageBean;

public class THobbiesServiceImpl implements THobbiesService {
	
	private THobbiesDAO tHobbiesDAO;
    
	/**
	 * 添加爱好
	 * @author lw
	 * @param  hobbies 要添加的爱好对象
	*/
	public void addHobbies(THobbies hobbies) {
		
		tHobbiesDAO.save(hobbies);
	}

	/**
	 * 删除爱好信息
	 * @author lw
	 * @param  hobbies 要添加的爱好对象
	*/
	public void deleteHobbies(THobbies hobbies) {
		
		THobbies oldHobbies=initHobbies(hobbies);
		
		oldHobbies.setIsRemove(ClientUserContent.ROMOVE);
	
	}

	/**
	 * 修改爱好信息
	 * @author lw
	 * @param  hobbies 要添加的爱好对象
	*/
	public void editHobbies(THobbies hobbies) {
		
		tHobbiesDAO.update(hobbies);
	}

    /**
	 *初始化要修改的爱好对象
	 *@author lw
	 *@param  hobbies 要添加的爱好对象
	 *@return
	 */
	public THobbies initHobbies(THobbies hobbies) {
		
		return tHobbiesDAO.getById(THobbies.class,hobbies.getHobbiesid());
	}

    /**
     * 分页查询所有爱好信息
     * @author lw
     * @param  maxresult 没页最大条数
     * @param  currentPage 当前页数
     * @return
	*/
	public PageBean getHobbiesList(int maxresult, int currentPage) {
		
		return tHobbiesDAO.findAllHobbies(maxresult,currentPage);
	}
    
	/**
	 * 得到JSON格式的全部爱好信息
	 * @author lw
	 * @return
	*/
	public List<HobbiesVo> findAllHobbies() {
		
		return tHobbiesDAO.finAllHobbies();
	}
    
	/**
	 * 根据爱好名查找爱好
	 * @author lw
	 * @param hobbies 爱好对象
	 * @return
	*/
	public Boolean findHobbieByName(THobbies hobbies) {
		
		return tHobbiesDAO.findHobbieByName(hobbies);
	}

	public THobbiesDAO gettHobbiesDAO() {
		return tHobbiesDAO;
	}

	public void settHobbiesDAO(THobbiesDAO tHobbiesDAO) {
		this.tHobbiesDAO = tHobbiesDAO;
	}
    
}
