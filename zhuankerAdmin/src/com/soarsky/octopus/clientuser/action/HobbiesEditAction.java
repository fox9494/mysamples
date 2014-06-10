package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.constant.HobbiesErrorMsg;
import com.soarsky.octopus.clientuser.service.THobbiesService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.THobbies;

public class HobbiesEditAction extends BaseAction {

	private static final long serialVersionUID = -3619300511996537059L;
	
	private THobbies  hobbies;
		
    private THobbiesService tHobbiesService;
    
	/**
	 *初始化要修改的爱好对象
	 *@author lw
	 *@return
	 */
	public String input() {
		
		hobbies=tHobbiesService.initHobbies(hobbies);
		
		return SUCCESS;
	}

	/**
	 * 修改爱好对象
	 * @author lw
	 * @return
	*/
	public String save() {
		
		tHobbiesService.editHobbies(hobbies);
		
		return "editsuccess";
	}
    
	/**
	 * 验证修改爱好信息
	 * @author lw
	*/
	public void validateSave(){
		
		THobbies oldHobbie=tHobbiesService.initHobbies(hobbies);
		
		if(!hobbies.getTagname().equals(oldHobbie.getTagname())){
			Boolean isExist=tHobbiesService.findHobbieByName(hobbies);
			if(isExist){
				this.addFieldError(HobbiesErrorMsg.NAMEEXIST,HobbiesErrorMsg.NAMEEXIST_MSG);
			}
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
