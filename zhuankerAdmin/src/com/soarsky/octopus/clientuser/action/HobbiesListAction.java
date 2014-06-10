package com.soarsky.octopus.clientuser.action;

import java.util.List;

import com.soarsky.octopus.clientuser.service.THobbiesService;
import com.soarsky.octopus.clientuser.vo.HobbiesVo;
import com.soarsky.octopus.common.action.PageAction;
import com.soarsky.octopus.utils.PageBean;

public class HobbiesListAction extends PageAction {

	private static final long serialVersionUID = 6105039721144244359L;
	
	private THobbiesService tHobbiesService;
	
	private List<HobbiesVo>hobbies;
	/**
	 *分页查询所有爱好信息
	 *@author lw
	 *@return 
	*/
	public String searchList() {
		
		pageBean=tHobbiesService.getHobbiesList(PageBean.DEFAULTPAGESIZE, currentPage);
		
		return SUCCESS;
	}
	
	/**
	 * 得到JSON格式的全部爱好信息
	 * @author lw
	 * @return
	*/
	public String findAllHobbies(){
		
		hobbies=tHobbiesService.findAllHobbies();
		
		return "findsuccess";
	}
	public THobbiesService gettHobbiesService() {
		return tHobbiesService;
	}

	public void settHobbiesService(THobbiesService tHobbiesService) {
		this.tHobbiesService = tHobbiesService;
	}

	public List<HobbiesVo> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<HobbiesVo> hobbies) {
		this.hobbies = hobbies;
	}
}
