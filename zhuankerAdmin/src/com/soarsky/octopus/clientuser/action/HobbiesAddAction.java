package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.constant.ClientUserContent;
import com.soarsky.octopus.clientuser.constant.HobbiesErrorMsg;
import com.soarsky.octopus.clientuser.service.THobbiesService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.THobbies;

public class HobbiesAddAction extends BaseAction {

	private static final long serialVersionUID = 8078459921443480656L;
    
	private THobbies  hobbies;
	
	private THobbiesService tHobbiesService;

	/**
	 * 添加爱好信息
	 * @author lw
	 * @return
	*/
	public String save() {
		
		hobbies.setIsRemove(ClientUserContent.NOTROMOVE);
		
		tHobbiesService.addHobbies(hobbies);
		
		return SUCCESS;
	}
    
	/**
	 * 验证添加爱好信息
	 * @author lw
	*/
	public void validateSave(){
		
		Boolean isExist=tHobbiesService.findHobbieByName(hobbies);
		
		if(isExist){
			this.addFieldError(HobbiesErrorMsg.NAMEEXIST,HobbiesErrorMsg.NAMEEXIST_MSG);
		}
		if(hobbies.getTagname().length()<1){
			this.addFieldError(HobbiesErrorMsg.NAME,HobbiesErrorMsg.NAME_MSG);
		}
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
