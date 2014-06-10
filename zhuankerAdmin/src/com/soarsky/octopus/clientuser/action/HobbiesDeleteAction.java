package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.service.THobbiesService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.THobbies;

public class HobbiesDeleteAction extends BaseAction {

	private static final long serialVersionUID = 4142860837887213240L;
   
    private THobbies  hobbies;
	
	private THobbiesService tHobbiesService;
	
	/**
	 * 删除爱好信息
	 * @author lw
	 * @return
     */
	public String delete() {
		
		tHobbiesService.deleteHobbies(hobbies);
		
		return SUCCESS;
	}

	public THobbies getHobbies() {
		return hobbies;
	}

	public void setHobbies(THobbies hobbies) {
		this.hobbies = hobbies;
	}

	public THobbiesService gettHobbiesService() {
		return tHobbiesService;
	}

	public void settHobbiesService(THobbiesService tHobbiesService) {
		this.tHobbiesService = tHobbiesService;
	}
}
